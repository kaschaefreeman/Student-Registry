package com.github.kaschaefreeman.student_registry.exceptions;

import java.util.Date;
import com.github.kaschaefreeman.student_registry.constants.StringConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This allows yous you to use the same exception handling techniques but apply them across the
 * whole application, Not just to an individual controller.
 */
@ControllerAdvice
public class ExceptionController {

    private final Logger logger = LogManager.getLogger();

    /**
     * Handles any exceptions that are thrown with the service unavailable class
     *
     * @param exception exception that was thrown
     * @return new response entity the represents the error response
     */
    @ExceptionHandler(ServerUnavailable.class)
    protected ResponseEntity<ExceptionResponseMessage> serverUnavailable(ServerUnavailable exception) {
    ExceptionResponseMessage response =
        new ExceptionResponseMessage(
            exception.getMessage(), new Date(), StringConstants.SERVICE_UNAVAILABLE);

        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * Handles any exceptions that are thrown with the bad request class
     *
     * @param exception exception that was thrown
     * @return new response entity the represents the error response
     */
    @ExceptionHandler(BadRequest.class)
    protected ResponseEntity<ExceptionResponseMessage> badRequest(BadRequest exception) {
        ExceptionResponseMessage response = new ExceptionResponseMessage(exception.getMessage(), new Date(), StringConstants.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
