package MyExceptions;

public class NotAuthorizedException extends Exception {
    public NotAuthorizedException(){
        super("You are not authorized");
    }
}
