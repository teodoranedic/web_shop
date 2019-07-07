package FileHandler;

import Controller.Main;
import Model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProizvodiFile {
    static String fileName = "./data/proizvodi.txt";

    public static void ucitaj() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split("\\|");
            String[] tokColors;
            String[] tokSizes;

            ArrayList<Velicina> velicine = new ArrayList<Velicina>();
            ArrayList<Boja> boje = new ArrayList<Boja>();

            Proizvod p = new Proizvod();
            p.setNaziv(tokens[0]);
            p.setSifra(Integer.parseInt(tokens[1]));

            p.setStavkaCenovnika(Double.parseDouble(tokens[3]));
            if (tokens[4].contains(";")) {
                tokColors = tokens[4].split(";");
                for ( int i= 0; i < tokColors.length; i++) {
                    if (Main.boje.get(tokColors[i]) != null) {
                        boje.add(Main.boje.get(tokColors[i]));
                    }
                }
            }
            else {
                if (Main.boje.get(tokens[4]) != null) {
                    boje.add(Main.boje.get(tokens[4]));
                }
            }
            p.setBoja(boje);

            if (tokens[5].contains(";")) {
                tokSizes = tokens[5].split(";");
                for ( int i= 0; i < tokSizes.length; i++) {
                    if (Main.velicine.contains(Integer.parseInt(tokSizes[i]))) {
                        int index = Main.velicine.indexOf(Integer.parseInt(tokSizes[i]));
                        velicine.add(Main.velicine.get(index));
                    }
                }
            }
            else {
                if (Main.velicine.contains(tokens[5])){
                    int index = Main.velicine.indexOf(tokens[5]);
                    velicine.add(Main.velicine.get(index));
                }
            }
            p.setVelicina(velicine);


            if (Main.kategorije.contains(tokens[6])) {
                    int index = Main.kategorije.indexOf(tokens[6]);
                    p.setKategorija(Main.kategorije.get(index));
            }

            p.setSlika(tokens[7]);

            Main.proizvodi.put(p.getSlika(), p);
        }
        br.close();
    }
}
