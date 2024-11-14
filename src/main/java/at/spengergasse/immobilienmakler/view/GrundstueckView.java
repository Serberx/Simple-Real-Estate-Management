package at.spengergasse.immobilienmakler.view;

import at.spengergasse.immobilienmakler.Constants;
import at.spengergasse.immobilienmakler.persistence.GrundtueckViewModel;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.StringConverter;

public class GrundstueckView {

    private Parent root;
    private GrundtueckViewModel viewModel;
    private TextField tfId, tfAdresse, tfFlaeche, tfVerkehrswert, tfWidmung, tfQmPreis;
    private Label lbId, lbAdresse, lbFlaeche, lbVerkehrswert, lbWidmung, lbQmPreis;
    private Button btnSave, btnCancel;
    private ComboBox<Character> cbWidmung;
    private Slider slFlaeche, slQmPreis;

    public GrundstueckView() {
        initView();
        initViewModel();
        bindAndAction();
    }

    private void initViewModel() {
        this.viewModel = new GrundtueckViewModel();
    }

    //UI-Elemente Init-View
    private void initView() {
        BorderPane root = new BorderPane();
        //Label Seite
        lbId      = new Label("Identifikationsnummer:");
        lbAdresse = new Label("Adresse:");
        lbFlaeche = new Label("Fläche:");
        lbWidmung = new Label("Widmung:");
        lbQmPreis = new Label("Qm Preis:");

        //Textfield Seite
        tfId = new TextField();
        tfId.setPromptText("id");
        tfId.setEditable(false);
        tfAdresse = new TextField();
        tfAdresse.setEditable(true);
        tfFlaeche = new TextField();
        tfFlaeche.setEditable(true);
        tfWidmung = new TextField();
        tfWidmung.setEditable(true);
        tfQmPreis = new TextField();
        tfQmPreis.setEditable(true);

        cbWidmung = new ComboBox();
        cbWidmung.getItems().addAll('B','G','N', '?');
        cbWidmung.setValue('?');

        slFlaeche = new Slider(at.spengergasse.immobilienmakler.model.Constants.MIN_FLAECHE_GRUNDSTUECK, at.spengergasse.immobilienmakler.model.Constants.MAX_FLAECHE_GRUNDSTUECK, at.spengergasse.immobilienmakler.model.Constants.MIN_FLAECHE_GRUNDSTUECK);
        slFlaeche.setShowTickLabels(true);
        slFlaeche.setMajorTickUnit(25000);

        slQmPreis = new Slider(at.spengergasse.immobilienmakler.model.Constants.MIN_QM_PREIS, at.spengergasse.immobilienmakler.model.Constants.MAX_QM_PREIS, at.spengergasse.immobilienmakler.model.Constants.MIN_QM_PREIS);
        slQmPreis.setShowTickLabels(true);
        slQmPreis.setMajorTickUnit(2499.75);

        GridPane gridPaneTextfieldUndLabel = new GridPane();
        gridPaneTextfieldUndLabel.setPadding(new Insets(Constants.PADDING*10));
        gridPaneTextfieldUndLabel.setVgap(Constants.PADDING);
        gridPaneTextfieldUndLabel.setHgap(Constants.PADDING*5);

        gridPaneTextfieldUndLabel.addRow(0, lbId, tfId);
        gridPaneTextfieldUndLabel.addRow(1, lbAdresse, tfAdresse);
        gridPaneTextfieldUndLabel.addRow(2, lbFlaeche, tfFlaeche);
        gridPaneTextfieldUndLabel.addRow(3, lbWidmung, tfWidmung);
        gridPaneTextfieldUndLabel.addRow(4, lbQmPreis, tfQmPreis);
        gridPaneTextfieldUndLabel.addRow(5, new Label("Widmung:"), cbWidmung);
        gridPaneTextfieldUndLabel.addRow(6, new Label("Fläche:"), slFlaeche);
        gridPaneTextfieldUndLabel.addRow(7, new Label("Qm Preis:"), slQmPreis);

        root.setCenter(gridPaneTextfieldUndLabel);

        //Buttons
        btnSave   = new Button("Speichern");
        btnCancel = new Button("Abbrechen");

        VBox vBoxBottom = new VBox();
        HBox hBoxButtons = new HBox();

        hBoxButtons.getChildren().addAll(btnSave, btnCancel);
        vBoxBottom.getChildren().addAll(new Separator(Orientation.HORIZONTAL), hBoxButtons);

        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.setPadding(new Insets(Constants.PADDING*2, 0, Constants.PADDING*5, 0));
        hBoxButtons.setSpacing(Constants.SPACING*5);


        root.setBottom(vBoxBottom);
   

        this.root = root;

    }


    public GrundtueckViewModel getViewModel() {
        return viewModel;
    }

    public Parent getRoot() {
        return this.root;
    }

    //Binding and Actions
    private void bindAndAction() {
        tfId.textProperty().bind(viewModel.idProperty());
        tfAdresse.textProperty().bindBidirectional(viewModel.adresseProperty());
        tfFlaeche.textProperty().bindBidirectional(viewModel.flaecheProperty(), new StringConverter<Number>() {

            @Override
            public String toString(Number number) {
                return ( number != null ) ? String.valueOf(number) : "";
            }

            @Override
            public Number fromString(String s) {
                if( s == null || s.isBlank() )
                    return 0;
                try {
                    return Double.parseDouble(s);
                }catch (NumberFormatException e) {
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
                }catch (NullPointerException e) {
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
                if( s == null || s.isBlank() ) {
                    return 0;
                }
                try {
                    return Double.parseDouble(s);
                }catch (NumberFormatException e) {
                    return 0;
                }
            }
        });


       /* cbWidmung.promptTextProperty().bindBidirectional(viewModel.widmungProperty(), new StringConverter<Character>() {

            @Override
            public String toString(Character character) {
                return (character != null)? String.valueOf(character): "";
            }

            @Override
            public Character fromString(String s) {
                if(s == null|| s.isBlank() ){
                    return 0;
                }
                try{
                    return s.charAt(0);
                }catch (IndexOutOfBoundsException e){
                    return 0;
                }
            }
        });*/

        viewModel.widmungProperty().bindBidirectional(cbWidmung.valueProperty());
        viewModel.flaecheProperty().bindBidirectional(slFlaeche.valueProperty());
        viewModel.qmPreisProperty().bindBidirectional(slQmPreis.valueProperty());
        //Eventhandler
        btnSave.setOnAction(viewModel.getSaveAction());
        btnCancel.setOnAction(viewModel.getCancelAction());

    }


}
