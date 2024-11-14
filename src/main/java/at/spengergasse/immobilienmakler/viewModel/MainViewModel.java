package at.spengergasse.immobilienmakler.viewModel;

import at.spengergasse.immobilienmakler.action.AplicationAction;
import at.spengergasse.immobilienmakler.enumeration.PersisterType;
import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Grundstueck;
import at.spengergasse.immobilienmakler.model.Immobilie;
import at.spengergasse.immobilienmakler.model.Wohnhaus;
import at.spengergasse.immobilienmakler.service.ImmobilieService;
import at.spengergasse.immobilienmakler.service.Service;
import at.spengergasse.immobilienmakler.view.GrundstueckView;
import at.spengergasse.immobilienmakler.view.ImmobilienView;
import at.spengergasse.immobilienmakler.view.Messages;
import at.spengergasse.immobilienmakler.view.WohnhausView;
import javafx.application.Platform;
import javafx.beans.DefaultProperty;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class MainViewModel implements AplicationAction{

    //Deklaration der Properties
    private ListProperty<Immobilie> list;
    private ObjectProperty<Immobilie> selectedImmobilie;
    private Service<Immobilie> service;
    private IntegerProperty id;

    public MainViewModel(){
        initProperties();
        initService();
    }


    //Initialisierung der Properties
    //Init Methods

    private void initProperties(){
        this.list              = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.selectedImmobilie = new SimpleObjectProperty<>();
        this.id                = new SimpleIntegerProperty();
    }

    private void initService(){
        this.service = ImmobilieService.getInstance();
    }

    //Getter
    public ObservableList<Immobilie> getList(){
        return list.get();
    }

    public ListProperty<Immobilie> listProperty(){
        return list;
    }

    public Immobilie getSelectedImmobilie(){
        return selectedImmobilie.get();
    }

    public ObjectProperty<Immobilie> selectedImmobilieProperty(){
        return selectedImmobilie;
    }

    public Integer getID(){
        return id.get();
    }

    public IntegerProperty idProperty(){
        return id;
    }

    //Actions

    private Stage getStage(ActionEvent event){
        if(event.getSource() instanceof Node node){
            if(node.getScene().getWindow() instanceof Stage stage){
                return stage;
            }
        }
        return null;
    }

    //    @Override
   /* public void onCreate() {
        GrundstueckView grundstueckView = new GrundstueckView();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(grundstueckView.getRoot(), 400, 400);
        stage.setTitle("Spenger Immobiliendaten eingeben");
        stage.setScene(scene);
        stage.showAndWait();
        reload();
    }*/
    @Override
    public void onCreateGrundsteuck(){
        GrundstueckView grundstueckView = new GrundstueckView();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(grundstueckView.getRoot(), 400, 400);
        stage.setTitle("Grundstück Eingabe");
        stage.setScene(scene);
        stage.showAndWait();
        reload();
    }

    @Override
    public void onCreateWohnhaus(){
        WohnhausView wohnhausView = new WohnhausView();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(wohnhausView.getRoot(), 400, 400);
        stage.setTitle("Wohnhaus Eingabe");
        stage.setScene(scene);
        stage.showAndWait();
        reload();
    }

    @Override
    public void onEdit(){

        GrundstueckView grundstueckView = new GrundstueckView();
        WohnhausView wohnhausView = new WohnhausView();
        Stage stage;
        Scene scene;
        if(this.selectedImmobilie.get() instanceof Grundstueck){
            grundstueckView.getViewModel().selectedImmobilieProperty().bind(this.selectedImmobilie);
//        GrundtueckViewModel.class.newInstance().selectedImmobilieProperty().bind(this.selectedImmobilie);
//
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            scene = new Scene(grundstueckView.getRoot(), 400, 400);
            stage.setTitle("Grundstück Edit");
            stage.setScene(scene);
            stage.showAndWait();
            reload();
        }else{
            if(this.selectedImmobilie.get() instanceof Wohnhaus){
                wohnhausView.getViewModel().selectedImmobilieProperty().bind(this.selectedImmobilie);
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                scene = new Scene(wohnhausView.getRoot(), 400, 400);
                stage.setTitle("Wohnhaus Edit");
                stage.setScene(scene);
                stage.showAndWait();
                reload();
            }
        }
//        stage.setTitle("Spenger Immobiliendienstsystem");
//        stage.setScene(scene);
//        stage.showAndWait();
//        reload();

    }

    private void reload(){
//        try {
        list.setAll(service.findAll());
//        }catch (ImmobilienException e) {
//            Messages.error(e);
//        }
    }

    @Override
    public void onLoad(){
        try{
            FileChooser chooser = new FileChooser();
            chooser.setInitialDirectory(new File("src/main/java/at/spengergasse/immobilienmakler/save2/"));

            File file = chooser.showOpenDialog(null);
            if(file != null){
                this.service.load(file.getAbsolutePath(), PersisterType.CSV);
                reload();
            }else{
                Messages.info("Laden abbrechen");
                return;
            }
        }catch(ImmobilienException e){
            e.printStackTrace();
            Messages.error(e);
        }catch(Exception e){
            e.printStackTrace();
            Messages.error("Unerwarteter Fehler - " + e.getMessage());
        }
    }

    @Override
    public void onSave(){
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("src/main/java/at/spengergasse/immobilienmakler/save2/"));
            File file = fileChooser.showSaveDialog(null);
            if(file != null){
                this.service.save(file.getAbsolutePath(), PersisterType.CSV);
            }
        }catch(ImmobilienException e){
            e.printStackTrace();
            Messages.error(e);
        }catch(Exception e){
            e.printStackTrace();
            Messages.error("Unerwarteter Fehler - " + e.getMessage());
        }
    }

    @Override
    public void onExit(){
        if(Messages.confirm("Wollen Sie die Applikation wirklich beenden?")){
            Platform.exit();
        }
    }

    @Override
    public void onDelete(){
        try{
            Immobilie immobilie = getSelectedImmobilie();
            boolean isDeletet = Messages.confirm("Wollen Sie die Immobilie " + immobilie.getAdresse() + " wirklich löschen?");

            if(isDeletet == false){
                return;
            }

            boolean success = service.delete(immobilie);

            if(success){
                Messages.info(immobilie.getAdresse() + " erfolgreich gelöscht.");
            }else{
                Messages.warning(immobilie.getAdresse() + " nicht gelöscht.");
            }
            reload();
        }catch(ImmobilienException e){
            Messages.error(e);
        }catch(Exception e){
            Messages.error("Unerwarteter Fehler " + e);
        }
    }

    @Override
    public void onHelp(){

    }

    @Override
    public void onAbout(){

    }

    public void onSearch(ActionEvent event) throws ImmobilienException{
        Immobilie immobilie = selectedImmobilie.get();
        Immobilie found = service.findById(id.get());
        if(found != null){
            Messages.info(found.toString() + " wurde gefunden!");
        }else{
            Messages.info("Keine Immobilie mit der ID: " + id.get() + " in der Liste vorhanden!");
        }
    }

    //Get Event Handler

    public EventHandler<ActionEvent> getEditAction(){
        return new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                onEdit();
            }
        };
    }

    public EventHandler<ActionEvent> getLoadAction(){
        return new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                onLoad();
            }
        };
    }

    public EventHandler<ActionEvent> getSaveAction(){
        return new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                onSave();
            }
        };
    }

    public EventHandler<ActionEvent> getExitAction(){
        return new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                onExit();
            }
        };
    }

   /* public EventHandler<ActionEvent> getCreateAction() {
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                onCreate();
            }
        };
    }*/

    public EventHandler<ActionEvent> getCreateGrundstueckAction(){
        return new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                onCreateGrundsteuck();
            }
        };
    }

    public EventHandler<ActionEvent> getCreateWohnhausAction(){
        return new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                onCreateWohnhaus();
            }
        };
    }

    public EventHandler<ActionEvent> getDeleteAction(){
        return new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                onDelete();
            }
        };
    }

    public EventHandler<ActionEvent> getSearchAction(){
        return event -> {
            try{                                 //Ist ein try-catch Block hier erlaubt?
                onSearch(event);
            }catch(ImmobilienException e){
                Messages.info(e.getMessage());
                e.printStackTrace();
            }
        };
    }


}
