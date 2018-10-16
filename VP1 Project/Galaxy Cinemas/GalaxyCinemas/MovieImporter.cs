using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.IO;
using Common;
using Common.Business_Objects;
using GalaxyCinemas.DataLayer;

namespace GalaxyCinemas
{
    public class MovieImporter : BaseImporter
    {
        public MovieImporter(string fileName) : base(fileName) { }

        /// <summary>
        /// Import movie file. Filename has been provided in the constructor.
        /// </summary>
        public override void Import(object o)
        {
            // Initialise progress to zero for progress bar. 
            Progress = 0f;
            ImportResult results = new ImportResult();

            try
            {
                // Read file
                string fileData = null;
                using (StreamReader reader = File.OpenText(fileName))
                {
                    // Read file  using ReadToEnd
                    fileData = reader.ReadToEnd();
                }
                string[] lines = fileData.Replace("\r\n", "\n").Replace("\r", "\n").Split('\n'); // To deal with Windows, Mac and Linux line endings the same.

                // Check if first line is column names.
                string firstLine = lines[0]; //receives first line of file import

                //Sets the first line of the lines array to blank to remove column headings in csv file
                string[] columns = firstLine.Split(',');
                string column1 = columns[0].ToLower().Trim();
                string column2 = columns[1].ToLower().Trim();
                if (columns.Length == 2 && column1.Equals("movieid") && column2.Equals("title"))
                {
                    lines[0] = "";
                }

                // Line count and line numbers to allow progress tracking.
                int lineCount = lines.Length; //for use by the progress bar
                int lineNum = 1; //for tracking importing and creating error messages

                // Get all movies.                
                List<Movie> movies = DataLayer.DataLayer.GetAllMovies();

                foreach (string line in lines)
                // Check whether we need to stop after importing each line.
                {
                    if (Stop)
                    {
                        return;
                    }


                    // Just to make it slow enough to test stopping functionality.
                    Thread.Sleep(500);

                    // Update progress of import.
                    try
                    {
                        //THIS WILL NEED MORE CODE AROUND PROGRESS UPDATE: STEP 25, PAGE 1-71
                        Progress = lineNum / lineCount;
                        RaiseProgressChanged();

                        // Skip blank lines
                        if (String.IsNullOrEmpty(line))
                            continue;
                        else
                            results.TotalRows = results.TotalRows++;

                        // Break up line by commas, each item in array will be one column.
                        columns = line.Split(',');
                        if (columns.Length != 2)
                        {
                            results.FailedRows++;
                            results.ErrorMessages.Add(string.Format("Line {0}: Wrong number of columns.", lineNum));
                            continue;
                        }

                        // Check the format of data, and update ImportResult accordingly.
                        int movieID = 0;
                        if (!int.TryParse(columns[0], out movieID))
                        {
                            results.FailedRows++;
                            results.ErrorMessages.Add(string.Format("Line {0}: MovieID is not a number.", lineNum));
                            continue;
                        }

                        //Check that the title field contains a string
                        string title = "";
                        title = columns[1].Trim();
                        if (String.IsNullOrEmpty(title))
                        {
                            results.FailedRows = results.FailedRows++;
                            results.ErrorMessages.Add(string.Format("Line {0}: Movie title is blank.", lineNum));
                            continue;
                        }


                        // Insert/update DB if okay.
                        Movie movieToUpdate = movies.Where(m => m.MovieID == movieID).FirstOrDefault();
                        if (movieToUpdate == null)
                        {
                            Movie movieToAdd = new Movie() { MovieID = movieID, Title = title };
                            DataLayer.DataLayer.AddMovie(movieToAdd);
                        }
                        else
                        {
                            movieToUpdate.Title = title;
                            DataLayer.DataLayer.UpdateMovie(movieToUpdate);
                        }
                        results.ImportedRows = results.ImportedRows++; //Successfully imported row
                    }
                    catch
                    {
                        results.ErrorMessages.Add(string.Format("Line {0}: Some unknown error within the foreach loop.", lineNum));
                    }
                    finally
                    {
                        lineNum++;
                    }
                }
            }
            catch (IOException)
            {
                results.ErrorMessages.Add(String.Format("An Input/Output error has occurred."));

            }
            catch (Exception)
            {
                results.ErrorMessages.Add(String.Format("A general exception has occurred. Program better bozo!"));
            }
            finally
            {
                RaiseCompleted(results);
            }
        }
    }
}
