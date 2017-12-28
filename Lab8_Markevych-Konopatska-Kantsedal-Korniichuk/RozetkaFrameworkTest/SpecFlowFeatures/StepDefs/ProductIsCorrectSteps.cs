using System;
using TechTalk.SpecFlow;
using TestFramework.Contexts;

namespace TestsUseFramework.SpecFlow.StepDefs
{
    [Binding]
    public class ProductIsCorrectSteps
    {
        [Then(@"The name of the shown product is the same as the name of the product we chose")]
        public void ThenTheNameOfTheShownProductIsTheSameAsTheNameOfTheProductWeChose()
        {
            string name = Driver_init.CartPageWithOrders.GetProductName(0);
            CartContext.ClickLinkOfProduct(Driver_init.CartPageWithOrders, 0);
            GoodStateVerificationContext.VerifyItemNameInCart(Driver_init.SingleBookPage, name);
        }
        
        [Then(@"The price of the shown product is the same as the price of the product we chose")]
        public void ThenThePriceOfTheShownProductIsTheSameAsThePriceOfTheProductWeChose()
        {
            int price = Driver_init.CartPageWithOrders.GetPriceForType(0);
            CartContext.ClickLinkOfProduct(Driver_init.CartPageWithOrders, 0);
            GoodStateVerificationContext.VerifyItemPriceInCart(Driver_init.SingleBookPage, price);
        }
        
        [Then(@"The image of the shown product is the same as the image of the product we chose")]
        public void ThenTheImageOfTheShownProductIsTheSameAsTheImageOfTheProductWeChose(string src)
        {
            string url = Driver_init.CartPageWithOrders.GetImageSrc(0);
            CartContext.ClickLinkOfProduct(Driver_init.CartPageWithOrders, 0);
            GoodStateVerificationContext.VerifyProductImageInCart(Driver_init.SingleBookPage, src);
        }

        [Then(@"The seller picture of the shown product is the same as the seller picture of the product we chose")]
        public void ThenTheSellerPictureOfTheShownProductIsTheSameAsTheSellerPictureOfTheProductWeChose()
        {
            string src = Driver_init.CartPageWithOrders.SellerImageSet[0].GetSourceLink();
            CartContext.ClickLinkOfProduct(Driver_init.CartPageWithOrders, 0);
        }

    }
}
