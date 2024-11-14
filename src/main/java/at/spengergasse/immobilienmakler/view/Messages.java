package at.spengergasse.immobilienmakler.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Messages {
    private Messages() {
    }


    public static void error(Throwable throwable) {
        Messages.create(Alert.AlertType.ERROR, throwable.getMessage());
    }
    public static void error(Throwable throwable, String headerText){
        Messages.create(headerText, throwable.getMessage(), Alert.AlertType.ERROR);
    }

    public static void error(String message) {
        Messages.create(Alert.AlertType.ERROR, message);
    }

    public static void error(String headerText, String contentText) {
        Messages.create(Alert.AlertType.ERROR, headerText, contentText);
    }

    ////////////////////////////////////////////////////////////////////////////
    public static void warning(Throwable throwable) {
        Messages.create(Alert.AlertType.WARNING, throwable.getMessage());
    }
    public static void warning(Throwable throwable, String headerText){
        Messages.create(headerText, throwable.getMessage(), Alert.AlertType.ERROR);
    }

    public static void warning(String message) {
        Messages.create(Alert.AlertType.WARNING, message);
    }

    public static void warning(String headerText, String contentText) {
        Messages.create(Alert.AlertType.WARNING, headerText, contentText);
    }

    ////////////////////////////////////////////////////////////////////////////
    public static void info(Throwable throwable) {
        Messages.create(Alert.AlertType.INFORMATION, throwable.getMessage());
    }
    public static void info(Throwable throwable, String headerText){
        Messages.create(headerText, throwable.getMessage(), Alert.AlertType.ERROR);
    }

    public static void info(String message) {
        Messages.create(Alert.AlertType.INFORMATION, message);
    }

    public static void info(String headerText, String contentText) {
        Messages.create(Alert.AlertType.INFORMATION, headerText, contentText);
    }

    ////////////////////////////////////////////////////////////////////////////
    public static boolean confirm(Throwable throwable){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, throwable.getMessage());
        Optional<ButtonType> buttonType =  alert.showAndWait();
        if(buttonType.isPresent() != false){
            System.out.println("nach");
            return ButtonType.OK.equals(buttonType.get());
        }else{
            return false;
        }
    }
    public static boolean confirm(String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message);
       Optional<ButtonType> buttonType = alert.showAndWait();
       if(buttonType.isPresent() != false){
           return ButtonType.OK.equals(buttonType.get());
       }else{
           return false;
       }
    }
    public static boolean confirm(String headerText, String contentText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, contentText);
        alert.setHeaderText(headerText);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.isPresent() != false){
            return ButtonType.OK.equals(buttonType.get());
        }else{
            return false;
        }

    }

    ////////////////////////////////////////////////////////////////////////////
    public static void create(Alert.AlertType type, String contentText) {
        Alert alert = new Alert(type, contentText);
        alert.showAndWait();
    }
    public static void create(String headerText,String contentText, Alert.AlertType type){
        Alert alert = new Alert(type, contentText);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void create(Alert.AlertType type, String headerText, String contentText) {
        Alert alert = new Alert(type, contentText);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }


    //    public static void error(Throwable throwable){
//        Messages.error( throwable.getMessage());
//    }
//    public static void error(String text){
//        Messages.create(Alert.AlertType.ERROR, text);
//    }
//
//    public static void info(Throwable throwable){
//        Messages.info(throwable.getMessage());
//    }
//    public static void info(String text){
//        Messages.create(Alert.AlertType.INFORMATION, text);
//    }
//
//    public static void warning(Throwable throwable){
//        Messages.warning(throwable.getMessage());
//    }
//    public static void warning(String text){
//        Messages.create(Alert.AlertType.WARNING, text);
//    }
//
//    public static void create(Alert.AlertType type, String contentText){
//        Alert alert = new Alert(type, contentText);
//        alert.showAndWait();
//    }
}
