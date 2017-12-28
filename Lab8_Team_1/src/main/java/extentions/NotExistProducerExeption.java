package extentions;

public class NotExistProducerExeption extends Exception{

    @Override
    public String getMessage() {
        return "Firm is not exist";
    }
}
