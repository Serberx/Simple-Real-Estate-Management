package at.spengergasse.immobilienmakler.view;

import at.spengergasse.immobilienmakler.Constants;
import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.viewModel.ImmobilienViewModel;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.StringConverter;

import java.net.CacheRequest;

public class ImmobilienView {

    private Parent root;

    private TextField tfId;
    private TextField tfAdresse;
    private TextField tfFlaeche;
    private TextField tfVerkehrswert;

    private TextField tfKategorie;

//    private CheckBox cbKategorieA;
//    private CheckBox cbKategorieB;
//    private CheckBox cbKategorieC;
//    private CheckBox cbKategorieD;

    private TextField tfEinheitswert;
    private TextField tfWidmung;
    private TextField tfQmPreis;

    private Button btnSave;     //eventhandler setzen
    private Button btnCancel;   //eventhandler setzen


    private ImmobilienViewModel viewModel;


    //Konstruktor ---------------------------------------------------------
    public ImmobilienView() {
        initView();
        initViewModel();
        bindAndAction();
    }

    //Init View Model  ---------------------------------------------------------
    private void initViewModel() {
        this.viewModel = new ImmobilienViewModel();
    }

    //Init View ----- Methode initView() ----- ---------------------------------------------------------
    private void initView() {
        BorderPane root = new BorderPane();
        root.setPadding(Constants.PADDING_INSETS);

//
        //Center
        tfId = new TextField();
        tfId.setEditable(true);

        tfAdresse = new TextField();
        tfAdresse.setEditable(true);

        tfFlaeche = new TextField();
        tfFlaeche.setEditable(true);

        tfVerkehrswert = new TextField();
        tfVerkehrswert.setEditable(true);

        tfKategorie = new TextField();
        tfKategorie.setEditable(true);

        tfEinheitswert = new TextField();
        tfEinheitswert.setEditable(true);

        tfWidmung = new TextField();
        tfWidmung.setEditable(true);

        tfQmPreis = new TextField();
        tfQmPreis.setEditable(true);

        GridPane gridPaneCenter = new GridPane();
        gridPaneCenter.setVgap(Constants.SPACING);
        gridPaneCenter.setHgap(Constants.SPACING);

        gridPaneCenter.addRow(0, new Label("Identifikationsnummer: "), tfId);
        gridPaneCenter.addRow(1, new Label("Adresse: "), tfAdresse);
        gridPaneCenter.addRow(2, new Label("Fläche: "), tfFlaeche);
        gridPaneCenter.addRow(3, new Label("Verkehrswert: "), tfVerkehrswert);
        gridPaneCenter.addRow(4, new Label("Kategorie: "), tfKategorie);
        gridPaneCenter.addRow(5, new Label("Einheitswert: "), tfEinheitswert);
        gridPaneCenter.addRow(6, new Label("Widmung: "), tfWidmung);
        gridPaneCenter.addRow(7, new Label("Quadratmeter Preis: "), tfQmPreis);


       /* HBox hBoxKategorie = new HBox(Constants.PADDING);
        hBoxKategorie.getChildren().addAll(cbKategorieA, cbKategorieB, cbKategorieC,cbKategorieD);
        gridPaneCenter.addRow(8, new Label("Kategorie"), hBoxKategorie);*/


        //Bottom
        VBox vBoxBottom = new VBox();
        HBox hBoxButtons = new HBox();
        btnSave   = new Button("Speichern");
        btnCancel = new Button("Abbrechen");

        hBoxButtons.getChildren().addAll(btnSave, btnCancel);
        hBoxButtons.setPadding(new Insets(Constants.PADDING));
        hBoxButtons.setSpacing(Constants.SPACING);
        hBoxButtons.setAlignment(Pos.CENTER);
        vBoxBottom.getChildren().addAll(new Separator(Orientation.HORIZONTAL), hBoxButtons);

        root.setCenter(gridPaneCenter);
        root.setBottom(vBoxBottom);

        this.root = root;
    }

    public ImmobilienViewModel getViewModel() {
        return viewModel;
    }

    //Binding and Actions ---------------------------------------------------------

    public void bindAndAction() {
        // Binding der UI-Elemente -> Properties
        tfId.textProperty().bind(viewModel.idProperty());
        tfAdresse.textProperty().bindBidirectional(viewModel.adresseProperty());
        tfFlaeche.textProperty().bindBidirectional(viewModel.flaecheProperty(), new StringConverter<Number>() {

            @Override
            public String toString(Number number) {
                return ( number != null ) ? String.valueOf(number) : "-999";
            }

            @Override
            public Number fromString(String number) {
                if( number == null || number.isBlank() )
                    return 0;
                try {
                    return Double.parseDouble(number);
                }catch (NumberFormatException e) {
                    return 0;
                }
            }
        });
        tfVerkehrswert.textProperty().bindBidirectional(viewModel.verkehrswertProperty(), new StringConverter<Number>() {

            @Override
            public String toString(Number number) {
                return (number != null )? String.valueOf(number): "";
            }

            @Override
            public Number fromString(String s) {
                if(s == null || s.isBlank())
                    return 0;
                try{
                    return Double.parseDouble(s);
                }catch (NumberFormatException e){
                    return 0;
                }
            }
        });
        tfKategorie.textProperty().bindBidirectional(viewModel.kategorieProperty(), new StringConverter<Character>() {

            @Override
            public String toString(Character character) {

                return ( character != null ) ? String.valueOf(character) : "";
            }

            @Override
            public Character fromString(String s) {
                if( s == null || s.isBlank() )
                    return 0;
                try {
                    return s.charAt(0);
                }catch (IndexOutOfBoundsException e) {
                    return 0;
                }
            }
        });
        tfEinheitswert.textProperty().bindBidirectional(viewModel.einheitswertProperty(), new StringConverter<Number>() {

            @Override
            public String toString(Number number) {
                return (number != null )? String.valueOf(number): "";
            }

            @Override
            public Number fromString(String s) {
               if(s == null || s.isBlank())
                   return 0;
               try{
                   return Double.parseDouble(s);
               }catch (NumberFormatException e){
                   return 0;
               }
            }
        });
        tfWidmung.textProperty().bindBidirectional(viewModel.widmungProperty(), new StringConverter<Character>() {

            @Override
            public String toString(Character character) {

                return ( character != null ) ? String.valueOf(character) : "";
            }

            @Override
            public Character fromString(String s) {

                if( s == null || s.isBlank() )
                    return 0;
                try {
                    return s.charAt(0);
                }catch (IndexOutOfBoundsException e) {
                    return 0;
                }
            }
        });

        tfQmPreis.textProperty().bindBidirectional(viewModel.qmPreisProperty(), new StringConverter<Number>() {

            @Override
            public String toString(Number number) {
                return ( number != null ) ? String.valueOf(number) : "";
            }

            @Override
            public Number fromString(String s) {
                if( s == null || s.isBlank() )
                    return 0;
                try{
                    return Double.parseDouble(s);
                }catch (NumberFormatException e){
                    return 0;
                }

            }
        });

        // EventHandler setzen ----------------------------------------
        btnSave.setOnAction(viewModel.getSaveAction());
        btnCancel.setOnAction(viewModel.getCancelAction());
    }


    public Parent getRoot() {
        return root;
    }


}
