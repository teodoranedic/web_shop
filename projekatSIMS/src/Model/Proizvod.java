package Model;

import javafx.scene.image.Image;

import java.util.*;

public class Proizvod {
   private String naziv;
   private int sifra;
   private String opis;
   private double stavkaCenovnika;
   public ArrayList<Boja> boja;
   public ArrayList<Velicina> velicina;
   private Kategorija kategorija;
   private String slika; // putanja do slike


   public Proizvod() {
   }

   public Proizvod(String naziv, int sifra, String opis, double stavkaCenovnika, ArrayList<Boja> boja, ArrayList<Velicina> velicina, Kategorija kategorija, String slika) {
      this.naziv = naziv;
      this.sifra = sifra;
      this.opis = opis;
      this.stavkaCenovnika = stavkaCenovnika;
      this.boja = boja;
      this.velicina = velicina;
      this.kategorija = kategorija;
      this.slika = slika;
   }

   public String getNaziv() {
      return naziv;
   }

   public void setNaziv(String naziv) {
      this.naziv = naziv;
   }

   public int getSifra() {
      return sifra;
   }

   public void setSifra(int sifra) {
      this.sifra = sifra;
   }

   public String getOpis() {
      return opis;
   }

   public void setOpis(String opis) {
      this.opis = opis;
   }

   public double getStavkaCenovnika() {
      return stavkaCenovnika;
   }

   public void setStavkaCenovnika(double stavkaCenovnika) {
      this.stavkaCenovnika = stavkaCenovnika;
   }

   public ArrayList<Boja> getBoja() {
      return boja;
   }

   public void setBoja(ArrayList<Boja> boja) {
      this.boja = boja;
   }

   public ArrayList<Velicina> getVelicina() {
      return velicina;
   }

   public void setVelicina(ArrayList<Velicina> velicina) {
      this.velicina = velicina;
   }

   public Kategorija getKategorija() {
      return kategorija;
   }

   public void setKategorija(Kategorija kategorija) {
      this.kategorija = kategorija;
   }

   public String getSlika() {
      return slika;
   }

   public void setSlika(String slika) {
      this.slika = slika;
   }
}