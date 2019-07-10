package Model;
import java.util.*;

public class Placanje extends StanjePorudzbine {
   public Placanje(Porudzbina k) {
      super(k);
   }

   public void odabranoPlacanje() {
   }
   
   public void zavrsenoPlacanje() {
      // TODO: provera da li su svi uneti, ako jesu ide na stanje zaotpremu
      // ako nisu ostaje u istom i ispisuje sva polja obavezna

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
      // TODO: pokusaj placanje???
   }

}