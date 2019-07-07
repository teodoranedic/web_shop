package FileHandler;

import Controller.Main;
import Model.Boja;
import Model.Korisnik;
import Model.Registrovani;

import java.io.*;

public class BojeFile {
    static String fileName = "./data/boje.txt";

    public static void ucitaj() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split("\\|");
            Boja b = new Boja(tokens);
            Main.boje.put(b.getSifra(), b);
        }
        br.close();
    }
}
