package Model;
import java.util.*;


public class Korpa {


   // parovi proizvod, odabrana kolicina
   Porudzbina porudzbina;
   //private HashMap<Proizvod, Integer> proizvodi;

   public Korpa() {
      porudzbina = new Porudzbina();
      porudzbina.setTekuceStanje(new Priprema(this.porudzbina));
   }

   public Korpa(HashMap<Proizvod, Integer> proizvodi) {
      porudzbina = new Porudzbina();
      porudzbina.setTekuceStanje(new Priprema(this.porudzbina));
      porudzbina.setProizvodi(proizvodi);
   }
   public Porudzbina getPorudzbina() {
      return porudzbina;
   }

   public void setPorudzbina(Porudzbina porudzbina) {
      this.porudzbina = porudzbina;
   }
   public HashMap<Proizvod, Integer> getProizvodi() {
      return porudzbina.getProizvodi();
   }

   public void setProizvodi(HashMap<Proizvod, Integer> proizvodi) {
      porudzbina.setProizvodi(proizvodi);
   }

   public void dodajProizvod(Proizvod p, int kolicina){
      porudzbina.getProizvodi().put(p, kolicina);
   }


}