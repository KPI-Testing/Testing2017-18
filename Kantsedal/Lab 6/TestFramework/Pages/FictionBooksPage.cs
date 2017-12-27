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

        [FindsBy(How = How.Id, Using = "submitprice")]
        public IWebElement FilterByPrice;

        [FindsBy(How = How.CssSelector, Using = ".g-i-tile-i.available")]
        public System.Collections.Generic.IList<IWebElement> books;

        public FictionBooksPage SetMinimumPrice(int? price)
        {
            if (price == null) return this;
            MinimumPrice.SendKeys(price.ToString());
            return this;
        }
   public FictionBooksPage SomeBookClick(int i)
        {
            books[i-1].Click();
     
            return this;
        }
        public FictionBooksPage SetMaximumPrice(int? price)
        {
            if (price == null) return this;
            MaximumPrice.SendKeys(price.ToString());
            return this;
        }

        public FictionBooksPage SubmitPriceFilter()
        {
            FilterByPrice.SendKeys(Keys.Enter);
            return this;
        }
        public FictionBooksPage ClearMaxPrice()
        {
            //MinimumPrice.SendKeys(Keys.Clear);
            MaximumPrice.SendKeys(Keys.Control + "a");
            MaximumPrice.SendKeys(Keys.Delete);
            return this;
        }
        public FictionBooksPage ClearMinPrice()
        {
            //MinimumPrice.SendKeys(Keys.Clear);
            MinimumPrice.SendKeys(Keys.Control+"a");
            MinimumPrice.SendKeys(Keys.Delete);
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
    }
}
