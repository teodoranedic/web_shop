package Model;

import java.io.IOException;
import java.util.*;

import static Controller.Main.*;
import static Controller.Main.komboSort;


public class PregledSajta extends Stanje {
   public PregledSajta(WebShop wb) {
      super(wb);
   }

   public void entry() {
   }

   public void exit() {
   }
   public void ubacivanjeUKorpu() {
      // TODO: implement
   }

   public void odabraniFilter(String f) {
      // TODO: implement
   }
   public void klikNaProizvod() throws IOException {
      kontekst.promeniStanje(new PregledProizvoda(kontekst));
      kontekst.osveziProizvod();
   }

   @Override
   public void klikNaNadji() throws IOException {
      kontekst.promeniStanje(new PregledSajta(kontekst));
      kontekst.setPromena(true);
      kontekst.osveziSajt();
   }
   @Override
   public void klikNaPretrazi() throws IOException {
      if (!trazi.equals("")) {
         kontekst.promeniStanje(new PregledSajta(kontekst));
         kontekst.setPromena(true);
         kontekst.osveziSajt();
      }
      else {
         kontekst.setPromena(false); //treba da ispise da nema rezultata pretrage
         kontekst.osveziSajt();
      }
   }

   public void nastavakKupovine() {

   }
   public void klikniNaKorpu() {
      kontekst.promeniStanje(new PregledSajta(kontekst));
      kontekst.prikaziKorpu();
   }
   
   /** @pdOid cb711889-4ebf-4d28-80aa-bac042027430 */
   public void potrvrdaKupovine() {
      // TODO: implement
   }
   
   /** @pdOid f37e0ed3-b28f-4950-878b-8921fc38306e */
   public void brisanjeProizvoda() {
      // TODO: implement
   }
   
   /** @pdOid c4eee728-e4e4-48bf-8ba8-20817038b521 */
   public void neodobrenaKupovina() {
      // TODO: implement
   }
   
   /** @pdOid 35057e40-7fe1-467b-b205-bdf231d0e109 */
   public void izvrsenoPlacanje() {
      // TODO: implement
   }
   
   /** @pdOid 9739c345-0ab0-4379-a4b0-263c64099b60 */
   public void odobrenaKupovina() {
      // TODO: implement
   }

}