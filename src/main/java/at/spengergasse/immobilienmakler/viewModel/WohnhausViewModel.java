package at.spengergasse.immobilienmakler.viewModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilie;
import at.spengergasse.immobilienmakler.model.Wohnhaus;
import at.spengergasse.immobilienmakler.service.ImmobilieService;
import at.spengergasse.immobilienmakler.service.Service;
import at.spengergasse.immobilienmakler.view.Messages;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WohnhausViewModel {

    private Wohnhaus wohnhaus;
    private Service<Immobilie> service;
    private ObjectProperty<Immobilie> selectedImmobilie;
    private ChangeListener<Immobilie> changeListener;

    private StringProperty id;
    private StringProperty adresse;
    private DoubleProperty flaeche;
    private ObjectProperty<Character> kategorie;
    private DoubleProperty einheitswert;

    //Konstruktor
    public WohnhausViewModel(){
        initProperties();
        initService();
    }
    //InitService
    private void initService(){
        this.service = ImmobilieService.getInstance();
    }
    //InitProperties
    public void initProperties(){
    id = new SimpleStringProperty("Wird automatisch gesetzt!");
    adresse = new SimpleStringProperty("Spengergasse 5, 1050 Wien");
    flaeche = new SimpleDoubleProperty(50);
    kategorie = new SimpleObjectProperty<>('A');
        einheitswert      = new SimpleDoubleProperty(10000);
        selectedImmobilie = new SimpleObjectProperty<>();

    changeListener = new ChangeListener<Immobilie>() {

        @Override
        public void changed(ObservableValue<? extends Immobilie> observable, Immobilie oldValue, Immobilie newValue) {
            System.out.println("observable"+observable+"\n");
            System.out.println("oldValue"+ oldValue+"\n");
            System.out.println("newValue"+ newValue+"\n");
            setData((Wohnhaus) newValue);
        }
    };

    selectedImmobilie.addListener(changeListener);
    }

    //Getter
    public String getId(){
        return this.id.get();
    }
    public StringProperty idProperty(){
        return id;
    }
    public String getAdresse(){
        return adresse.get();
    }
    public StringProperty adresseProperty(){
        return adresse;
    }
    public double getFlaeche(){
        return flaeche.get();
    }
    public DoubleProperty flaecheProperty(){
        return flaeche;
    }
    public char getKategorie(){
        return kategorie.get();
    }
    public ObjectProperty<Character> kategorieProperty(){
        return kategorie;
    }
    public double getEinheitswert(){
        return einheitswert.get();
    }
    public DoubleProperty einheitswertProperty(){
        return einheitswert;
    }
    public Immobilie getSelectedImmobilie(){
        return selectedImmobilie.get();
    }
    public ObjectProperty<Immobilie> selectedImmobilieProperty(){
        return selectedImmobilie;
    }

    //Action
    public void setData(Wohnhaus wohnhaus  ){
        if(wohnhaus != null){
            this.wohnhaus = wohnhaus;
            id.set(String.valueOf(wohnhaus.getIdentifikationsNr()));
            adresse.set(wohnhaus.getAdresse());
            flaeche.set(wohnhaus.getFlaeche());
            kategorie.set(wohnhaus.getKategorie());
            einheitswert.set(wohnhaus.getEinheitswert());
        }
    }


    public void onSave(ActionEvent event){
        try{
            if(wohnhaus == null){
                wohnhaus = new Wohnhaus();
            }
            wohnhaus.setAdresse(getAdresse());
            wohnhaus.setFlaeche(getFlaeche());
            wohnhaus.setKategorie(getKategorie());
            wohnhaus.setEinheitswert(getEinheitswert());

            service.merge(wohnhaus);
            close(event);

        }catch (ImmobilienException e){
            Messages.error(e);
        }
    }

    public void onCancel(ActionEvent event){
        close(event);
    }
    private void close(ActionEvent event){
        if(event.getSource() instanceof Node ){
            Node node = (Node) event.getSource();
            Scene scene = node.getScene();

            if(scene.getWindow() instanceof Stage ){
                selectedImmobilie.removeListener(changeListener);
                Stage stage = (Stage) scene.getWindow();
                stage.close();
            }
        }
    }

    //Get EventHandler
    public EventHandler<ActionEvent> getSaveAction(){
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                onSave(event);
            }
        };
    }
    public EventHandler<ActionEvent> getCancelAction(){
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                onCancel(event);
            }
        };
    }


}
