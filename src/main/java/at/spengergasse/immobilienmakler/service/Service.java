package at.spengergasse.immobilienmakler.service;

import at.spengergasse.immobilienmakler.enumeration.PersisterType;
import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;

import java.util.List;

public abstract class Service<T> {

    public Immobilienmakler immobilienmakler = new Immobilienmakler();
    public static Integer idCounter = 0;
    public abstract List<T> findAll() /*throws  ImmobilienException*/;
    public abstract T findById(int id) throws ImmobilienException;

    public abstract  void merge(T entity) throws ImmobilienException;
    public abstract boolean deleteById(int id) throws ImmobilienException;
    public abstract boolean delete(T entity) throws ImmobilienException;

    public abstract void save(String filenName, PersisterType type) throws ImmobilienException;
    public abstract void load(String fileName, PersisterType type) throws ImmobilienException;
    public void print(){
        immobilienmakler.toString();
    }

}
