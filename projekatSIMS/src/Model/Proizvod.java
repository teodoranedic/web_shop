package Model;

import java.util.*;

public class Proizvod {
   private String naziv;
   private int sifra;
   private String opis;
   
   public java.util.Collection<StavkaCenovnika> stavkaCenovnika;
   public java.util.Collection<Boja> boja;
   public java.util.Collection<Velicina> velicina;
   public java.util.Collection<Kategorija> kategorija;
   
   
   public java.util.Collection<StavkaCenovnika> getStavkaCenovnika() {
      if (stavkaCenovnika == null)
         stavkaCenovnika = new java.util.HashSet<StavkaCenovnika>();
      return stavkaCenovnika;
   }
   
   public java.util.Iterator getIteratorStavkaCenovnika() {
      if (stavkaCenovnika == null)
         stavkaCenovnika = new java.util.HashSet<StavkaCenovnika>();
      return stavkaCenovnika.iterator();
   }

   public void setStavkaCenovnika(java.util.Collection<StavkaCenovnika> newStavkaCenovnika) {
      removeAllStavkaCenovnika();
      for (java.util.Iterator iter = newStavkaCenovnika.iterator(); iter.hasNext();)
         addStavkaCenovnika((StavkaCenovnika)iter.next());
   }
   

   public void addStavkaCenovnika(StavkaCenovnika newStavkaCenovnika) {
      if (newStavkaCenovnika == null)
         return;
      if (this.stavkaCenovnika == null)
         this.stavkaCenovnika = new java.util.HashSet<StavkaCenovnika>();
      if (!this.stavkaCenovnika.contains(newStavkaCenovnika))
         this.stavkaCenovnika.add(newStavkaCenovnika);
   }
   

   public void removeStavkaCenovnika(StavkaCenovnika oldStavkaCenovnika) {
      if (oldStavkaCenovnika == null)
         return;
      if (this.stavkaCenovnika != null)
         if (this.stavkaCenovnika.contains(oldStavkaCenovnika))
            this.stavkaCenovnika.remove(oldStavkaCenovnika);
   }
   

   public void removeAllStavkaCenovnika() {
      if (stavkaCenovnika != null)
         stavkaCenovnika.clear();
   }

   public java.util.Collection<Boja> getBoja() {
      if (boja == null)
         boja = new java.util.HashSet<Boja>();
      return boja;
   }
   

   public java.util.Iterator getIteratorBoja() {
      if (boja == null)
         boja = new java.util.HashSet<Boja>();
      return boja.iterator();
   }
   

   public void setBoja(java.util.Collection<Boja> newBoja) {
      removeAllBoja();
      for (java.util.Iterator iter = newBoja.iterator(); iter.hasNext();)
         addBoja((Boja)iter.next());
   }
   

   public void addBoja(Boja newBoja) {
      if (newBoja == null)
         return;
      if (this.boja == null)
         this.boja = new java.util.HashSet<Boja>();
      if (!this.boja.contains(newBoja))
         this.boja.add(newBoja);
   }
   

   public void removeBoja(Boja oldBoja) {
      if (oldBoja == null)
         return;
      if (this.boja != null)
         if (this.boja.contains(oldBoja))
            this.boja.remove(oldBoja);
   }
   

   public void removeAllBoja() {
      if (boja != null)
         boja.clear();
   }

   public java.util.Collection<Velicina> getVelicina() {
      if (velicina == null)
         velicina = new java.util.HashSet<Velicina>();
      return velicina;
   }
   

   public java.util.Iterator getIteratorVelicina() {
      if (velicina == null)
         velicina = new java.util.HashSet<Velicina>();
      return velicina.iterator();
   }
   

   public void setVelicina(java.util.Collection<Velicina> newVelicina) {
      removeAllVelicina();
      for (java.util.Iterator iter = newVelicina.iterator(); iter.hasNext();)
         addVelicina((Velicina)iter.next());
   }
   

   public void addVelicina(Velicina newVelicina) {
      if (newVelicina == null)
         return;
      if (this.velicina == null)
         this.velicina = new java.util.HashSet<Velicina>();
      if (!this.velicina.contains(newVelicina))
         this.velicina.add(newVelicina);
   }
   

   public void removeVelicina(Velicina oldVelicina) {
      if (oldVelicina == null)
         return;
      if (this.velicina != null)
         if (this.velicina.contains(oldVelicina))
            this.velicina.remove(oldVelicina);
   }
   

   public void removeAllVelicina() {
      if (velicina != null)
         velicina.clear();
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