package FileHandler;

import Controller.Main;
import Model.Korisnik;
import Model.Registrovani;

import java.io.*;

public class KorisniciFile {
    static String fileName = "./data/korisnici.txt";

    public static void ucitaj() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split("\\|");
            Registrovani k = new Registrovani(tokens);
            Main.korisnici.put(k.getKorisnickoIme(), k);
        }
        br.close();
    }

    public static void upis() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("./data/korisnici.txt"));

        for (Registrovani r : Main.korisnici.values()) {
            String upis = r.getKorisnickoIme() + "|" + r.getLozinka() + "|"
                    + ((Korisnik) r).getPodaciZaSlanje().getIme() + "|"
                    + ((Korisnik) r).getPodaciZaSlanje().getPrezime() + "|"
                    + ((Korisnik) r).getPodaciZaSlanje().getAdresa() + "|" + r.getMejl() + "|"
                    + ((Korisnik) r).getPodaciZaSlanje().getBrojTelefona() + "|"
                    + ((Korisnik) r).getPodaciZaSlanje().getBrKartice() + "\n";
            pw.write(upis);
        }
        pw.close();
    }

    public static void dodajUFajl(Registrovani r) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("./data/korisnici.txt", true));
        String upis = r.getKorisnickoIme() + "|" + r.getLozinka() + "|"
                + ((Korisnik) r).getPodaciZaSlanje().getIme() + "|"
                + ((Korisnik) r).getPodaciZaSlanje().getPrezime() + "|"
                + ((Korisnik) r).getPodaciZaSlanje().getAdresa() + "|" + r.getMejl() + "|"
                + ((Korisnik) r).getPodaciZaSlanje().getBrojTelefona() + "|"
                + ((Korisnik) r).getPodaciZaSlanje().getBrKartice() + "\n";
        bw.append(upis);
        bw.close();

    }

    public static void izmeniKorisnika(String ime, String prezime, String adresa, String telefon, String kartica, String korisnickoIme, String lozinka, String email) throws IOException {
        Main.korisnici.remove(Main.trenutniKorisnik.getKorisnickoIme());
        Registrovani reg = new Registrovani(ime, prezime, adresa, telefon, kartica, korisnickoIme, lozinka, email);
        Main.korisnici.put(reg.getKorisnickoIme(), reg);
        Main.trenutniKorisnik = reg;
        upis();
    }


    public static boolean daLiPostoji(String kime, String loz){
        if(Main.korisnici.get(kime) == null){
            return false;
        }else{
            Registrovani r = Main.korisnici.get(kime);
            return r.getLozinka().equals(loz);
        }
    }
}
