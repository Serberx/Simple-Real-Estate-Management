module at.spengergasse.immobilienmakler {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
//    requires org.testng;
//    requires org.junit.jupiter.api;


    opens at.spengergasse.immobilienmakler to javafx.fxml;
    exports at.spengergasse.immobilienmakler;
}