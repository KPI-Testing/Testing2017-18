using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;

namespace TestFramework.Pages
{
    public class QuadrPage
    {
        private IWebDriver _driver;

        public QuadrPage(IWebDriver driver)
        {
            _driver = driver;
            PageFactory.InitElements(driver, this);
        }

        [FindsBy(How = How.Id, Using = "price[min]")]
        public IWebElement MinimumPrice;

        [FindsBy(How = How.Id, Using = "price[max]")]
        public IWebElement MaximumPrice;

        [FindsBy(How = How.CssSelector, Using = ".g-i-tile-i.available")]
        public System.Collections.Generic.IList<IWebElement> Element;

        [FindsBy(How = How.Id, Using = "submitprice")]
        public IWebElement FilterByPrice;

        public QuadrPage SetMinimumPrice(int? price)
        {
            if (price == null) return this;
            MinimumPrice.SendKeys(Keys.Control + "a");
            MinimumPrice.SendKeys(Keys.Delete);

            MinimumPrice.SendKeys(price.ToString());
            return this;
        }

        public QuadrPage SetMaximumPrice(int? price)
        {
            if (price == null) return this;
            MaximumPrice.SendKeys(Keys.Control + "a");
            MaximumPrice.SendKeys(Keys.Clear);
            MaximumPrice.SendKeys(price.ToString());
            return this;
        }


        public QuadrPage SetPrice(int? MinPrice, int? MaxPrice)
        {
            SetMinimumPrice(MinPrice);
            SetMaximumPrice(MaxPrice);
            return this;
        }

        public QuadrPage SubmitPriceFilter()
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

       

    }
    
}
