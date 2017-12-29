package Extensions;

public class NotValidDataException extends Exception {
    @Override
    public String getMessage() {
        return "Not Valid Data";
    }
}