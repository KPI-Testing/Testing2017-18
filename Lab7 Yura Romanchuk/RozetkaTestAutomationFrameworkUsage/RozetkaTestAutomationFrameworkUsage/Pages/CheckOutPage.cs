using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using RozetkaTestAutomationFrameworkUsage.Elements;

namespace RozetkaTestAutomationFrameworkUsage.Pages
{
    public class CheckOutPage : BasePage
    {
        public CheckOutPage(IWebDriver driver) : base(driver)
        { }

        [FindsBy(How = How.Id, Using = "reciever_name")]
        private IWebElement _name;
        public TextField Name => new TextField(_name);

        [FindsBy(How = How.Id, Using = "suggest_locality")]
        private IWebElement _city;
        public TextField City => new TextField(_city);

        [FindsBy(How = How.Id, Using = "reciever_phone")]
        private IWebElement _phone;
        public TextField Phone => new TextField(_phone);

        [FindsBy(How = How.Id, Using = "reciever_email")]
        private IWebElement _email;
        public TextField Email => new TextField(_email);

        [FindsBy(How = How.CssSelector, Using = ".btn-link.btn-link-green.check-step-btn-link.opaque>button")]
        private IWebElement _continue;
        public Button Continue => new Button(_continue);

        [FindsBy(How = How.Id, Using = "make-order")]
        private IWebElement _makeOrder;
        public Button MakeOrder => new Button(_makeOrder);
        
        [FindsBy(How = How.ClassName, Using = "checkbox")]
        private IWebElement _notCall;
        public CheckBox NotCall => new CheckBox(_notCall);

        public void enter(TextField element, string value)
        {
            element.SendKeys(value);
        }

    }
}
