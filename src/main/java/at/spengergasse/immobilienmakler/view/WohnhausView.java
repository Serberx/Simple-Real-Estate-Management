package at.spengergasse.immobilienmakler.view;

import at.spengergasse.immobilienmakler.Constants;
import at.spengergasse.immobilienmakler.viewModel.WohnhausViewModel;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

public class WohnhausView {

    private Parent root;
    private WohnhausViewModel viewModel;

    private Label lbId;
    private Label lbAdresse;
    private Label lbFlaeche;
    private Label lbKategorie;
    private Label lbEinheitswert;

    private TextField tfId;
    private TextField tfAdresse;
    private TextField tfFlaeche;
    private TextField tfKategorie;
    private TextField tfEinheitswert;

    private ComboBox<Character> cbKategorie;

    private Slider slFlaeche, slEinheitswert;

    private Button btnSave;
    private Button btnCancel;

    public WohnhausView(){
        initView();
        initViewModel();
        bindAndAction();
    }
    public void initViewModel(){
        this.viewModel = new WohnhausViewModel();
    }

    public void initView(){

        BorderPane root = new BorderPane();
        //Label Seite
        lbId      = new Label("Identifikationsnummer:");
        lbAdresse = new Label("Adresse:");
        lbFlaeche = new Label("Fläche:");
        lbKategorie = new Label("Kategorie:");
        lbEinheitswert = new Label("Einheitswert:");

        //Textfield Seite
        tfId      = new TextField();
        tfId.setPromptText("id");
        tfId.setEditable(false);
        tfAdresse = new TextField();
        tfAdresse.setEditable(true);
        tfFlaeche = new TextField();
        tfFlaeche.setEditable(true);
        tfKategorie = new TextField();
        tfKategorie.setEditable(true);
        tfEinheitswert = new TextField();
        tfEinheitswert.setEditable(true);

        cbKategorie = new ComboBox<>();
        cbKategorie.getItems().addAll('A','B','C','D');
        cbKategorie.setValue('A');

        slFlaeche = new Slider(at.spengergasse.immobilienmakler.model.Constants.MIN_FLAECHE_WOHNHAUS,
                at.spengergasse.immobilienmakler.model.Constants.MAX_FLAECHE_WOHNHAUS,
                at.spengergasse.immobilienmakler.model.Constants.MIN_FLAECHE_WOHNHAUS);
        slFlaeche.setShowTickLabels(true);
        slFlaeche.setMajorTickUnit(1250);

        slEinheitswert = new Slider(at.spengergasse.immobilienmakler.model.Constants.MIN_EINHEITSWERT,
                at.spengergasse.immobilienmakler.model.Constants.MAX_EINHEITSWERT,
                at.spengergasse.immobilienmakler.model.Constants.MIN_EINHEITSWERT);
        slEinheitswert.setShowTickLabels(true);
        slEinheitswert.setMajorTickUnit(12497500);

        GridPane gridPaneTextfieldUndLabel = new GridPane();
        gridPaneTextfieldUndLabel.setPadding(new Insets(Constants.PADDING*10));
        gridPaneTextfieldUndLabel.setVgap(Constants.PADDING);
        gridPaneTextfieldUndLabel.setHgap(Constants.PADDING*5);

        gridPaneTextfieldUndLabel.addRow(0, lbId, tfId);
        gridPaneTextfieldUndLabel.addRow(1, lbAdresse, tfAdresse);
        gridPaneTextfieldUndLabel.addRow(2, lbFlaeche, tfFlaeche);
        gridPaneTextfieldUndLabel.addRow(3, lbKategorie, tfKategorie);
        gridPaneTextfieldUndLabel.addRow(4, lbEinheitswert, tfEinheitswert);
        gridPaneTextfieldUndLabel.addRow(5, new Label("Kategorie:"), cbKategorie);
        gridPaneTextfieldUndLabel.addRow(6, new Label("Fläche:"), slFlaeche);
        gridPaneTextfieldUndLabel.addRow(7, new Label("Einheitswert:"), slEinheitswert);

        root.setCenter(gridPaneTextfieldUndLabel);

        //Buttons
        btnSave  = new Button("Speichern");
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

    //BindAndAction
    public void bindAndAction(){
        tfId.textProperty().bind(viewModel.idProperty());
        tfAdresse.textProperty().bindBidirectional(viewModel.adresseProperty());
        tfFlaeche.textProperty().bindBidirectional(viewModel.flaecheProperty(), new StringConverter<Number>() {

            @Override
            public String toString(Number number) {
                return (number != null )? String.valueOf(number):"";
            }

            @Override
            public Number fromString(String s) {
                if(s == null || s.isBlank()){
                    return 0;
                }
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
                return (character != null)? String.valueOf(character): "";
            }

            @Override
            public Character fromString(String s) {
                try{
                    return s.charAt(0);
                }catch (IndexOutOfBoundsException e){
                    return 0;
                }
            }
        });
        tfEinheitswert.textProperty().bindBidirectional(viewModel.einheitswertProperty(), new StringConverter<Number>() {

            @Override
            public String toString(Number number) {
                return (number != null) ? String.valueOf(number):"";
            }

            @Override
            public Number fromString(String s) {
               try{
                   return Double.parseDouble(s);
               }catch (NumberFormatException e){
                   return 0;
               }
            }
        });
        viewModel.kategorieProperty().bindBidirectional(cbKategorie.valueProperty());
        viewModel.flaecheProperty().bindBidirectional(slFlaeche.valueProperty());
       viewModel.einheitswertProperty().bindBidirectional(slEinheitswert.valueProperty());
        //EventHandler
        btnSave.setOnAction(viewModel.getSaveAction());
        btnCancel.setOnAction(viewModel.getCancelAction());

    }

    public WohnhausViewModel getViewModel(){
        return viewModel;
    }

    public Parent getRoot(){
        return this.root;
    }
}
