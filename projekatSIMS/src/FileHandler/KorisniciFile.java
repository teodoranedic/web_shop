package FileHandler;

import Controller.Main;
import Model.Korisnik;
import Model.Proizvod;
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
            if (tokens.length == 9)
            {
                String[] tokProizvodi = tokens[8].split(";");
                for (int i = 0; i < tokProizvodi.length; i++)
                {
                    String[] proizvodPodaci = tokProizvodi[i].split("#");

                    if (Main.proizvodiZenski.get(proizvodPodaci[0]) != null)
                    {
                        k.dodajProizvod(Main.proizvodiZenski.get(proizvodPodaci[0]), Integer.parseInt(proizvodPodaci[1]));
                    }
                    else
                    {
                        k.dodajProizvod(Main.proizvodiMuski.get(proizvodPodaci[0]), Integer.parseInt(proizvodPodaci[1]));
                    }
                }
            }

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
                    + ((Korisnik) r).getPodaciZaSlanje().getBrKartice() + "|";
            for (Proizvod p : r.getKupljeniProizvodi().keySet())
            {
                upis = upis + p.getSlika() + "#" + r.getKupljeniProizvodi().get(p) + ";";
            }
            if (!r.getKupljeniProizvodi().isEmpty())
                upis = upis.substring(0, upis.length()-1);

            upis += "\n";
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
                + ((Korisnik) r).getPodaciZaSlanje().getBrKartice() + "|";

        for (Proizvod p : r.getKupljeniProizvodi().keySet())
        {
            upis += p.getSlika() + "#" + r.getKupljeniProizvodi().get(p) + ";";
        }
        if (!r.getKupljeniProizvodi().isEmpty())
            upis = upis.substring(0, upis.length()-1);
        upis += "\n";

        bw.append(upis);
        bw.close();

    }

    public static void izmeniKorisnika(String ime, String prezime, String adresa, String telefon, String kartica, String korisnickoIme, String lozinka, String email) throws IOException {
        Main.korisnici.remove(Main.trenutniKorisnik.getKorisnickoIme());
        Registrovani reg = new Registrovani(ime, prezime, adresa, telefon, kartica, korisnickoIme, lozinka, email);
        for (Proizvod p : Main.trenutniKorisnik.getKupljeniProizvodi().keySet())
        {
            reg.dodajProizvod(p, Main.trenutniKorisnik.getKupljeniProizvodi().get(p));
        }
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
