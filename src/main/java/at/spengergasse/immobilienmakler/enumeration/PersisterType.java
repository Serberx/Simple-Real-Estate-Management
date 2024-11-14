package at.spengergasse.immobilienmakler.enumeration;

public enum PersisterType{

    SER("Serialisieren", "SER"), CSV("Comma-separated-values", "CSV"), TEXT("Text-File", "TXT");

    private String langtext;
    private String kurztext;

    PersisterType(String langtext, String kurztext){
        this.langtext = langtext;
        this.kurztext = kurztext;
    }

    public String getLangtext(){
        return this.langtext;
    }

    public String getKurztext(){
        return this.kurztext;
    }
}
