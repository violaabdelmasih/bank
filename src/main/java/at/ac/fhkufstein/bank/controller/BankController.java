package at.ac.fhkufstein.bank.controller;

import at.ac.fhkufstein.bank.entities.Konto;
import at.ac.fhkufstein.bank.entities.Kunde;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@RestController
public class BankController {

    public static ArrayList<Kunde> kunden;

    @PostConstruct
    public void createTestData() {

        if (kunden == null) {
            kunden = new ArrayList<>();
            kunden.add(new Kunde(1L, "Franz", "Huber", "Maximillianstrasse", "6020", "Innsbruck", null));
            kunden.add(new Kunde(2L, "Herbert", "Egger", "Franzstrasse", "3420", "Wien", null));
        }

        if (kunden.get(0).getKonto() == null) {
            ArrayList<Konto> konten = new ArrayList<>();
            konten.add(new Konto(1L, "AT124516759842", 333, 45879, "Girokonto"));
            konten.add(new Konto(2L, "AT124597832542", 652, 325468, "Girokonto"));
            konten.add(new Konto(3L, "AT258862917926", 215, 54629, "Girokonto"));
            kunden.get(0).setKonto(konten);
        }

        if (kunden.get(1).getKonto() == null) {
            ArrayList<Konto> konten = new ArrayList<>();
            konten.add(new Konto(4L, "AT548888169411", 213, 21579, "Girokonto"));
            konten.add(new Konto(5L, "AT554125752363", 123, 326549, "Girokonto"));
            kunden.get(1).setKonto(konten);
        }

    }

    @GetMapping("/showKunde")
    public Kunde showKunde(@RequestParam int kundenId) {
        return kunden.get(kundenId - 1);
    }

    @GetMapping(("/showAlleKunden"))
    public ArrayList<Kunde> showAlleKunden() {
        return kunden;
    }

    @GetMapping(("/showKontostand"))
    public int showKontostand(@RequestParam int kundenId, @RequestParam int kontenId) {

        Konto konto = kunden.get(kundenId - 1).getKonto().get(kontenId - 1);

        return konto.getKontostand();
        // return: kunden.get(kundenId - 1).getKonto().get(kontenId - 1).getKontostand();
    }


    @PostMapping("/setTransaktion")
    public String setTransaktion(@RequestParam int senderID, @RequestParam int empfaengerID,
                             @RequestParam int senderKontoID,  @RequestParam int empfaengerKontoID, @RequestParam int betrag) {


        Kunde sender = kunden.get(senderID - 1);
        Kunde empfaenger = kunden.get(empfaengerID -1);

        Konto senderKonto = sender.getKonto().get(senderKontoID -1);
        Konto empfaengerKonto = empfaenger.getKonto().get(empfaengerKontoID-1);

        int senderKontostand = senderKonto.getKontostand(); // 122
        int empfaengerKotostand= empfaengerKonto.getKontostand(); // 120

        if(senderKontostand < betrag){
            return "Kontostand zu gering";
        }

        senderKontostand = senderKontostand - betrag;
        empfaengerKotostand = empfaengerKotostand + betrag;

        senderKonto.setKontostand(senderKontostand);
        empfaengerKonto.setKontostand(empfaengerKotostand);

        return "Transaktion erfolgreich durchgeführt";

    }
}







