package Model;
import java.util.*;

public class Priprema extends StanjePorudzbine {
   public Priprema(Porudzbina k) {
      super(k);
   }

   public void odabranoPlacanje() {
      // ako jesu onda menja stanje ako ne onda nista
      // Prvo proveri da li je prazna lista sa proizvodima tj korpa

      if(kontekst.getProizvodi().size() == 0){
         //salje da treba da se ispise da je korpa prazna
         kontekst.setPromena(false);
         kontekst.osveziProzor();

      }else{
         //menja stanje
         kontekst.setPromena(true);
         kontekst.promeniStanje(new Placanje(kontekst));
         kontekst.osveziProzor();
      }

   }
   
   public void zavrsenoPlacanje() {
   }
   
   public void magacionerOtpremio() {
   }

   @Override
   public void povratakNazad() {

   }

   public void entry() {
   }
   
   public void exit() {
   }

}