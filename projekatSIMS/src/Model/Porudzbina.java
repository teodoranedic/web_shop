package Model;
import EventHandler.UpdateEvent;
import EventHandler.UpdateListener;

import java.util.*;


public class Porudzbina {
   private StanjePorudzbine tekuceStanje;
   private Date datum;
   public PodaciZaSlanje podaciZaSlanje;
   private HashMap<Proizvod, Integer> proizvodi = new HashMap<Proizvod, Integer>();
   private boolean promena = false;

   public boolean isPromena() {
      return promena;
   }

   public void setPromena(boolean promena) {
      this.promena = promena;
   }

   public StanjePorudzbine getTekuceStanje() {
      return tekuceStanje;
   }

   public void setTekuceStanje(StanjePorudzbine tekuceStanje) {
      this.tekuceStanje = tekuceStanje;
   }

   public Date getDatum() {
      return datum;
   }

   public void setDatum(Date datum) {
      this.datum = datum;
   }

   public PodaciZaSlanje getPodaciZaSlanje() {
      return podaciZaSlanje;
   }

   public void setPodaciZaSlanje(PodaciZaSlanje podaciZaSlanje) {
      this.podaciZaSlanje = podaciZaSlanje;
   }

   public HashMap<Proizvod, Integer> getProizvodi() {
      return proizvodi;
   }

   public void setProizvodi(HashMap<Proizvod, Integer> proizvodi) {
      this.proizvodi = proizvodi;
   }

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
   

   public void OdabranoPlacanje() {
      // TODO: implement!!!!!!!!!!!!!!!!
      tekuceStanje.odabranoPlacanje();

   }
   

   public int ZavrsenoPlacanje() {
      // TODO: NE implement!!!!!!!!!!!!!!!!!! salim se
      return 0;
   }

   public int MagacionerOtpremio() {
      // TODO:  NE implement uzivajte malo
      return 0;
   }

   public void PovratakNazad() {
      tekuceStanje.povratakNazad();
   }

   public void promeniStanje(StanjePorudzbine novoStanje) {
      tekuceStanje.exit();
      novoStanje.entry();
      tekuceStanje = novoStanje;
   }

   private UpdateListener listeners;


   public void addListener(UpdateListener l) {
      listeners = l;
   }
   public void removeListener(UpdateListener l) {
      listeners = null;
   }

   public void osveziProzor() {
      UpdateEvent e = new UpdateEvent(this, promena);
      //Slanje dogadjaja da se desila promena svima koji su se registrovali za pracenje promena:

      listeners.updatePerformed(e);


      //U slucaju realnog kontrolera, ovde bi se direktno izdavale komande izlaznim uredjajima.
   }

}