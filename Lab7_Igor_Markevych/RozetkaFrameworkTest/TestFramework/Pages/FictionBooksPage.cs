using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using TestFramework.Elements;
using TestFramework.Extensions;
using System.Collections.Generic;
using System.Linq;

namespace TestFramework.Pages
{
    public class FilterPage : BasePage
    {
        public FilterPage(IWebDriver driver) : base(driver)
        {}

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

        [FindsBy(How = How.CssSelector, Using = ".sprite-side.btn-link.g-buy-submit-light")]
        public IList<IWebElement> tempBuyButtonSet;
        public IList<Button> BuyButtonSet
        {
            get
            {
                return tempBuyButtonSet.Select(iwebe => new Button(iwebe)).ToList();
            }
        }


        [FindsBy(How = How.CssSelector, Using = "[id*=\"filter_izdatelstvo\"]")]
        public IList<IWebElement> tempCheckboxSet;
        public IList<Checkbox> CheckboxIzdSet
        {
            get
            {
                return tempCheckboxSet.Select(iwebe =>new Checkbox(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = "[name=\"filter_parameters_block\"][param*=\"izdatelstvo\"]>[name=\"filter_parameters\"]>[name=\"show_more_parameters\"]")]
        public IWebElement tempMoreButton;
        public Button MoreIzdButton => new Button(tempMoreButton);
        

        public FilterPage SetMinimumPrice(int? price)
        {
            if (price == null) return this;
            MinimumPrice.SetValue(price.ToString());
            return this;
        }

        public FilterPage SetMaximumPrice(int? price)
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
