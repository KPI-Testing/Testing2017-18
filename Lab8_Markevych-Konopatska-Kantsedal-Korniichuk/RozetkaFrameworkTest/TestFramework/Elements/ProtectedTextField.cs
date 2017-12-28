using OpenQA.Selenium;
using TestFramework.Extensions;

namespace TestFramework.Elements
{
    public class ProtectedTextField : TextField
    {
        public ProtectedTextField(IWebElement nativeElement) : base(nativeElement) { }

        public new void Clear()
        {
            
        }

    }
}
