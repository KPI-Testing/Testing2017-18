using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using TestFramework.Elements;

namespace TestFramework.Pages
{
    public class CheckoutPage : BasePage
    {
        public CheckoutPage(IWebDriver driver) : base(driver)
        { }

        [FindsBy(How = How.Id, Using = "reciever_name")]
        private IWebElement tempNameAndSurname;
        public TextField NameAndSurname => new TextField(tempNameAndSurname);

        [FindsBy(How = How.Id, Using = "reciever_phone")]
        private IWebElement tempPhone;
        public TextField Phone => new TextField(tempPhone);

        [FindsBy(How = How.Id, Using = "reciever_email")]
        private IWebElement tempEmail;
        public TextField Email => new TextField(tempEmail);

        [FindsBy(How = How.CssSelector, Using = ".btn-link.btn-link-green.check-step-btn-link.opaque>button")]
        private IWebElement tempContinueButton;
        public Button ContinueButton => new Button(tempContinueButton);

        [FindsBy(How = How.Id, Using = "make-order")]
        private IWebElement tempMakeOrderButton;
        public Button MakeOrderButton => new Button(tempMakeOrderButton);

        [FindsBy(How = How.Id, Using = "step_delivery")]
        private IWebElement tempDeliveryBlock;
        public HtmlLabel DeliveryBlock => new HtmlLabel(tempDeliveryBlock);

    }
}
