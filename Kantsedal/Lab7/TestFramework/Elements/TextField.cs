using OpenQA.Selenium;
using TestFramework.Extensions;

namespace TestFramework.Elements
{
    public class TextField : Element
    {
        public TextField(IWebElement nativeElement) : base (nativeElement){ }
        public new void Clear()
        {
            SendKeys(Keys.Control + "a");
            SendKeys(Keys.Delete);
        }

        public void SetValue(string value)
        {
            Clear();
            SendKeys(value);
        }

        public void AppendText(string value)
        {
            SendKeys(value);
        }

        public string GetValue()
            => Text.IsNullOrEmpty() ? GetAttribute("value") : Text;        
    }
}
