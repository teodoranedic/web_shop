package FileHandler;

import Controller.Main;
import Model.*;

import java.io.*;

public class KategorijeFile {
    static String fileName = "./data/kategorije.txt";

    public static void ucitaj() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            Kategorija kat = new Kategorija(line);
            Main.kategorije.add(kat);
        }
        br.close();
    }
}
