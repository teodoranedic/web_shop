package Model;
import EventHandler.*;

import java.io.IOException;
import java.util.*;


public class WebShop {

   private String naziv;
   private String link;

   private UpdateListenerZaPregledSajta updateListenerZaPregledSajta;
   private UpdateListenerZaPregledSajtaPP updateP;
   private UpdateListenerZaPregledProizvoda updateListenerZaPregledProizvoda;

   public ImaNaStanju[] association9;
   public Stanje tekuceStanje;
   public java.util.Collection<Korisnik> korisnik;
   public java.util.Collection<Korpa> korpa;
   public java.util.Collection<Porudzbina> porudzbina;
   public java.util.Collection<Cenovnik> cenovnik;
   public java.util.Collection<Kategorija> kategorija;

   private boolean promena = false;

   public void addListener(UpdateListenerZaPregledSajta u){updateListenerZaPregledSajta=u;}
   public void addListenerr(UpdateListenerZaPregledProizvoda u){updateListenerZaPregledProizvoda=u;}
   public void addLP(UpdateListenerZaPregledSajtaPP p){updateP =p;}

   public boolean isPromena() {
      return promena;
   }
   public void setPromena(boolean promena) {
      this.promena = promena;
   }
   public WebShop(){
      tekuceStanje = new PregledSajta(this);
   }

   public void promeniStanje(Stanje novoStanje) {
      tekuceStanje.exit();
      novoStanje.entry();
      tekuceStanje = novoStanje;

   }
   public void ubacivanjeUKorpu() {
      // TODO: implement
   }
   public void odabraniFilter_f_() {
      // TODO: moze implement
   }
   
   public void klikNaProizvod() {
      try {
         tekuceStanje.klikNaProizvod();
      } catch (IOException e) {
         e.printStackTrace();
      }


   }
   public void vratiNaSajt(){
      UpdateEventZaPregledSajtaPP e = new UpdateEventZaPregledSajtaPP(this, promena);
      try {
         updateP.updatePerformed(e);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }
   public void osveziProizvod() throws IOException {
      UpdateEventZaPregledProizvoda e = new UpdateEventZaPregledProizvoda(this, promena);
      updateListenerZaPregledProizvoda.updatePerformed(e);
   }

   public void nastavakKupovine() {
      tekuceStanje.nastavakKupovine();
   }
   public void klikniNaKorpu() {
      tekuceStanje.klikniNaKorpu();
   }
   
   public void potrvrdaKupovine() {
      // TODO: ne implement
   }
   
   public void brisanjeProizvoda() {
      // TODO: da implement
   }
   

   public void neodobrenaKupovina() {
      // TODO: ne implement
   }
   

   public void izvrsenoPlacanje() {
      // TODO: ne implement
   }

   public void odobrenaKupovina() {
      // TODO: ne implement
   }
   
   public void prikaziKorpu() { //osvezi
      UpdateEventZaPregledSajta e = new UpdateEventZaPregledSajta(this, promena);
      //Slanje dogadjaja da se desila promena svima koji su se registrovali za pracenje promena:
      updateListenerZaPregledSajta.updatePerformed(e);
   }
   
   public void dodajUKorpu() {
      // TODO: moze implement
   }
   
   public void obrisi() {
      // TODO: ne implement
   }
   
   public void proveriStanjeNaRacunu() {
      // TODO: ne implement
   }
   
   public void posaljiRobu() {
      // TODO: ne implement
   }
   
   public void isprazniKorpu() {
      // TODO: ne implement
   }
   

   public java.util.Collection<Korisnik> getKorisnik() {
      if (korisnik == null)
         korisnik = new java.util.HashSet<Korisnik>();
      return korisnik;
   }
   

   public java.util.Iterator getIteratorKorisnik() {
      if (korisnik == null)
         korisnik = new java.util.HashSet<Korisnik>();
      return korisnik.iterator();
   }

   public void setKorisnik(java.util.Collection<Korisnik> newKorisnik) {
      removeAllKorisnik();
      for (java.util.Iterator iter = newKorisnik.iterator(); iter.hasNext();)
         addKorisnik((Korisnik)iter.next());
   }

   public void addKorisnik(Korisnik newKorisnik) {
      if (newKorisnik == null)
         return;
      if (this.korisnik == null)
         this.korisnik = new java.util.HashSet<Korisnik>();
      if (!this.korisnik.contains(newKorisnik))
         this.korisnik.add(newKorisnik);
   }

   public void removeKorisnik(Korisnik oldKorisnik) {
      if (oldKorisnik == null)
         return;
      if (this.korisnik != null)
         if (this.korisnik.contains(oldKorisnik))
            this.korisnik.remove(oldKorisnik);
   }

   public void removeAllKorisnik() {
      if (korisnik != null)
         korisnik.clear();
   }

   public java.util.Collection<Korpa> getKorpa() {
      if (korpa == null)
         korpa = new java.util.HashSet<Korpa>();
      return korpa;
   }
   

   public java.util.Iterator getIteratorKorpa() {
      if (korpa == null)
         korpa = new java.util.HashSet<Korpa>();
      return korpa.iterator();
   }

   public void setKorpa(java.util.Collection<Korpa> newKorpa) {
      removeAllKorpa();
      for (java.util.Iterator iter = newKorpa.iterator(); iter.hasNext();)
         addKorpa((Korpa)iter.next());
   }
   

   public void addKorpa(Korpa newKorpa) {
      if (newKorpa == null)
         return;
      if (this.korpa == null)
         this.korpa = new java.util.HashSet<Korpa>();
      if (!this.korpa.contains(newKorpa))
         this.korpa.add(newKorpa);
   }

   public void removeKorpa(Korpa oldKorpa) {
      if (oldKorpa == null)
         return;
      if (this.korpa != null)
         if (this.korpa.contains(oldKorpa))
            this.korpa.remove(oldKorpa);
   }
   

   public void removeAllKorpa() {
      if (korpa != null)
         korpa.clear();
   }

   public java.util.Collection<Porudzbina> getPorudzbina() {
      if (porudzbina == null)
         porudzbina = new java.util.HashSet<Porudzbina>();
      return porudzbina;
   }
   

   public java.util.Iterator getIteratorPorudzbina() {
      if (porudzbina == null)
         porudzbina = new java.util.HashSet<Porudzbina>();
      return porudzbina.iterator();
   }

   public void setPorudzbina(java.util.Collection<Porudzbina> newPorudzbina) {
      removeAllPorudzbina();
      for (java.util.Iterator iter = newPorudzbina.iterator(); iter.hasNext();)
         addPorudzbina((Porudzbina)iter.next());
   }

   public void addPorudzbina(Porudzbina newPorudzbina) {
      if (newPorudzbina == null)
         return;
      if (this.porudzbina == null)
         this.porudzbina = new java.util.HashSet<Porudzbina>();
      if (!this.porudzbina.contains(newPorudzbina))
         this.porudzbina.add(newPorudzbina);
   }
   

   public void removePorudzbina(Porudzbina oldPorudzbina) {
      if (oldPorudzbina == null)
         return;
      if (this.porudzbina != null)
         if (this.porudzbina.contains(oldPorudzbina))
            this.porudzbina.remove(oldPorudzbina);
   }
   

   public void removeAllPorudzbina() {
      if (porudzbina != null)
         porudzbina.clear();
   }

   public java.util.Collection<Cenovnik> getCenovnik() {
      if (cenovnik == null)
         cenovnik = new java.util.HashSet<Cenovnik>();
      return cenovnik;
   }
   

   public java.util.Iterator getIteratorCenovnik() {
      if (cenovnik == null)
         cenovnik = new java.util.HashSet<Cenovnik>();
      return cenovnik.iterator();
   }

   public void setCenovnik(java.util.Collection<Cenovnik> newCenovnik) {
      removeAllCenovnik();
      for (java.util.Iterator iter = newCenovnik.iterator(); iter.hasNext();)
         addCenovnik((Cenovnik)iter.next());
   }
   

   public void addCenovnik(Cenovnik newCenovnik) {
      if (newCenovnik == null)
         return;
      if (this.cenovnik == null)
         this.cenovnik = new java.util.HashSet<Cenovnik>();
      if (!this.cenovnik.contains(newCenovnik))
         this.cenovnik.add(newCenovnik);
   }

   public void removeCenovnik(Cenovnik oldCenovnik) {
      if (oldCenovnik == null)
         return;
      if (this.cenovnik != null)
         if (this.cenovnik.contains(oldCenovnik))
            this.cenovnik.remove(oldCenovnik);
   }
   

   public void removeAllCenovnik() {
      if (cenovnik != null)
         cenovnik.clear();
   }

   public java.util.Collection<Kategorija> getKategorija() {
      if (kategorija == null)
         kategorija = new java.util.HashSet<Kategorija>();
      return kategorija;
   }

   public java.util.Iterator getIteratorKategorija() {
      if (kategorija == null)
         kategorija = new java.util.HashSet<Kategorija>();
      return kategorija.iterator();
   }
   

   public void setKategorija(java.util.Collection<Kategorija> newKategorija) {
      removeAllKategorija();
      for (java.util.Iterator iter = newKategorija.iterator(); iter.hasNext();)
         addKategorija((Kategorija)iter.next());
   }
   

   public void addKategorija(Kategorija newKategorija) {
      if (newKategorija == null)
         return;
      if (this.kategorija == null)
         this.kategorija = new java.util.HashSet<Kategorija>();
      if (!this.kategorija.contains(newKategorija))
         this.kategorija.add(newKategorija);
   }
   

   public void removeKategorija(Kategorija oldKategorija) {
      if (oldKategorija == null)
         return;
      if (this.kategorija != null)
         if (this.kategorija.contains(oldKategorija))
            this.kategorija.remove(oldKategorija);
   }
   

   public void removeAllKategorija() {
      if (kategorija != null)
         kategorija.clear();
   }

}