using TestFramework.Extensions;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;

namespace TestFramework.Elements
{
    public class Checkbox : Element
    {
        public Checkbox(IWebElement nativeElement) : base(nativeElement) { }

        public string GetText()
        {
            var result = Text;
            if (result.IsNullOrEmpty())
                result = GetAttribute("value");
            return Text.Trim();  
        }
    }
}
