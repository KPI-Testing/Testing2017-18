using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using System.Collections.Generic;

namespace PageObjects.Pages
{
    public class RozetkaBooksPage : BasePage
    {
        public RozetkaBooksPage(IWebDriver driver) : base(driver)
        {}

        [FindsBy(How = How.Id, Using = "price[min]")]
        public IWebElement MinimumPrice;

        [FindsBy(How = How.Id, Using = "price[max]")]
        public IWebElement MaximumPrice;

        [FindsBy(How = How.Id, Using = "submitprice")]
        public IWebElement FilterByPrice;

        [FindsBy(How = How.CssSelector, Using = ".g-i-tile-i.available")]
        public IList<IWebElement> Links;

        public RozetkaBooksPage SetMinimumPrice(int? price)
        {
            if (price == null) return this;
            MinimumPrice.SendKeys(Keys.Control + "a");
            MinimumPrice.SendKeys(Keys.Delete);
            MinimumPrice.SendKeys(price.ToString());
            return this;
        }


        public RozetkaBooksPage SubmitPriceFilter()
        {
            FilterByPrice.Click();
            return this;
        }

        public RozetkaBooksPage ClickOnFirstElement()
        {
            Links[0].Click();
            return this;
        }

        public int? GetMinPrice()
        {
            var stringValue = MinimumPrice.GetAttribute("value");
            if (stringValue == null | stringValue == "")
                return null;
            else
            {
                int result;
                int.TryParse(stringValue, out result);
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
                int result;
                int.TryParse(stringValue, out result);
                return result;
            }
        }
    }
}
