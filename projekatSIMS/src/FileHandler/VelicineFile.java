package FileHandler;

import Controller.Main;
import Model.*;

import java.io.*;

public class VelicineFile{
    static String fileName = "./data/velicine.txt";

    public static void ucitaj() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            Velicina v= new Velicina(Integer.parseInt(line));
            Main.velicine.add(v);
        }
        br.close();
    }
}
