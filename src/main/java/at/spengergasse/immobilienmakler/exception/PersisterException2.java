package at.spengergasse.immobilienmakler.exception;

public class PersisterException2 extends RuntimeException{

    public PersisterException2(String message){
        super(message);
    }

    public PersisterException2(String message, Throwable cause){
        super(message, cause);
    }
}
