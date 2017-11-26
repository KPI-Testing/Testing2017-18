using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;

namespace TestFramework.Pages
{
    public class FictionBooksPage
    {
        private IWebDriver _driver;

        public FictionBooksPage(IWebDriver driver)
        {
            _driver = driver;
            PageFactory.InitElements(driver, this);
        }

        [FindsBy(How = How.Id, Using = "price[min]")]
        public IWebElement MinimumPrice;

        [FindsBy(How = How.Id, Using = "price[max]")]
        public IWebElement MaximumPrice;

        [FindsBy(How = How.CssSelector, Using = ".g-i-tile-i.available")]
        public System.Collections.Generic.IList<IWebElement> FirstElement;

        [FindsBy(How = How.Id, Using = "submitprice")]
        public IWebElement FilterByPrice;

        [FindsBy(How = How.Id, Using = "price_label")]
        public IWebElement Price;

        public FictionBooksPage SetMinimumPrice(int? price)
        {
            if (price == null) return this;
            //MinimumPrice.Click();
            MinimumPrice.SendKeys(Keys.Control + "a");
            MinimumPrice.SendKeys(Keys.Delete);
            MinimumPrice.SendKeys(price.ToString());
            return this;
        }

        public FictionBooksPage SetMaximumPrice(int? price)
        {
            if (price == null) return this;
            //MaximumPrice.Click();
            MaximumPrice.SendKeys(Keys.Control + "a");
            MaximumPrice.SendKeys(Keys.Delete);
            MaximumPrice.SendKeys(price.ToString());
            return this;
        }


        public FictionBooksPage SetPrice(int? MinPrice, int?MaxPrice)
        {
            SetMinimumPrice(MinPrice);
            SetMaximumPrice(MaxPrice);
            return this;
        }


        public FictionBooksPage SubmitPriceFilter()
        {
            FilterByPrice.SendKeys(Keys.Enter);
            return this;
        }

        public int? GetMinPrice()
        {
            var stringValue = MinimumPrice.GetAttribute("value");
            if (stringValue == null | stringValue == "")
                return null;
            else
            {
                int.TryParse(stringValue, out int result);
                return result;
            }
        }

        public int? GetMaxPrice()
        {
            var stringValue = MaximumPrice.GetAttribute("value");
            if (stringValue == null | stringValue == "")
                return null;
            else
            {
                int.TryParse(stringValue, out int result);
                return result;
            }
        }

        public int? GetPrice()
        {
            var stringValue = Price.Text;
            if (stringValue == null | stringValue == "")
                return null;
            else
            {
                int.TryParse(stringValue, out int result);
                return result;
            }
        }
    }
}
