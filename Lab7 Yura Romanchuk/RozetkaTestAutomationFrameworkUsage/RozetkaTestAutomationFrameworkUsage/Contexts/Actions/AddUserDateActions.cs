using RozetkaTestAutomationFrameworkUsage.Helpers;
using RozetkaTestAutomationFrameworkUsage.Pages;


namespace RozetkaTestAutomationFrameworkUsage.Contexts.Actions
{
    public class AddUserDateActions
    {

        public static void add(CheckOutPage page, User user)
        {
            page.enter(page.Name, user.getname());
            page.enter(page.Phone, user.getphone());
            page.enter(page.Email, user.getemail());
        }
    }
}
