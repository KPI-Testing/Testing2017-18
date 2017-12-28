using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using System.Collections.Generic;
using System.Linq;
using TestFramework.Elements;

namespace TestFramework.Pages
{
    public class CartPageWithOrders : BaseCartPage
    {
        public CartPageWithOrders(IWebDriver driver) : base(driver)
        { }

        [FindsBy(How = How.Id, Using = "popup-checkout")]
        private IWebElement tempProceedAnOrder;
        public Button ProceedAnOrder => new Button(tempProceedAnOrder);

        [FindsBy(How = How.CssSelector, Using = ".cart-return-link>.btn-link.btn-link-gray>[name='close']")]
        private IWebElement tempProceedBuying;
        public Button ProceedBuying => new Button(tempProceedBuying);

        [FindsBy(How = How.CssSelector, Using = ".cart-check-icon.sprite")]
        public IList<IWebElement> tempDeleteProductButtonsSet;
        public IList<Button> DeleteProductButtonsSet
        {
            get
            {
                return tempDeleteProductButtonsSet.Select(iwebe => new Button(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = ".cart-i-img.cart-added-img>a>img")]
        public IList<IWebElement> tempProductsImageSet;
        public IList<Image> ProductsImageSet
        {
            get
            {
                return tempProductsImageSet.Select(iwebe => new Image(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = ".cart-uah.cart-sum-uah>[name=\"sum\"]")]
        public IList<IWebElement> tempSumPriceForOneTypeOfProductSet;
        public IList<HtmlLabel> SumPriceForOneTypeOfProductSet
        {
            get
            {
                return tempSumPriceForOneTypeOfProductSet.Select(iwebe => new HtmlLabel(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = ".cart-i-price>.cart-uah")]
        public IList<IWebElement> tempPriceForOneTypeOfProductSet;
        public IList<HtmlLabel> PriceForOneTypeOfProductSet
        {
            get
            {
                return tempPriceForOneTypeOfProductSet.Select(iwebe => new HtmlLabel(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = ".novisited.cart-i-title-link")]
        public IList<IWebElement> tempProductsLinksSet;
        public IList<Link> ProductsLinksSet
        {
            get
            {
                return tempProductsLinksSet.Select(iwebe => new Link(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = ".cart-total-uah>[name=\"cost\"]")]
        private IWebElement tempTotalSum;
        public HtmlLabel TotalSum => new HtmlLabel(tempTotalSum);

        [FindsBy(How = How.CssSelector, Using = ".cart-amount-plus-icon.sprite")]
        public IList<IWebElement> tempAmountPlusButtonsSet;
        public IList<Button> AmountPlusButtonsSet
        {
            get
            {
                return tempAmountPlusButtonsSet.Select(iwebe => new Button(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = ".cart-amount-minus")]
        public IList<IWebElement> tempAmountMinusButtonsSet;
        public IList<Button> AmountMinusButtonsSet
        {
            get
            {
                return tempAmountMinusButtonsSet.Select(iwebe => new Button(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = ".input-text.cart-amount-input-text")]
        public IList<IWebElement> tempAmountTextFieldSet;
        public IList<ProtectedTextField> AmountTextFieldSet
        {
            get
            {
                return tempAmountTextFieldSet.Select(iwebe => new ProtectedTextField(iwebe)).ToList();
            }
        }

        public string GetProductName (int n)
        {
            return ProductsLinksSet[n].Text;
        }

        public int GetPriceForType(int n)
        {
            var stringValue = PriceForOneTypeOfProductSet[n].GetText();
            int.TryParse(stringValue, out int result);
            return result;
        }

        public string GetImageSrc(int n)
        {
            return ProductsImageSet[n].GetSourceLink();
        }

    }
}
