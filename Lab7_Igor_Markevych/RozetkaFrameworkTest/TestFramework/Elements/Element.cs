using OpenQA.Selenium;
using System.Drawing;
using System.Collections.ObjectModel;

namespace TestFramework.Elements
{
    public class Element : IWebElement
    {
        public Element(IWebElement nativeElement)
            => _nativeElement = nativeElement;

        private IWebElement _nativeElement;
        
        public void Clear() => _nativeElement.Clear();

        public void SendKeys(string value) => _nativeElement.SendKeys(value);

        public void Submit() => _nativeElement.Submit();

        public void Click() => _nativeElement.Click();

        public string GetAttribute(string attributeName) => _nativeElement.GetAttribute(attributeName);

        public string GetProperty(string propertyName) => _nativeElement.GetProperty(propertyName);

        public string GetCssValue(string propertyName) => _nativeElement.GetCssValue(propertyName);

        public string TagName => _nativeElement.TagName;

        public string Text => _nativeElement.Text;

        public bool Enabled => _nativeElement.Enabled;

        public bool Selected => _nativeElement.Selected;

        public Point Location => _nativeElement.Location;

        public Size Size => _nativeElement.Size;

        public bool Displayed => _nativeElement.Displayed;

        public IWebElement FindElement(By by) => _nativeElement.FindElement(by);

        public ReadOnlyCollection<IWebElement> FindElements(By by) => _nativeElement.FindElements(by);
    }
}
