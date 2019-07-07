package Model;

import java.util.*;


public class Kategorija {

   private String naziv;
   public Kategorija(String naziv) {
      this.naziv = naziv;
   }

   public String getNaziv() {
      return naziv;
   }

   public void setNaziv(String naziv) {
      this.naziv = naziv;
   }
}