package Model;

import Controller.Main;

import java.io.FileNotFoundException;
import java.util.*;

public class ZaOtpremu extends StanjePorudzbine {
   public ZaOtpremu(Porudzbina k) {
      super(k);
   }

   public void odabranoPlacanje() {
      // TODO: implement
   }
   
   public void zavrsenoPlacanje() throws FileNotFoundException {
   }
   
   public void magacionerOtpremio() {
      // TODO: NE implement
   }

   @Override
   public void povratakNazad() {

   }


   public void entry() {
      if (Main.trenutniKorisnik != null) {
         Main.trenutniKorisnik.getKorpa().getPorudzbina().isprazniKorpu();
      }
      else {
         Main.anonimnaKorpa.getPorudzbina().isprazniKorpu();
      }
   }
   

   public void exit() {
      // TODO: implement
   }

}