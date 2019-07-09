package Model;
import java.util.*;


public class Korpa {
   // parovi proizvod, odabrana kolicina
   private HashMap<Proizvod, Integer> proizvodi;

   public Korpa() {
      proizvodi = new HashMap<>();
   }

   public Korpa(HashMap<Proizvod, Integer> proizvodi) {
      this.proizvodi = proizvodi;
   }

   public HashMap<Proizvod, Integer> getProizvodi() {
      return this.proizvodi;
   }

   public void setProizvodi(HashMap<Proizvod, Integer> proizvodi) {
      this.proizvodi = proizvodi;
   }

   public void dodajProizvod(Proizvod p, int kolicina){
      proizvodi.put(p, kolicina);
   }


}