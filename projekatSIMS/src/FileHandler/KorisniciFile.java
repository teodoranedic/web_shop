package FileHandler;

import Controller.Main;
import Model.Korisnik;
import Model.Registrovani;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    public static boolean daLiPostoji(String kime, String loz){
        if(Main.korisnici.get(kime) == null){
            return false;
        }else{
            Registrovani r = Main.korisnici.get(kime);
            return r.getLozinka().equals(loz);
        }
    }
}
