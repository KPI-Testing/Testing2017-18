using TestFramework.Extensions;
using OpenQA.Selenium;

namespace TestFramework.Elements
{
    public class Image : Element
    {
        public Image(IWebElement nativeElement) : base(nativeElement) { }

        public string GetSourceLink()
        {
            var result = Text;
            if (result.IsNullOrEmpty())
                result = GetAttribute("src");
            return Text?.Trim();
        }

        public string GetTitle()
        {
            var result = Text;
            if (result.IsNullOrEmpty())
                result = GetAttribute("title");
            return Text?.Trim();
        }
    }
}
