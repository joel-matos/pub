package eu.europa.ec.workshop.ut.pub.beer.controller;

import eu.europa.ec.workshop.ut.pub.beer.exception.BeerNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class BeerAdvice {

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(BeerNotFoundException.class)
    protected String beerNotFoundHandler(BeerNotFoundException e) {
        return e.getMessage();
    }

}
