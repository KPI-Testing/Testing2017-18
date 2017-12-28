using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;


namespace PageObjects.Pages
{
    public class GoogleHomePage : BasePage
    {
        public GoogleHomePage(IWebDriver driver) : base(driver)
        { }

        [FindsBy(How = How.Id, Using = "lst-ib")]
        public IWebElement InputField;

        [FindsBy(How = How.Name, Using = "btnK")]
        public IWebElement SearchWord;

        [FindsBy(How = How.CssSelector, Using = "#pnnext > span:nth-child(2)")]
        public IWebElement ForwardWord;

        [FindsBy(How = How.ClassName, Using = "cur")]
        public IWebElement CurWord;

        public GoogleHomePage SetWord(string word)
        {
            if (word == null) return this;
            InputField.SendKeys(word);
            return this;
        }

        public GoogleHomePage SubmitSearchWord()
        {
            SearchWord.SendKeys(Keys.Enter);
            return this;
        }

    }
}
