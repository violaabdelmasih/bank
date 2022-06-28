package at.ac.fhkufstein.bank.entities;

public class Konto {
    private long kontoId;
    private String iban;
    private int bic;
    private int kontostand;
    private String kontoart;



    public Konto(long kontoId, String iban, int bic, int kontostand, String kontoart) {
        this.kontoId = kontoId;
        this.iban = iban;
        this.bic = bic;
        this.kontostand = kontostand;
        this.kontoart = kontoart;
    }

    public Konto() {
    }
    public String getKontoart() {
        return kontoart;
    }
    public void setKontoart(String kontoart) {
        this.kontoart = kontoart;
    }

    public int getKontostand() {
        return kontostand;
    }

    public void setKontostand(int kontostand) {
        this.kontostand = kontostand;
    }

    public int getBic() {
        return bic;
    }

    public void setBic(int bic) {
        this.bic = bic;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getKontoId() {
        return kontoId;
    }

    public void setKontoId(long kontoId) {
        this.kontoId = kontoId;
    }
}
