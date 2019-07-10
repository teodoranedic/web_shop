package Model;
import Controller.Main;
import EventHandler.UpdateEvent;
import EventHandler.UpdateEventZaOtpremu;
import EventHandler.UpdateListener;
import EventHandler.UpdateListenerZaOtpremu;
import FileHandler.KorisniciFile;

import java.io.FileNotFoundException;
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

   public void dodajProizvodeIzKorpe() throws FileNotFoundException {
      if (Main.trenutniKorisnik != null) {
         for (java.util.Map.Entry<Model.Proizvod, Integer> s : Main.trenutniKorisnik.getKorpa().getProizvodi().entrySet()) {
            Main.trenutniKorisnik.dodajProizvod(s.getKey(), s.getValue());
         }
         KorisniciFile.upis();
      }
   }

   public void isprazniKorpu() {
      if (Main.trenutniKorisnik != null) {
         Main.trenutniKorisnik.getKorpa().getProizvodi().clear();
      }
      else {
         Main.anonimnaKorpa.getProizvodi().clear();
      }
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
   

   public void ZavrsenoPlacanje() throws FileNotFoundException {
      tekuceStanje.zavrsenoPlacanje();
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
      if (novoStanje.getClass() == ZaOtpremu.class) {
         tekuceStanje = new Priprema(this);
      }
   }

   private UpdateListener listeners;
   private UpdateListenerZaOtpremu listenerZaOtpremu;

   public void addListener(UpdateListener l) {
      listeners = l;
   }

   public void addListenerZaOtpremu(UpdateListenerZaOtpremu listener1) { listenerZaOtpremu = listener1;};

   public void removeListener(UpdateListener l) {
      listeners = null;
   }
   public void osvezi() {
      UpdateEventZaOtpremu e = new UpdateEventZaOtpremu(this, promena);
      listenerZaOtpremu.updatePerformed(e);
   }

   public void osveziProzor() {
      UpdateEvent e = new UpdateEvent(this, promena);
      listeners.updatePerformed(e);
     }

}