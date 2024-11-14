package at.spengergasse.immobilienmakler.persistence;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Grundstueck;
import at.spengergasse.immobilienmakler.model.Immobilie;
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

public class GrundtueckViewModel {

    private Immobilie immobilie;
    private Grundstueck grundstueck;
    private Service<Immobilie> service;
    private ObjectProperty<Immobilie> selectedImmobilie;
    private ChangeListener<Immobilie> changeListener;

    private StringProperty id;
    private StringProperty adresse;
    private DoubleProperty flaeche;
    private ObjectProperty<Character> widmung;
    private DoubleProperty qmPreis;

    public GrundtueckViewModel(){
        initProperties();
        initService();
    }
    public void initService(){
        service = ImmobilieService.getInstance();
    }

    public void initProperties(){
        id = new SimpleStringProperty(null);
        adresse = new SimpleStringProperty("Spengergasse 5, 1050 Wien");
        flaeche = new SimpleDoubleProperty(100);
        widmung = new SimpleObjectProperty<>(/*'B'*/);
        qmPreis = new SimpleDoubleProperty(2);
        selectedImmobilie = new SimpleObjectProperty<>();
        changeListener = new ChangeListener<Immobilie>() {

            @Override  //hier Grundstueck oder Immobilie richtig?
            public void changed(ObservableValue<? extends Immobilie> observable, Immobilie oldValue, Immobilie newValue) {
                System.out.println("observable: "+observable+"\n");
                System.out.println("oldValue: "+ oldValue+"\n");
                System.out.println("newValue: "+ newValue+"\n");
                setData((Grundstueck) newValue);
            }
        };
        selectedImmobilie.addListener(changeListener);
    }

    //Getter
    public String getId(){
        return this.id.get();
    }
    public StringProperty idProperty(){
        return this.id;
    }
    public String getAdresse(){
        return this.adresse.get();
    }
    public StringProperty adresseProperty(){
        return adresse;
    }
    public double getFlaeche(){
        return Math.round(this.flaeche.get());
//        return this.flaeche.get();
    }
    public DoubleProperty flaecheProperty(){
        return this.flaeche;
    }
    public char getWidmung(){
        return widmung.get();
    }
    public ObjectProperty<Character> widmungProperty(){
        return widmung;
    }
    public double getQmPreis(){
        return Math.round(this.qmPreis.get());

//        return this.qmPreis.get();

        /*double a = this.qmPreis.get();
        double scale = Math.pow(10,3);
        return Math.round(a*scale)/scale;*/

    }
    public DoubleProperty qmPreisProperty(){
        return qmPreis;
    }
    public Immobilie getSelectedImmobilie(){
        return selectedImmobilie.get();
    }
    public ObjectProperty<Immobilie> selectedImmobilieProperty(){
        return selectedImmobilie;
    }

    //Actions
    public void setData(Grundstueck grundstueck){
        if(grundstueck != null){
            this.grundstueck = grundstueck;
            id.set(String.valueOf(grundstueck.getIdentifikationsNr()));
            adresse.set(grundstueck.getAdresse());
            flaeche.set(grundstueck.getFlaeche());
            widmung.set(grundstueck.getWidmung());
            qmPreis.set(grundstueck.getQmPreis());
        }
    }

    public void onSave(ActionEvent event){
        try {
            if(grundstueck == null) {
                grundstueck = new Grundstueck();
            }
            grundstueck.setAdresse(getAdresse());
            grundstueck.setFlaeche(getFlaeche());
            grundstueck.setWidmung(getWidmung());
            grundstueck.setQmPreis(getQmPreis());

            service.merge(grundstueck);
            close(event);

        }catch(ImmobilienException e){
            Messages.error(e);
        }catch (NullPointerException e){
            Messages.error(e.getMessage());
        }
    }

    public void close( ActionEvent event){
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

    public void onCancel(ActionEvent event){
        close(event);
    }

    //Get Eventhandler
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
