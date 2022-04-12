package fiipractic.tudor.twitter.exception;

public class UserNotFollowedException extends RuntimeException{
    public UserNotFollowedException(String message){
        super(message);
    }
}
