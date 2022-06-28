package at.ac.fhkufstein.bank.entities;

import java.util.ArrayList;


public class Kunde {
    private long kundenId;
    private String vorname;
    private String nachname;
    private String strasse;
    private String plz;
    private String ort;
    private ArrayList<Konto> konto;


    public Kunde(long kundenId, String vorname, String nachname, String strasse, String plz, String ort, ArrayList<Konto> konto) {
        this.kundenId = kundenId;
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.konto = konto;
    }

    public Kunde() {
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public long getKundenId() {
        return kundenId;
    }

    public void setKundenId(long kundenId) {
        this.kundenId = kundenId;
    }
    public ArrayList<Konto> getKonto() {
        return konto;
    }

    public void setKonto(ArrayList<Konto> konto) {
        this.konto = konto;
    }
}
