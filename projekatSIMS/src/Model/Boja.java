package Model;

import java.lang.String;

public class Boja {

   private int sifra;
   private String naziv;

   public Boja(int sifra, String naziv) {
      this.sifra = sifra;
      this.naziv = naziv;
   }

   public int getSifra() {
      return sifra;
   }

   public void setSifra(int sifra) {
      this.sifra = sifra;
   }

   public String getNaziv() {
      return naziv;
   }

   public void setNaziv(String naziv) {
      this.naziv = naziv;
   }
}