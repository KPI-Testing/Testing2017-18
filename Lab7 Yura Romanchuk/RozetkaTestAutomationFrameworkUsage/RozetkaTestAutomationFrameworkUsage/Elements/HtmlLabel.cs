using OpenQA.Selenium;
using RozetkaTestAutomationFrameworkUsage.Extensions;

namespace RozetkaTestAutomationFrameworkUsage.Elements
{
    public class HtmlLabel : Element
    {
        public HtmlLabel(IWebElement element) : base(element) { }



        public string getText()
        {
            var result = Text;
            if (result.IsNullOrEmpty())
                return null;
            else
            {
                return result;
            }
        }

    }
}
