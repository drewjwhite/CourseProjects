using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Common;
using Common.Business_Objects;

namespace GalaxyCinemas
{
    public class MidDaySpecialPlugin : ISpecialPlugin
    {
        //discount declrred as 0.8 for use in calculation to remove 20%
        decimal discount = 0.8m;
        string specialName = "Mid-day special";

        public bool CalculateSpecial(Booking booking, ref string specialName, ref decimal specialPrice)
        {
            TimeSpan timeOfDay = booking.SessionDate.TimeOfDay;
            // If not mid-day, not applicable.
            // If movie doesn't start between 11am and 1pm
            if (!((timeOfDay.CompareTo(new TimeSpan(11,0,0))>=0) && (timeOfDay.CompareTo(new TimeSpan(13,0,0)) < 0)))
                return false;
            
            // Calculate the discounted price that we would offer.
            decimal discountedPrice = booking.OriginalPrice * discount;

            //MidDaySpecialPlugin pricecheck = new MidDaySpecialPlugin();
            //bool altPrice = pricecheck.CalculateSpecial(booking, ref specialName, ref specialPrice);

            // If this discount is applicable, set specialName and specialPrice to our name and price.
            if (discountedPrice < specialPrice)
            {
                specialPrice = discountedPrice;
                specialName = this.specialName;
                return true;
            }
            else
                return false;
        }
    }
}
