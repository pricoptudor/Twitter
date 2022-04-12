package fiipractic.tudor.twitter.controller.advice;

import fiipractic.tudor.twitter.exception.UserAlreadyFollowedException;
import fiipractic.tudor.twitter.exception.UserNotFollowedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserNotFollowedAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFollowedException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public String userNotFollowedHandler(UserNotFollowedException exception){
        return exception.getMessage();
    }
}
