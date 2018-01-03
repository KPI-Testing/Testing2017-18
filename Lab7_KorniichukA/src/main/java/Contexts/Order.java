package Contexts;

        import Data_to_Insert.WrongDataExeption;
        import Data_to_Insert.Data;
        import Pageobj.CheckOutPage;
        import Pageobj.LastPage;

        import static Contexts.Initialize.field_init;

public class Order {
    public static LastPage init_cart(CheckOutPage page, Data data)throws WrongDataExeption {
        return field_init(page,data);
    }
}
