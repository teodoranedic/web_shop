package Controller;

import FileHandler.KorisniciFile;
import Model.Proizvod;
import Model.Registrovani;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Main extends Application {

    public static HashMap<String, Registrovani> korisnici = new HashMap<String, Registrovani>();
    public static HashMap<String, Proizvod> proizvodi = new HashMap<String, Proizvod>();

    public static Proizvod trenutniProizvod  = new Proizvod();
    public static Registrovani trenutniKorisnik = new Registrovani();

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            KorisniciFile.ucitaj();

        } catch (IOException e) {
            e.printStackTrace();
        }
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