package fiipractic.tudor.twitter.controller.advice;

import fiipractic.tudor.twitter.exception.IncorrectPostException;
import fiipractic.tudor.twitter.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PostNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public String incorrectPostHandler(PostNotFoundException exception){
        return exception.getMessage();
    }
}