package Model;
import Controller.Main;

import java.io.FileNotFoundException;
import java.util.*;

public class Placanje extends StanjePorudzbine {
   public Placanje(Porudzbina k) {
      super(k);
   }

   public void odabranoPlacanje() {
   }
   
   public void zavrsenoPlacanje() throws FileNotFoundException {
      // TODO: provera da li su svi uneti, ako jesu ide na stanje zaotpremu
      if (Main.trenutniKorisnik != null) {
         Main.trenutniKorisnik.getKorpa().getPorudzbina().dodajProizvodeIzKorpe();
      }
      kontekst.setPromena(true);
      kontekst.promeniStanje(new ZaOtpremu(kontekst));
      kontekst.osvezi();
   }
   
   public void magacionerOtpremio() {
   }

   @Override
   public void povratakNazad() {
      kontekst.setPromena(true);
      kontekst.promeniStanje(new Priprema(kontekst));
      kontekst.osveziProzor();
   }

   public void entry() {
      // TODO: unos podataka?
   }
   
   public void exit() {
      if (Main.trenutniKorisnik != null) {
         Main.trenutniKorisnik.getKorpa().getPorudzbina().isprazniKorpu();
      }
      else {
         Main.anonimnaKorpa.getPorudzbina().isprazniKorpu();
      }
   }

}