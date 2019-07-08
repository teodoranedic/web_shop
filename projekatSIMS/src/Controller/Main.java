package Controller;

import FileHandler.*;
import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main extends Application {

    public static String komboMuskarci = "";
    public static String komboZene = "";
    public static String komboSort = "";
    public static String komboBoja = "";
    public static String komboCena = "";
    public static String trazi = "";

    public static HashMap<String, Registrovani> korisnici = new HashMap<String, Registrovani>();
    public static HashMap<String, Proizvod> proizvodiZenski = new HashMap<String, Proizvod>();
    public static HashMap<String, Proizvod> proizvodiMuski = new HashMap<String, Proizvod>();
    public static HashMap<String, Boja> boje = new HashMap<String, Boja>();
    public static ArrayList<Kategorija> kategorije = new ArrayList<Kategorija>();
    public static ArrayList<Velicina> velicine = new ArrayList<Velicina>();
    public static ArrayList<StavkaCenovnika> stavkeCenovnika = new ArrayList<StavkaCenovnika>();


    public static Proizvod trenutniProizvod  = new Proizvod();
    public static String trenutnoIscrtani = "";
    public static Registrovani trenutniKorisnik = new Registrovani();

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            KorisniciFile.ucitaj();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BojeFile.ucitaj();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            KategorijeFile.ucitaj();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            StavkeFile.ucitaj();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            VelicineFile.ucitaj();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ProizvodiFile.ucitaj("./data/proizvodiMuski.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ProizvodiFile.ucitaj("./data/proizvodiZenski.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*for (String p:proizvodi.keySet()) {
            System.out.println(p);
        }*/

        Parent root = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));
        primaryStage.setTitle("GlobusApp");
        primaryStage.getIcons().add(new Image("/icons/AppIcon.png"));
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();


    }


    public static void main(String[] args) {

        launch(args);


    }
}