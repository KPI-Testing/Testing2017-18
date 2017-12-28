package extentions;

public class NotHaveProductsExeption extends Exception {
    @Override
    public String getMessage() {
        return "Empty list";
    }
}
