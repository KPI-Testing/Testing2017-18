using OpenQA.Selenium.Support.UI;
using RozetkaTestAutomationFrameworkUsage.Pages;
using OpenQA.Selenium;
using System;
using System.Reflection;

namespace RozetkaTestAutomationFrameworkUsage.Utils
{
    public class Waiters : BasePage
    {
        public Waiters(IWebDriver driver) : base(driver)
        { }

        public void waitForClickableElement(By bylocator)
        {
            WebDriverWait wait = new WebDriverWait(_driver, TimeSpan.FromSeconds(15));
            wait.Until(ExpectedConditions.ElementToBeClickable(bylocator));
        }

        public void waitForVisibilityElement(By bylocator)
        {
            WebDriverWait wait = new WebDriverWait(_driver, TimeSpan.FromSeconds(15));
            wait.Until(ExpectedConditions.VisibilityOfAllElementsLocatedBy(bylocator));
        }

        public  void WaitUntilElementAppears(IWebElement element)
        {
            bool breakingbool = true;
            int i = 0;
            while (true)
            {
                try
                {
                    element.Click();
                }
                catch (StaleElementReferenceException)
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
                catch(TargetInvocationException)
                {
                    breakingbool = false;
                }
                if (breakingbool) break;
                breakingbool = true;
                i++;
                if (i == 500) throw new Exception("Custom Waiter Timeouted!");
                System.Threading.Thread.Sleep(100);
            }
        }
    }
}
