package Controller;

import EventHandler.UpdateEventZaPregledSajtaPP;
import EventHandler.UpdateListenerZaPregledSajtaPP;
import Model.Boja;
import Model.Kategorija;
import Model.Proizvod;
import Model.Velicina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Controller.Main.*;

public class ProductController implements Initializable, UpdateListenerZaPregledSajtaPP {
    public ActionEvent trenutniDogadjaj;
    @FXML
    private Label textOpis;

    @FXML
    private ComboBox<String> comboVelicina = new ComboBox<>();

    @FXML
    private ComboBox<String> comboBoja = new ComboBox<>();

    @FXML
    ObservableList<String> bojeList = FXCollections.observableArrayList();
    ObservableList<String> velicineList = FXCollections.observableArrayList();

    @FXML
    private AnchorPane imagePane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    public TextField kolicinaText;

    @FXML
    private Label cenaLabela;

    @FXML
    private Label nazivProizvodaLabela;

    // proizvod koji ce se dodati u korpu, sa setovanom odabranom velicinom, bojom i kolicinom
    private Proizvod p = new Proizvod();
    private int odabranaKolicina = 1;

    @FXML
    void dodajUKorpuClicked(ActionEvent event) {

        // boja i velicina se setuju u metodama ispod, moraju biti setovane
        if(p.getBoja().size() != 0 && p.getVelicina().size() != 0) {
            p.setKategorija(Main.trenutniProizvod.getKategorija());
            p.setNaziv(Main.trenutniProizvod.getNaziv());
            p.setOpis(Main.trenutniProizvod.getOpis());
            p.setSifra(Main.trenutniProizvod.getSifra());
            p.setStavkaCenovnika(Main.trenutniProizvod.getStavkaCenovnika());
            p.setSlika(Main.trenutniProizvod.getSlika());
            odabranaKolicina = Integer.parseInt(kolicinaText.getText());

            if (trenutniKorisnik != null)
                Main.trenutniKorisnik.getKorpa().dodajProizvod(p, odabranaKolicina);
            else
                anonimnaKorpa.dodajProizvod(p, odabranaKolicina);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText("Proizvod uspesno dodat u korpu");
            alert.setContentText("Nastavite kupovinu ili kliknite na korpu za placanje.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) alert.close();
            });
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText("Proizvod nije dodat u korpu");
            alert.setContentText("Morate odabrati velicinu i boju!");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) alert.close();
            });

        }
    }

    @FXML
    void setVelicina(ActionEvent event) {
        ArrayList<Velicina> vel = new ArrayList<Velicina>();
        for(Velicina v: Main.trenutniProizvod.getVelicina()){
            if (v.getSifra() == Integer.parseInt(comboVelicina.getValue())){
                vel.add(v);
            }
        }
        p.setVelicina(vel);
    }

    @FXML
    void setBoja(ActionEvent event) {
        ArrayList<Boja> boj = new ArrayList<Boja>();
        for(Boja b: Main.trenutniProizvod.getBoja()){
            if (b.getNaziv() == comboBoja.getValue()){
                boj.add(b);
            }
        }
        p.setBoja(boj);
    }

    @FXML
    void setKolicina(ActionEvent event) {
        // obraditi gresku ako unese nesto sto nije broj
        odabranaKolicina = Integer.parseInt(kolicinaText.getText());
    }

    @FXML
    void nazadButtonPushed(ActionEvent event) throws IOException {
        trenutniDogadjaj=event;
        webShop.nastavakKupovine();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webShop.addLP(this);
        for (Boja b : Main.trenutniProizvod.getBoja()) {
            bojeList.add(b.getNaziv());

        }
        for (Velicina v : Main.trenutniProizvod.getVelicina()) {
            velicineList.add("" + v.getSifra());
        }

        comboBoja.setItems(bojeList);
        comboVelicina.setItems(velicineList);

        nazivProizvodaLabela.setText(Main.trenutniProizvod.getNaziv());
        cenaLabela.setText(""+Main.trenutniProizvod.getStavkaCenovnika());
        textOpis.setText(Main.trenutniProizvod.getOpis());
        Image image = new Image(Main.trenutniProizvod.getSlika());
        ImageView view = new ImageView(image);
        imagePane.getChildren().add(view);

        scrollPane.setContent(imagePane);
        scrollPane.setPannable(true);
    }

    @Override
    public void updatePerformed(UpdateEventZaPregledSajtaPP e) throws IOException {
        if(e.isPromena()){
            Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLoggedUser.fxml"));
            Scene registrovanjeScene = new Scene(registrovanjeParent);
            Stage window = (Stage)((Node)trenutniDogadjaj.getSource()).getScene().getWindow();
            window.setScene(registrovanjeScene);
            window.show();
        }
        else{
            Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));
            Scene registrovanjeScene = new Scene(registrovanjeParent);
            Stage window = (Stage)((Node)trenutniDogadjaj.getSource()).getScene().getWindow();
            window.setScene(registrovanjeScene);
            window.show();
        }

    }
}