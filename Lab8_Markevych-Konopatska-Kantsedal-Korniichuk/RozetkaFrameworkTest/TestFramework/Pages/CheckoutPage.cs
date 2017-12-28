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

        [FindsBy(How = How.CssSelector, Using = ".check-tabs-m-i[name = \"new_user\"]")]
        private IWebElement tempNewUserButton;
        public RadioButton NewUserButton => new RadioButton(tempNewUserButton);

        [FindsBy(How = How.CssSelector, Using = ".check-tabs-m-i[name = \"member_user\"]")]
        private IWebElement tempMemberUserButton;
        public RadioButton MemberUserButton => new RadioButton(tempMemberUserButton);

        [FindsBy(How = How.CssSelector, Using = "#logo>img")]
        private IWebElement tempLogo;
        public Image Logo => new Image(tempLogo);

        [FindsBy(How = How.Id, Using = "tip_for_input")]
        private IWebElement tempShowAllCities;
        public Button ShowAllCities => new Button(tempShowAllCities);

        [FindsBy(How = How.CssSelector, Using = "#purchases_block>.bill>.check-edit-order>[name=\"edit\"]")]
        private IWebElement tempChangeOrder;
        public Button ChangeOrder => new Button(tempChangeOrder);

    }
}
