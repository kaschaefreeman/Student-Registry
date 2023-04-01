package com.github.kaschaefreeman.student_registry.exceptions;

/**
 * A custom exception for if a server is unavailable
 */
public class ServerUnavailable extends RuntimeException {

    public ServerUnavailable() { }

    public ServerUnavailable(String message) { super(message); }
}
