package Model;

import java.util.*;

public class Registrovani extends Korisnik {
   private String korisnickoIme;
   private String lozinka;
   private String mejl;
   private HashMap<Proizvod, Integer> kupljeniProizvodi;

   public void dodajProizvod(Proizvod p, int kol)
   {
      this.kupljeniProizvodi.put(p, kol);
   }

   public HashMap<Proizvod, Integer> getKupljeniProizvodi() {
      return kupljeniProizvodi;
   }

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
      this.kupljeniProizvodi = new HashMap<Proizvod, Integer>();
   }

   public Registrovani() {
      this.kupljeniProizvodi = new HashMap<Proizvod, Integer>();
   }

   public Registrovani(String ime, String prezime, String adresa, String brTelefona, String brKartice, String korisnickoIme, String lozinka, String mejl) {
      super(ime, prezime, adresa, brTelefona, brKartice);
      this.korisnickoIme = korisnickoIme;
      this.lozinka = lozinka;
      this.mejl = mejl;
      this.kupljeniProizvodi = new HashMap<Proizvod, Integer>();
   }
}