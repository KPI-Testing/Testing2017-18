package extentions;

public class NotValidDataExeption extends Exception {
    @Override
    public String getMessage() {
        return "Not Valid Data";
    }
}
