package Model;
import Controller.Main;

import java.io.IOException;
import java.util.*;
public class PregledProizvoda extends Stanje {
   public PregledProizvoda(WebShop wb) {
      super(wb);
   }
   public void entry() {
      // TODO: implement
   }
   public void exit() {
      // TODO: implement
   }
   public void ubacivanjeUKorpu() {
      // TODO: implement
   }

   public void odabraniFilter(String f) {
      // TODO: implement
   }
   public void klikNaProizvod() {
      // TODO: implement
   }

   @Override
   public void klikNaNadji() throws IOException {

   }

   @Override
   public void klikNaPretrazi() throws IOException {

   }

   public void nastavakKupovine() {
      kontekst.promeniStanje(new PregledSajta(kontekst));
      if(Main.trenutniKorisnik !=null){
         kontekst.setPromena(true);
      }
      else{
         kontekst.setPromena(false);//nije ulogovan
      }
      kontekst.vratiNaSajt();
   }

   public void klikniNaKorpu() {
      // TODO: implement
   }
   public void potrvrdaKupovine() {
      // TODO: implement
   }
   
   public void brisanjeProizvoda() {
      // TODO: hocemo implement
   }
   public void neodobrenaKupovina() {
      // TODO: implement
   }
   public void izvrsenoPlacanje() {
      // TODO: implement
   }
   
   public void odobrenaKupovina() {
      // TODO: implement
   }

}