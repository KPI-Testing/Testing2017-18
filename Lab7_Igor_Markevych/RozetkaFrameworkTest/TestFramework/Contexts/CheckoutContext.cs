using OpenQA.Selenium;
using System;
using TestFramework.Extensions;
using TestFramework.Pages;

namespace TestFramework.Contexts

{
    public class CheckoutContext
    {
        public static CheckoutPage InputReceiverData(CheckoutPage page,string name, string phone, string email)
        {
            page.NameAndSurname.SetValue(name);
            page.Phone.SetValue(phone);
            page.Email.SetValue(email);
            Action<IWebElement> act0 = (elem) => { page.ContinueButton.Click(); };
            WaitingExtensions.DoUntilElementIsDisplayed(act0,page.MakeOrderButton, true);
            return page;
        } 
    }
}
