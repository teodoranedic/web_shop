package Model;
import java.util.*;


public class Porudzbina {

   private StanjePorudzbine stanje;

   private Date datum;

   private NacinPlacanja nacinPlacanja;

   public PodaciZaSlanje[] podaciZaSlanje;

   public java.util.Collection<StanjePorudzbine> stanjePorudzbine;

   public int unesiPodatke() {
      // TODO: implement
      return 0;
   }

   public int unesiNacinPlacanja() {
      // TODO: implement
      return 0;
   }

   public int pokusajPlacanje() {
      // TODO: implement
      return 0;
   }
   

   public int salji() {
      // TODO: implement
      return 0;
   }

   public int informisiMagacionera() {
      // TODO: implement
      return 0;
   }
   

   public int OdabranoPlacanje() {
      // TODO: implement
      return 0;
   }
   

   public int ZavrsenoPlacanje() {
      // TODO: implement
      return 0;
   }

   public int MagacionerOtpremio() {
      // TODO: implement
      return 0;
   }

   public int promeniStanje() {
      // TODO: implement
      return 0;
   }
   

   public java.util.Collection<StanjePorudzbine> getStanjePorudzbine() {
      if (stanjePorudzbine == null)
         stanjePorudzbine = new java.util.HashSet<StanjePorudzbine>();
      return stanjePorudzbine;
   }

   public java.util.Iterator getIteratorStanjePorudzbine() {
      if (stanjePorudzbine == null)
         stanjePorudzbine = new java.util.HashSet<StanjePorudzbine>();
      return stanjePorudzbine.iterator();
   }
   

   public void setStanjePorudzbine(java.util.Collection<StanjePorudzbine> newStanjePorudzbine) {
      removeAllStanjePorudzbine();
      for (java.util.Iterator iter = newStanjePorudzbine.iterator(); iter.hasNext();)
         addStanjePorudzbine((StanjePorudzbine)iter.next());
   }

   public void addStanjePorudzbine(StanjePorudzbine newStanjePorudzbine) {
      if (newStanjePorudzbine == null)
         return;
      if (this.stanjePorudzbine == null)
         this.stanjePorudzbine = new java.util.HashSet<StanjePorudzbine>();
      if (!this.stanjePorudzbine.contains(newStanjePorudzbine))
         this.stanjePorudzbine.add(newStanjePorudzbine);
   }

   public void removeStanjePorudzbine(StanjePorudzbine oldStanjePorudzbine) {
      if (oldStanjePorudzbine == null)
         return;
      if (this.stanjePorudzbine != null)
         if (this.stanjePorudzbine.contains(oldStanjePorudzbine))
            this.stanjePorudzbine.remove(oldStanjePorudzbine);
   }
   

   public void removeAllStanjePorudzbine() {
      if (stanjePorudzbine != null)
         stanjePorudzbine.clear();
   }

}