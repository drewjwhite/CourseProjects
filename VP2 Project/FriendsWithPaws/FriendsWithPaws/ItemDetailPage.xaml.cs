using FriendsWithPaws.Data;
using Callisto.Controls;
using Windows.UI.StartScreen;
using Windows.UI.Notifications;
using Windows.UI.Popups;
using Windows.Data.Xml.Dom;
using Windows.ApplicationModel.DataTransfer;
using System.Text;
using Windows.Storage.Streams;

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// The Item Detail Page item template is documented at http://go.microsoft.com/fwlink/?LinkId=234232

namespace FriendsWithPaws
{
    /// <summary>
    /// A page that displays details for a single item within a group while allowing gestures to
    /// flip through other items belonging to the same group.
    /// </summary>
    public sealed partial class ItemDetailPage : FriendsWithPaws.Common.LayoutAwarePage
    {
        public ItemDetailPage()
        {
            this.InitializeComponent();
        }

        /// <summary>
        /// Populates the page with content passed during navigation.  Any saved state is also
        /// provided when recreating a page from a prior session.
        /// </summary>
        /// <param name="navigationParameter">The parameter value passed to
        /// <see cref="Frame.Navigate(Type, Object)"/> when this page was initially requested.
        /// </param>
        /// <param name="pageState">A dictionary of state preserved by this page during an earlier
        /// session.  This will be null the first time a page is visited.</param>
        protected override void LoadState(Object navigationParameter, Dictionary<String, Object> pageState)
        {
            // Allow saved page state to override the initial item to display
            if (pageState != null && pageState.ContainsKey("SelectedItem"))
            {
                navigationParameter = pageState["SelectedItem"];
            }

            // TODO: Create an appropriate data model for your problem domain to replace the sample data
            var item = BreedDataSource.GetItem((String)navigationParameter);
            this.DefaultViewModel["Group"] = item.Group;
            this.DefaultViewModel["Items"] = item.Group.Items;
            this.flipView.SelectedItem = item;

            //register for DataRequest events
            DataTransferManager.GetForCurrentView().DataRequested += OnDataRequested;
        }

        /// <summary>
        /// Preserves state associated with this page in case the application is suspended or the
        /// page is discarded from the navigation cache.  Values must conform to the serialization
        /// requirements of <see cref="SuspensionManager.SessionState"/>.
        /// </summary>
        /// <param name="pageState">An empty dictionary to be populated with serializable state.</param>
        protected override void SaveState(Dictionary<String, Object> pageState)
        {
            var selectedItem = (BreedDataItem)this.flipView.SelectedItem;
            pageState["SelectedItem"] = selectedItem.UniqueId;

            //de-register for DataRequest events
            DataTransferManager.GetForCurrentView().DataRequested -= OnDataRequested;
        }

        private async void OnPinBreedButtonClicked(object sender, RoutedEventArgs e)
        {
            var item = (BreedDataItem)this.flipView.SelectedItem;
            var uri = new Uri(item.TileImagePath.AbsoluteUri);
            var tile = new SecondaryTile(item.UniqueId, item.ShortTitle, item.Title, item.UniqueId, TileOptions.ShowNameOnLogo, uri);
            await tile.RequestCreateAsync();
        }

        //Create two reminders from App Bar
        private async void OnReminderButtonClicked(object sender, RoutedEventArgs e)
        {
            var notifier = ToastNotificationManager.CreateToastNotifier();
            if (notifier.Setting != NotificationSetting.Enabled)
            {
                var dialog = new MessageDialog("Notifications are currently disabled");
                await dialog.ShowAsync();
                return;
            }
            //Add first reminder notification
            var template1 = ToastNotificationManager.GetTemplateContent(ToastTemplateType.ToastText01);
            var element1 = template1.GetElementsByTagName("text")[0];
            element1.AppendChild(template1.CreateTextNode("Reminder! Check Friends With Paws."));
            var date1 = DateTimeOffset.Now.AddSeconds(15);
            var stn1 = new ScheduledToastNotification(template1, date1);
            notifier.AddToSchedule(stn1);
            //Add second reminder notification
            var template2 = ToastNotificationManager.GetTemplateContent(ToastTemplateType.ToastImageAndText01);
            var element2 = template2.GetElementsByTagName("text")[0];
            element2.AppendChild(template2.CreateTextNode("Please check what is new with Friends With Paws."));
            //Add the logo to the notification
            XmlElement tileImage = (XmlElement)template2.GetElementsByTagName("image")[0];
            tileImage.SetAttribute("src", "Assets/Logo.png");
            tileImage.SetAttribute("alt", "Friends With Paws");
            //Set the notification duration to 25 seconds
            IXmlNode toastNode = template2.SelectSingleNode("/toast");
            ((XmlElement)toastNode).SetAttribute("duration", "long");
            
            var date2 = DateTimeOffset.Now.AddSeconds(60);
            var stn2 = new ScheduledToastNotification(template2, date2);                        
            notifier.AddToSchedule(stn2);
            //Uncomment following two linies to implement notification implemented message if desired
            //var dialog2 = new MessageDialog("Notifications created!");
            //await dialog2.ShowAsync();
        }

        void OnDataRequested(DataTransferManager sender, DataRequestedEventArgs args)
        {
            var request = args.Request;
            //Assemble text to be shared
            var item = (BreedDataItem)this.flipView.SelectedItem;
            request.Data.Properties.Title = item.Title;
            request.Data.Properties.Description = "Breed details and description";
            var breed = "\r\nBreed Details\r\n";
            breed += String.Join("\r\n", item.Breed_details);
            breed += ("\r\n\r\nDescription\r\n" + item.Description);
            request.Data.SetText(breed);

            //Share image to accompany text
            var reference = RandomAccessStreamReference.CreateFromUri(new Uri(item.ImagePath.AbsoluteUri));
            request.Data.Properties.Thumbnail = reference;
            request.Data.SetBitmap(reference);

        }
    }
}
