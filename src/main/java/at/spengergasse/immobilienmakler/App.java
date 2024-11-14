package at.spengergasse.immobilienmakler;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;

import at.spengergasse.immobilienmakler.model.Grundstueck;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.testModel.TestDatenImmobilien;
import at.spengergasse.immobilienmakler.view.*;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class App extends Application {


    @Override
    public void start(Stage stage) throws  ImmobilienException {
        try {
//
//            for(int i = 50; i< 1000; i++){
//
//                Line line = new Line();
//
//                BorderPane bp = new BorderPane();
//                Pane dp = new Pane();
//                bp.setCenter(line);
//                Scene scene = new Scene(bp, 500, 500);
//                stage.setScene(scene);
//                stage.setTitle("Line");
//                stage.show();
//
//                line.setStartX(i);
//                line.setStartY(i);
//                line.setEndX(100+i);
//                line.setEndY(100+i);
//                wait(500);
//
//
//            }



            MainView view = new MainView();
            Parent root = view.getRoot();       //Parent-Nodes enthalten weitere Nodes,
            ImmobilienView view1 = new ImmobilienView();
            Parent root1 = view1.getRoot();
            GrundstueckView gv = new GrundstueckView();
            Parent root2 = gv.getRoot();
            WohnhausView wv = new WohnhausView();
            Parent root3 = wv.getRoot();
            Scene scene = new Scene(root, 650, 400);        //Die Klasse Scene verwaltet den Szenengraph.
            stage.setTitle("Immobilien Verwaltung");           // die Blätter-Nodes stellen dagegen die sichtbaren
            stage.setScene(scene);                                     // Elemente der GUI dar (Button, Textfeld, Slider usw.).
            stage.show();
        }catch(Exception e){
            Messages.error(e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException{
        launch(args);
//        Socket s = new Socket("127.0.0.2",4444 );

    }

}
