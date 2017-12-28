using TestFramework.Pages;

namespace TestFramework.Contexts
{
    public static class ResultSetContext
    {
        public static void SelectElement(FilterPage page, int elemetIndex)
        {
            page.ResultSet[elemetIndex].Click();
        }
    }
}
