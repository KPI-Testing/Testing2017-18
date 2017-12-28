using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Reflection;
using TestFramework.Pages;

namespace TestFramework.Extensions
{
    class WaitingExtensions
    {
        public static void WaitUntilElementAppears(Action<IWebElement> act, IWebElement elem) {
            bool breakingbool = true;
            int i = 0;
            while (true)
            {
                try {
                    act(elem);
                }
                catch (StaleElementReferenceException) {
                    breakingbool = false;
                }
                catch (TargetInvocationException)
                {
                    breakingbool = false;
                }
                catch (InvalidOperationException)
                {
                    breakingbool = false;
                }
                catch (NoSuchElementException)
                {
                    breakingbool = false;
                }
                if (breakingbool) break;
                breakingbool = true;
                i++;
                if (i == 200) throw new Exception("Custom Waiter Timeouted!");
                System.Threading.Thread.Sleep(100);
            }
        }

        public static void DoUntilAnotherElementIsEnabled(Action act,IWebElement elem)
        {
            bool breakingbool = true;
            int i = 0;
            while (true)
            {
                act();
                if (!elem.Enabled) breakingbool = false;
                if (breakingbool) break;
                breakingbool = true;
                i++;
                if (i == 200) throw new Exception("Custom Waiter Timeouted!");
                System.Threading.Thread.Sleep(100);
                Console.WriteLine(i);
            }
        }

        public static void DoUntilElementIsDisplayed(Action<IWebElement> act, IWebElement elem, bool ignoreexception)
        {
            bool breakingbool = true;
            int i = 0;
            while (true)
            {
                act(elem);
                if (!elem.Displayed) breakingbool = false;
                i++;
                if (i == 200)
                {
                    if (!ignoreexception)
                        throw new Exception("Custom Waiter Timeouted!");
                    breakingbool = true;
                }
                if (breakingbool) break;
                breakingbool = true;
                System.Threading.Thread.Sleep(100);
            }
        }


        public static void WaitUntilUrlIsChanged(BasePage page, string url)
        {
            int i = 0;
            while (url == page.GetDriver().Url)
            {
                i++;
                System.Threading.Thread.Sleep(50);
                if (i==200) throw new Exception("Custom Waiter Timeouted!");
            }
        }
    }
}
