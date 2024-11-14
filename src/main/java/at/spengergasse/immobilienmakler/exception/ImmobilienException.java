package at.spengergasse.immobilienmakler.exception;

public class ImmobilienException extends Exception {

   public ImmobilienException(String message){
       super(message);
   }
   public ImmobilienException(String message,Throwable cause){
       super(message, cause);
   }
}
