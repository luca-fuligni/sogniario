package it.unicam.morpheus.sogniario.boundary;

import it.unicam.morpheus.sogniario.exception.EntityNotFoundException;
import it.unicam.morpheus.sogniario.exception.IdConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.FileNotFoundException;

/**
 * The class takes care of managing the handlers for shared exceptions between the various Boundary interfaces.
 */
@ControllerAdvice
public class ExceptionBoundary extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<String> entityNotFoundHandler(EntityNotFoundException e){
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<String> illegalArgumentHandler(IllegalArgumentException e){
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdConflictException.class)
    protected ResponseEntity<String> idConflictHandler(IdConflictException e){
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<String> nullHandler(NullPointerException e){
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(IllegalStateException.class)
    protected ResponseEntity<String> illegalStateHandler(IllegalStateException e){
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileNotFoundException.class)
    protected ResponseEntity<String> FileNotFoundHandler(FileNotFoundException e){
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

}
