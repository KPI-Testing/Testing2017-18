using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using RozetkaTestAutomationFrameworkUsage.Elements;
using System.Collections.Generic;
using RozetkaTestAutomationFrameworkUsage.Extensions;
using System.Linq;

namespace RozetkaTestAutomationFrameworkUsage.Pages
{
    public class WineListPage : BasePage
    {
        public WineListPage(IWebDriver driver) : base(driver)
        { }

        public string locResSet = ".g-i-tile-i.available";
        public string locLinkMore = "show_more_parameters";
        public string locFilter = "submitprice";

        [FindsBy(How = How.Id, Using = "price[min]")]
        private IWebElement _minimumPrice;
        public TextField MinimumPrice => new TextField(_minimumPrice);

        [FindsBy(How = How.Id, Using = "price[max]")]
        private IWebElement _maximumPrice;
        public TextField MaximumPrice => new TextField(_maximumPrice);

        [FindsBy(How = How.XPath, Using = "//*[@id='sort_strana-vino']/li/label")]      
        private IList<IWebElement> _listOfCountry;
        public IList<HtmlLabel> listOfCountry
        {
            get
            {
                return _listOfCountry.Select(iwebe => new HtmlLabel(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = "input[type='checkbox']")]
        private IWebElement _country;
        public CheckBox Country => new CheckBox(_country);

        [FindsBy(How = How.CssSelector, Using = ".g-i-tile-i.available")]
        public IList<IWebElement> ResultSet;

        [FindsBy(How = How.Name, Using = "show_more_parameters")]
        public IWebElement LinkMore;

        [FindsBy(How = How.Id, Using = "submitprice")]
        private IWebElement _filterByPrice;
        public Button FilterByPrice => new Button(_filterByPrice);

        public WineListPage SetMinimumPrice(int? price)
        {
            if (price == null) return this;
            MinimumPrice.SetValue(price.ToString());
            return this;
        }

        public WineListPage SetMaximumPrice(int? price)
        {
            if (price == null) return this;
            MaximumPrice.SetValue(price.ToString());
            return this;
        }

        public int? GetMinPrice()
        {
            var stringValue = MinimumPrice.GetValue();
            if (stringValue.IsNullOrEmpty())
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
            var stringValue = MaximumPrice.GetValue();
            if (stringValue.IsNullOrEmpty())
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
