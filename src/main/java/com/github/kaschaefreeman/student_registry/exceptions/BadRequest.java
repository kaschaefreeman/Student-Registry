package com.github.kaschaefreeman.student_registry.exceptions;

/**
 * A custom exception for if a user causes a bad request
 */
public class BadRequest extends RuntimeException{

    public BadRequest() { }

    public BadRequest(String message) { super(message); }
}
