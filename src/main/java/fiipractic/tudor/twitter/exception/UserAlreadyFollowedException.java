package fiipractic.tudor.twitter.exception;

public class UserAlreadyFollowedException extends RuntimeException{
    public UserAlreadyFollowedException(String message){
        super(message);
    }
}
