package at.spengergasse.immobilienmakler.view;

import at.spengergasse.immobilienmakler.Constants;
import at.spengergasse.immobilienmakler.model.Immobilie;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.viewModel.MainViewModel;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;


import javax.crypto.BadPaddingException;
import javax.net.ssl.HostnameVerifier;

import java.util.List;

import static at.spengergasse.immobilienmakler.Constants.PADDING_INSETS;


public class MainView {

    private Parent root;
    private ListView<Immobilie> listView;
    private MainViewModel viewModel;
    private Button btnLoad;
    private Button btnSave;

    private Button btnEdit;
    //    private Button btnCreate;
    private Button btnCreateGrundstueck;
    private Button btnCreateWohnhaus;
    private Button btnDelete;

    private Button btnExit;
    private Button btnSearch;
    private TextField tfSearch;

    //Konstruktor
    public MainView() {
        initView();
        initViewModel();
        bindAndAction();
    }

    //Init View
    private void initView() {
        BorderPane root = new BorderPane();
        root.setPadding(PADDING_INSETS);

        listView = new ListView<>();


        //Daten laden
        btnLoad = new Button("Load");
        btnSave = new Button("Save");
        btnEdit = new Button("Edit");
//        btnCreate = new Button("Create");
        btnCreateGrundstueck = new Button("Grundstück");
        btnCreateWohnhaus    = new Button("Wohnhaus");
        btnDelete            = new Button("Delete");
        btnExit              = new Button("Exit");
        btnSearch            = new Button("Search");
        tfSearch             = new TextField();
        HBox hBox = new HBox(( Constants.SPACING )*2);       //spacing = 8 Abstand zwischen den Elementen innerhalb eines Layout Managers
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btnLoad, btnSave, new Separator(Orientation.VERTICAL), btnEdit,/* btnCreate,*/ new Separator(Orientation.VERTICAL), btnDelete, new Separator(Orientation.VERTICAL), btnExit, new Separator(Orientation.VERTICAL), btnSearch, tfSearch);
        hBox.setPadding(new Insets(Constants.PADDING, 0, Constants.PADDING, 0));       //Padding = Abstand zwischen den Rändern eines Layout Managers und dessen Kindelementen

        //Create Grundstück und Wohnhaus Buttons
        VBox vBoxCreate = new VBox(Constants.SPACING);
        vBoxCreate.setPadding(new Insets(150, 30, 0, 0));
        vBoxCreate.getChildren().addAll(btnCreateGrundstueck, new Separator(Orientation.HORIZONTAL), btnCreateWohnhaus);

        root.setRight(vBoxCreate);


        root.setCenter(listView);
        BorderPane.setMargin(listView, new Insets(30));     //Margin = Mit statischer Methode BorderPane hinzufügen, nachdem zb. Position durch setCenter hinzugefügt wurde.

        root.setBottom(hBox);
        this.root = root;       //Basis Layoutmanager

    }

    //Init ViewModel
    private void initViewModel() {
        this.viewModel = new MainViewModel();
    }

    private void bindAndAction() {
        //Binding
        listView.itemsProperty().bindBidirectional(viewModel.listProperty());
        viewModel.selectedImmobilieProperty().bind(listView.getSelectionModel().selectedItemProperty());

        btnEdit.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNull());
        btnDelete.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNull());
//        btnDelete.disableProperty().bind(listView.get;
//        btnSearch.disableProperty().bind(tfSearch.disableProperty().asObject().isNull());
//        String tf1 = tfSearch.getText();
//        btnSearch.disableProperty().bind(tfSearch.focusedProperty());
        tfSearch.setPromptText("ID - Eingabe");
        btnSearch.disableProperty().bind(tfSearch.focusedProperty().not());
        tfSearch.textProperty().bindBidirectional(viewModel.idProperty(), new StringConverter<Number>() {

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
                    return Integer.parseInt(s);
                }catch (NumberFormatException e){
                    return 0;
                }
            }
        });

        //Actions
        btnExit.setOnAction(viewModel.getExitAction());
        btnLoad.setOnAction(viewModel.getLoadAction());
        btnEdit.setOnAction(viewModel.getEditAction());
        btnSave.setOnAction(viewModel.getSaveAction());
//        btnCreate.setOnAction(viewModel.getCreateAction());
        btnDelete.setOnAction(viewModel.getDeleteAction());
        btnCreateGrundstueck.setOnAction(viewModel.getCreateGrundstueckAction());
        btnCreateWohnhaus.setOnAction(viewModel.getCreateWohnhausAction());
        btnSearch.setOnAction(viewModel.getSearchAction());
    }

    public Parent getRoot() {
        return root;
    }


}
