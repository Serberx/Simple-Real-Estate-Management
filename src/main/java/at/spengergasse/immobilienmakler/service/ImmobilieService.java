package at.spengergasse.immobilienmakler.service;

import at.spengergasse.immobilienmakler.enumeration.PersisterType;
import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilie;

import java.util.List;

public class ImmobilieService extends Service<Immobilie> {

    private static final ImmobilieService INSTANCE = new ImmobilieService();


    public static ImmobilieService getInstance() {
        return INSTANCE;
    }

    private ImmobilieService() {
    }

    @Override
    public List<Immobilie> findAll() /*throws ImmobilienException*/ {
        return immobilienmakler.getAll();
    }

    @Override
    public Immobilie findById(int id) throws ImmobilienException {
        return immobilienmakler.getId(id);
    }

    @Override       //TODO id nicht nochmal / neu setzen, wenn editiert wird.
    public void merge(Immobilie entity) throws ImmobilienException {

        if(entity.getIdentifikationsNr() != null){
            entity.setIdentifikationsNr(idCounter++);
            immobilienmakler.add(entity);
        }else{
//            if(entity.getIdentifikationsNr() != null) {
//                entity.setIdentifikationsNr(idCounter++);
//                immobilienmakler.add(entity);
            }
//        }

        /*if( entity.getIdentifikationsNr() != null ||  entity.getIdentifikationsNr() != entity.getIdentifikationsNr()) {
            // Setzen einer ID simuliert die Aufnahme in die DB
            entity.setIdentifikationsNr(idCounter++);
            immobilienmakler.add(entity);
        }else {
            if( entity.getIdentifikationsNr() == entity.getIdentifikationsNr())
            // Update in der DB durchführen - nicht notwendig
            immobilienmakler.add(entity);
        }*/

    }

    @Override
    public boolean deleteById(int id) throws ImmobilienException {
        return immobilienmakler.removeID(id);
    }

    @Override
    public boolean delete(Immobilie entity) throws ImmobilienException {
        return immobilienmakler.removeEntity(entity);
    }

    @Override
    public void save(String filenName, PersisterType type) throws ImmobilienException {
        immobilienmakler.speichern2Map(filenName, type);
    }

    @Override
    public void load(String fileName, PersisterType type) throws ImmobilienException {
        immobilienmakler.laden2Map(fileName, type);
    }

}
