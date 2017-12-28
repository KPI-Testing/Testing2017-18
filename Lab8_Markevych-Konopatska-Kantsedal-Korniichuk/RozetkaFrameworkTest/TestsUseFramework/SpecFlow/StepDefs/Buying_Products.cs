using OpenQA.Selenium;
using System;
using TechTalk.SpecFlow;
using TestFramework.Contexts;
using TestFramework.Pages;

namespace TestsUseFramework.SpecFlow.StepDefs
{
    [Binding]
    public class Buying_Products
    {
        [Given(@"Product is in the cart with quantity (.*)")]
        public void GivenProductIsInTheBasketWithQuantity(int q)
        {
            ResultSetContext.BuyElement(Driver_init.booksResultsPage, 0);
            CartContext.ClickPlusButton(Driver_init.BasketPageWithOrders, q - 1);
        }
    }
}
