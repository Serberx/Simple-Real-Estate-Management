package at.spengergasse.immobilienmakler.viewModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.*;
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

public class ImmobilienViewModel {

    private Immobilie immobilie;
    private Service<Immobilie> service;
    private ObjectProperty<Immobilie> selectedImmobilie;

    private StringProperty id;
    private StringProperty adresse;
    private DoubleProperty flaeche;
    private DoubleProperty verkehrswert;
    private ObjectProperty<Character> kategorie;
    private DoubleProperty einheitswert;
    private ObjectProperty<Character> widmung;
    private DoubleProperty qmPreis;

    private ChangeListener<Immobilie> changeListener;

    public ImmobilienViewModel() {
        initProperties();
        initService();

    }
    public void initService(){
        this.service = ImmobilieService.getInstance();
//        this.service = new ImmobilieService();   //private, damit keine weiteren Objekte erzeugt werden können
    }

    public void initProperties() {
        id           = new SimpleStringProperty(null);
        adresse      = new SimpleStringProperty("Spengergasse 5, 1050 Wien");
        flaeche      = new SimpleDoubleProperty(55);
        verkehrswert = new SimpleDoubleProperty();
        kategorie    = new SimpleObjectProperty<>('A'/*Constants.INIT_CHARACTER*/);
        einheitswert = new SimpleDoubleProperty(10000);
        widmung      = new SimpleObjectProperty<>('B'/*Constants.INIT_CHARACTER*/);
        qmPreis      = new SimpleDoubleProperty(10);

        changeListener = new ChangeListener<Immobilie>() {

            @Override
            public void changed(ObservableValue<? extends Immobilie> observable, Immobilie oldValue, Immobilie newValue) {
                System.out.println("observable" + observable);
                System.out.println("oldvalue = " + oldValue + " newValue = " + newValue);
                setData(newValue);
            }
        };

        selectedImmobilie = new SimpleObjectProperty<>();
        selectedImmobilie.addListener(changeListener);

    }

    //Getter Properties
    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getAdresse() {
        return adresse.get();
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public double getFlaeche() {
        return Math.round(this.flaeche.get());
//        return flaeche.get();
    }

    public DoubleProperty flaecheProperty() {
        return flaeche;
    }

    public double getVerkehrswert() {
        return verkehrswert.get();
    }

    public DoubleProperty verkehrswertProperty() {
        return verkehrswert;
    }

    public char getKategorie() {
        return kategorie.get();
    }

    public ObjectProperty<Character> kategorieProperty() {
        return kategorie;
    }

    public double getEinheitswert() {
        return Math.round(this.einheitswert.get());
//        return einheitswert.get();
    }

    public DoubleProperty einheitswertProperty() {
        return einheitswert;
    }

    public char getWidmung() {
        return widmung.get();
    }

    public ObjectProperty<Character> widmungProperty() {
        return widmung;
    }

    public double getQmPreis() {
        return qmPreis.get();
    }

    public DoubleProperty qmPreisProperty() {
        return qmPreis;
    }

    public Immobilie getSelectedImmobilie() {
        return selectedImmobilie.get();
    }

    public ObjectProperty<Immobilie> selectedImmobilieProperty() {
        return selectedImmobilie;
    }

    //Actions
    private void setData(Immobilie immobilie) {
        if( immobilie != null ) {
            this.immobilie = immobilie;
            id.set(String.valueOf(immobilie.getIdentifikationsNr()));
            adresse.set(immobilie.getAdresse());
            flaeche.set(immobilie.getFlaeche());
            verkehrswert.set(immobilie.berechneVerkehrswert());
            if( immobilie instanceof Wohnhaus ) {
                kategorie.set(( (Wohnhaus) immobilie ).getKategorie());

            }
            if( immobilie instanceof Wohnhaus ) {
                einheitswert.set(( (Wohnhaus) immobilie ).getEinheitswert());

            }
            if( immobilie instanceof Grundstueck ) {
                widmung.set(( (Grundstueck) immobilie ).getWidmung());

            }
            if( immobilie instanceof Grundstueck ) {
                qmPreis.set(( (Grundstueck) immobilie ).getQmPreis());

            }

        }
    }

    public void onSave(ActionEvent event) {
        try {
            if(immobilie == null){
                immobilie = new Immobilie() {
                    double wert = 0.0;
                    @Override
                    public double berechneVerkehrswert() {
                        if(immobilie instanceof Wohnhaus) {
                            switch(( (Wohnhaus) immobilie ).getKategorie()) {
                                case 'A': wert =  5*getEinheitswert();
                                case 'B': wert =  3*getEinheitswert();
                                case 'C': wert =  2*getEinheitswert();
                                case 'D': wert =  1*getEinheitswert();
                                default:
                                    System.out.println("Error onSave Wohnhaus");
                            }
                        }
                        if(immobilie instanceof Grundstueck){
                            switch(( (Grundstueck) immobilie ).getWidmung()){
                                case 'B': wert = getQmPreis()*ImmobilienViewModel.this.getFlaeche()*2;
                                case 'N': wert = getQmPreis()*ImmobilienViewModel.this.getFlaeche()/2;
                                case 'G', '?': wert = getQmPreis()*ImmobilienViewModel.this.getFlaeche();
                                default:System.out.println("Error onSave Grundstück");
                            }
                        }

                        return wert;
                    }
                };
            }

//            immobilie.setIdentifikationsNr(getId());
            immobilie.setAdresse(getAdresse());
            immobilie.setFlaeche(getFlaeche());
            if(immobilie instanceof Wohnhaus){
                ( (Wohnhaus) immobilie ).setEinheitswert(getEinheitswert());
                ( (Wohnhaus) immobilie ).setKategorie(getKategorie());

            }


            if(immobilie instanceof Grundstueck){
                ( (Grundstueck) immobilie ).setQmPreis(getQmPreis());
                ( (Grundstueck) immobilie ).setWidmung(getWidmung());

            }

            service.merge(this.immobilie);
            close(event);

        }catch(ImmobilienException e){
            Messages.info(e);
        }

    }

    public void close(ActionEvent event){
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

    //Getter EventHandler
    public EventHandler<ActionEvent> getSaveAction() {

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
