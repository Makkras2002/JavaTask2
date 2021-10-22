package com.makkras.task.exception;

public class FileInteractionException extends Exception{
    public FileInteractionException() {
    }


    public FileInteractionException(String message) {
        super(message);
    }

    public FileInteractionException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileInteractionException(Throwable cause) {
        super(cause);
    }
}
