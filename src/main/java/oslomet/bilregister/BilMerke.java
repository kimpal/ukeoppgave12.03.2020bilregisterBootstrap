package oslomet.bilregister;

public class BilMerke {
    private String merke;
    private String BilType;

    public BilMerke(String merke, String BilType) {
        this.merke = merke;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getBilType() {
        return BilType;
    }

    public void setBilType(String bilType) {
        BilType = bilType;
    }
}