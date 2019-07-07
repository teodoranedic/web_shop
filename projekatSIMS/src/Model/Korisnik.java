package Model;
import java.util.*;

public class Korisnik {
   protected PodaciZaSlanje podaciZaSlanje = new PodaciZaSlanje();
   protected Korpa korpa;

   public PodaciZaSlanje getPodaciZaSlanje() {
      return podaciZaSlanje;
   }

   public void setPodaciZaSlanje(PodaciZaSlanje podaciZaSlanje) {
      this.podaciZaSlanje = podaciZaSlanje;
   }

   public Korpa getKorpa() {
      return korpa;
   }

   public void setKorpa(Korpa korpa) {
      this.korpa = korpa;
   }

   public Korisnik(String[] tokens) {
      podaciZaSlanje.setIme(tokens[2]);
      podaciZaSlanje.setPrezime(tokens[3]);
      podaciZaSlanje.setAdresa(tokens[4]);
      podaciZaSlanje.setBrojTelefona(tokens[6]);
      podaciZaSlanje.setBrKartice(tokens[7]);
   }

   public Korisnik(){}


}