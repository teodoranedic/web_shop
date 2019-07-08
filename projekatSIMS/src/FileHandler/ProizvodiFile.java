package FileHandler;

import Controller.Main;
import Model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class ProizvodiFile {


    public static void ucitaj(String fileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String odluka = "";
        if (fileName.contains("proizvodiZenski")) {
            odluka = "f";
        }
        else {
            odluka = "m";
        }
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
                    for (Velicina v: Main.velicine) {
                        if (Integer.parseInt(tokSizes[i]) == v.getSifra()) {
                            velicine.add(v);
                            break;
                        }
                    }
                    /*if (Main.velicine.contains(Integer.parseInt(tokSizes[i]))) { //ne znam zbog cega ovaj kod ne radi

                        int index = Main.velicine.indexOf(Integer.parseInt(tokSizes[i]));
                        velicine.add(Main.velicine.get(index));
                    }*/
                }
            }

            else {
                if (Main.velicine.contains(tokens[5])){
                    int index = Main.velicine.indexOf(tokens[5]);
                    velicine.add(Main.velicine.get(index));
                }
            }
            p.setVelicina(velicine);

            for (Kategorija k: Main.kategorije) {
                if (tokens[6].equals(k.getNaziv())){
                    p.setKategorija(k);
                    break;
                }
            }

            p.setSlika(tokens[7]);
            if (odluka.equals("m")) {
                Main.proizvodiMuski.put(p.getSlika(), p);
            }
            else {
                Main.proizvodiZenski.put(p.getSlika(), p);
            }
        }
        br.close();
    }
}
