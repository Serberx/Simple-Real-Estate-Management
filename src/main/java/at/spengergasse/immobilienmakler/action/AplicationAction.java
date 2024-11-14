package at.spengergasse.immobilienmakler.action;

public interface AplicationAction {
//    public void onCreate();
    public void onCreateGrundsteuck();
    public void onCreateWohnhaus();
    public void onLoad();
    public void onSave();
    public void onEdit();
    public void onExit();
    public void onDelete();
    public void onHelp();
    public void onAbout();
}
