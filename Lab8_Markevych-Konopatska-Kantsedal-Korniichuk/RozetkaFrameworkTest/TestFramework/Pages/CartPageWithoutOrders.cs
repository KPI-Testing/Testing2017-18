using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using System.Collections.Generic;
using System.Linq;
using TestFramework.Elements;

namespace TestFramework.Pages
{
    public class CartPageWithoutOrders : BaseCartPage
    {
        public CartPageWithoutOrders(IWebDriver driver) : base(driver)
        { }

        [FindsBy(How = How.CssSelector, Using = ".novisited.arrow-link.cart-news-more-link>.arrow-link-inner")]
        private IWebElement tempSeeAllPromos;
        public Link SeeAllPromos => new Link(tempSeeAllPromos);

        [FindsBy(How = How.CssSelector, Using = ".empty-cart-title.inline.sprite-side")]
        private IWebElement tempCartIsEmpty;
        public HtmlLabel CartIsEmpty => new HtmlLabel(tempCartIsEmpty);

        [FindsBy(How = How.CssSelector, Using = ".cart-promotions-i-img.novisited>img")]
        public IList<IWebElement> tempAdvertisementSet;
        public IList<Image> AdvertisementSet
        {
            get
            {
                return tempAdvertisementSet.Select(iwebe => new Image(iwebe)).ToList();
            }
        }

        [FindsBy(How = How.CssSelector, Using = ".paginator-link")]
        public IList<IWebElement> tempAdvertisementScrollButtonsSet;
        public IList<RadioButton> AdvertisementScrollButtonsSet
        {
            get
            {
                return tempAdvertisementScrollButtonsSet.Select(iwebe => new RadioButton(iwebe)).ToList();
            }
        }
        
    }
}
