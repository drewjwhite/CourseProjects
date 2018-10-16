using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Common;
using Common.Business_Objects;

namespace GalaxyCinemas
{
    public class TuesdaySpecialPlugin : ISpecialPlugin
    {
        decimal specialLimit = 5m;
        decimal specialPrice = 11m;
        string specialName = "Tuesday special";

        public bool CalculateSpecial(Booking booking, ref string specialName, ref decimal specialPrice)
        {
            // If not Tuesday, not applicable.
            if (booking.SessionDate.DayOfWeek != DayOfWeek.Tuesday)
                return false;
            
            // Get base unit price.
            decimal basePrice;
            basePrice = booking.OriginalPrice / booking.Quantity;
            
            // Calculate the discounted price that we would offer.
            decimal discountedPrice = 0.0m;
            if (booking.Quantity <= specialLimit)            
                discountedPrice = booking.Quantity * this.specialPrice;            
            else
                discountedPrice = ((booking.Quantity - specialLimit) * basePrice) + (specialLimit * this.specialPrice);

            //Compare discounted price with original price
            // If this discount is applicable, set specialName and specialPrice to our name and price.
            if (discountedPrice < booking.OriginalPrice)
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
