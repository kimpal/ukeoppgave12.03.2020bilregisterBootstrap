package oslomet.bilregister;

public class BilType {
        private String typebil;
        private String typelable;

        public BilType(String typebil, String typelable) {
            this.typebil = typebil;
            this.typelable =typelable;
        }

    public String getTypelable() {
        return typelable;
    }

    public void setTypelable(String typelable) {
        this.typelable = typelable;
    }

    public String getTypebil() {
            return typebil;
        }

        public void setTypebil(String typebil) {
            this.typebil = typebil;
        }
    }
