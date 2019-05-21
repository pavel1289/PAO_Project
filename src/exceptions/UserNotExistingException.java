package exceptions;

public class UserNotExistingException extends Exception{
    public UserNotExistingException(String message) {
        super(message);
    }
}
