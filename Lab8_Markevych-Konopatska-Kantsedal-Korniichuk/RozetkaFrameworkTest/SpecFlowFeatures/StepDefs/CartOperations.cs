using System;
using TechTalk.SpecFlow;
using TestFramework.Contexts;

namespace TestsUseFramework.SpecFlow.StepDefs
{
    [Binding]
    public class CartOperations
    {
        [When(@"You enter (.*) in the (.*) field with number of the product")]
        public void WhenYouEnterInTheFieldWithNumberOfTheProduct(string p0, int p1)
        {
            CartContext.EnterInQuantityField(Driver_init.CartPageWithOrders, p0, p1);
        }

        [When(@"Press Продолжить покупки")]
        public void WhenPressПродолжитьПокупки()
        {
            CartContext.ClickContinuePurchases(Driver_init.CartPageWithOrders);
        }

        [When(@"Press Оформление заказа")]
        public void WhenPressОформлениеЗаказа()
        {
            CartContext.ProceedToCheckout(Driver_init.CartPageWithOrders);
        }

        [When(@"Press X near the product")]
        public void WhenPressXNearTheProduct()
        {
            CartContext.ClickDeleteProduct(Driver_init.CartPageWithOrders, 0);
        }

        [When(@"Press Удалить без сохранения")]
        public void WhenPressУдалитьБезСохранения()
        {
            CartContext.ClickDeleteWithoutSaving(Driver_init.CartPageWithOrders, 0);
        }

        [When(@"Press Переместить в список желаний")]
        public void WhenPressПереместитьВСписокЖеланий()
        {
            CartContext.ClickWishList(Driver_init.CartPageWithOrders, 0);
        }

        [When(@"Press Отмена")]
        public void WhenPressОтмена()
        {
            CartContext.ClickCancel(Driver_init.CartPageWithOrders, 0);
        }

        [When(@"You click closing cross on the right corner")]
        public void WhenYouClickClosingCrossOnTheRightCorner()
        {
            CartContext.ClickCloseTheCart(Driver_init.CartPageWithoutOrders);
        }


    }
}
