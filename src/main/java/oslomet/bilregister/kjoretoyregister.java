package oslomet.bilregister;

public class kjoretoyregister {
    private String   personnummer;
    private String   navn;
    private String   adresse;
    private String   kjenetegn;
    private String   bilmerke;
    private String   biltype;

    public kjoretoyregister( String personnummer,String   navn, String   adresse, String   kjenetegn, String   bilmerke, String   biltype ){
        this.personnummer = personnummer;
        this.navn = navn;
        this.adresse = adresse;
        this.kjenetegn = kjenetegn;
        this.bilmerke = bilmerke;
        this.biltype = biltype;
    }
    public kjoretoyregister(){ }

    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getKjenetegn() {
        return kjenetegn;
    }

    public void setKjenetegn(String kjenetegn) {
        this.kjenetegn = kjenetegn;
    }

    public String getBilmerke() {
        return bilmerke;
    }

    public void setBilmerke(String bilmerke) {
        this.bilmerke = bilmerke;
    }

    public String getBiltype() {
        return biltype;
    }

    public void setBiltype(String biltype) {
        this.biltype = biltype;
    }
}

