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
            public IWebDriver GetDriver()
        {
            return _driver;
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
            string urlbefor = this.GetDriver().ToString();
            string urlafter = this.GetDriver().ToString();
            int k = 1000;
            do
            {
                System.Threading.Thread.Sleep(k);
                books[1].Click();
                k = k + k;
                urlafter = this.GetDriver().ToString();
            } while (!(urlafter.CompareTo(urlbefor) == 0) || (k > 10000));


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
