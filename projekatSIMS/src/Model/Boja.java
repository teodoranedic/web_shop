package Model;

import java.lang.String;

public class Boja {

   private String sifra; //promenila sam na string i onda se stavlja pravi naziv za boju iz fx-a
   private String naziv;

   public Boja(String sifra, String naziv) {
      this.sifra = sifra;
      this.naziv = naziv;
   }
   public Boja(String[] tokens) {
      this.sifra = tokens[0];
      this.naziv = tokens[1];
   }

   public String getSifra() {
      return sifra;
   }

   public void setSifra(String sifra) {
      this.sifra = sifra;
   }

   public String getNaziv() {
      return naziv;
   }

   public void setNaziv(String naziv) {
      this.naziv = naziv;
   }
}