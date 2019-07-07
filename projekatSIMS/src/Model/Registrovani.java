package Model;

import java.util.*;

public class Registrovani extends Korisnik {
   private String korisnickoIme;
   private String lozinka;
   private String mejl;

   public String getKorisnickoIme() {
      return korisnickoIme;
   }

   public void setKorisnickoIme(String korisnickoIme) {
      this.korisnickoIme = korisnickoIme;
   }

   public String getLozinka() {
      return lozinka;
   }

   public void setLozinka(String lozinka) {
      this.lozinka = lozinka;
   }

   public String getMejl() {
      return mejl;
   }

   public void setMejl(String mejl) {
      this.mejl = mejl;
   }

   public Registrovani(String[] tokens) {
      super(tokens);
      this.korisnickoIme = tokens[0];
      this.lozinka = tokens[1];
      this.mejl = tokens[5];
   }

   public Registrovani() {}
}