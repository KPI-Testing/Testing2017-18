using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using TestFramework.Elements;
using TestFramework.Extensions;
using System.Collections.Generic;

namespace TestFramework.Pages
{
    public class FictionBooksPage : BasePage
    {
        public FictionBooksPage(IWebDriver driver) : base(driver)
        { }

        [FindsBy(How = How.Id, Using = "price[min]")]
        private IWebElement _minimumPrice;
        public TextField MinimumPrice => new TextField(_minimumPrice);

        [FindsBy(How = How.Id, Using = "price[max]")]
        private IWebElement _maximumPrice;
        public TextField MaximumPrice => new TextField(_maximumPrice);

        [FindsBy(How = How.CssSelector, Using = ".g-i-tile-i.available")]
        public IList<IWebElement> ResultSet;

        [FindsBy(How = How.Id, Using = "submitprice")]
        private IWebElement _filterByPrice;
        public Button FilterByPrice => new Button(_filterByPrice);


        public FictionBooksPage SetMinimumPrice(int? price)
        {
            if (price == null) return this;
            MinimumPrice.SetValue(price.ToString());
            return this;
        }

        public FictionBooksPage SetMaximumPrice(int? price)
        {
            if (price == null) return this;
            MaximumPrice.SetValue(price.ToString());
            return this;
        }

        public FictionBooksPage SetPrice(int? MinPrice, int? MaxPrice)
        {
            SetMinimumPrice(MinPrice);
            SetMaximumPrice(MaxPrice);
            return this;
        }
        
        public FictionBooksPage SubmitPriceFilter()
        {
            FilterByPrice.Click();
            return this;
        }

        public int? GetMinPrice()
        {
            var stringValue = MinimumPrice.GetValue();
            if (stringValue.IsNullOrEmpty())
                return null;
            else
            {
                int.TryParse(stringValue, out int result);
                return result;
            }
        }

        public int? GetMaxPrice()
        {
            var stringValue = MaximumPrice.GetValue();
            if (stringValue.IsNullOrEmpty())
                return null;
            else
            {
                int.TryParse(stringValue, out int result);
                return result;
            }
        }        
    }
}
