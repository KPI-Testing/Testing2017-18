package Data_to_Insert;

public class WrongDataExeption extends Exception {
    @Override
    public String getMessage() {
        return "Not Valid Data";
    }
}