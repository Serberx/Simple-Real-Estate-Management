package at.spengergasse.immobilienmakler.exception;

public class PersisterException extends RuntimeException{

    public PersisterException(String message){
        super(message);
    }
    public PersisterException(String message, Throwable throwable){
        super(message, throwable);
    }
}
