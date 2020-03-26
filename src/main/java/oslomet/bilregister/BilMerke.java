package oslomet.bilregister;

public class BilMerke {
    private String merke;
    private String modell;

    public BilMerke(String merke, String modell) {
        this.merke = merke;
        this.modell = modell;
    }

    public BilMerke() {
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }
}