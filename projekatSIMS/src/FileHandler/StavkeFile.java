package FileHandler;

import Controller.Main;
import Model.Boja;
import Model.Korisnik;
import Model.Registrovani;
import Model.StavkaCenovnika;

import java.io.*;

public class StavkeFile {
    static String fileName = "./data/stavkeCenovnika.txt";

    public static void ucitaj() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            Integer i = Integer.parseInt(line);
            StavkaCenovnika c = new StavkaCenovnika(i);
            Main.stavkeCenovnika.add(c);
        }
        br.close();
    }
}
