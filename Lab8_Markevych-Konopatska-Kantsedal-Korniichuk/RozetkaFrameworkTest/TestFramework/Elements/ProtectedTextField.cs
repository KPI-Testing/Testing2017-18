using OpenQA.Selenium;
using TestFramework.Extensions;

namespace TestFramework.Elements
{
    public class ProtectedTextField : TextField
    {
        public ProtectedTextField(IWebElement nativeElement) : base(nativeElement) { }

        public new void Clear()
        {
            for (int i=0; i<5; i++)
                this.SendKeys(Keys.Delete);
        }

        public new void SetValue(string value)
        {
            Clear();
            SendKeys(value);
        }

    }
}
