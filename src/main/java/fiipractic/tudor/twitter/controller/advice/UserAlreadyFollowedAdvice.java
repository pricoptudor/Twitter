package fiipractic.tudor.twitter.controller.advice;

import fiipractic.tudor.twitter.exception.UserAlreadyFollowedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserAlreadyFollowedAdvice {
    @ResponseBody
    @ExceptionHandler(UserAlreadyFollowedException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public String userAlreadyFollowedHandler(UserAlreadyFollowedException exception){
        return exception.getMessage();
    }
}
