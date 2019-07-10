package Controller;

import EventHandler.UpdateEvent;
import EventHandler.UpdateListener;
import Model.Proizvod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class CartController implements Initializable, UpdateListener {


    private HashMap<Proizvod, TextField> poljaKolicine = new HashMap<Proizvod, TextField>();
    private double ukupno = 0;

    @FXML
    private Label ukupnoLabela;
    @FXML
    private Label tekst;    //to da ce pisati korpa je prazna ili vasa korpa
    @FXML
    private Label korpaPraznaLabela;

    @FXML
    private Label cena;
    @FXML
    private Label kolicina;
    @FXML
    private VBox root;
    @FXML
    private VBox root1;
    @FXML
    private VBox root2;
    @FXML
    private VBox root3;
    @FXML

    private ScrollPane scrollPane;

    private ActionEvent trenutniDogadjaj;


    // IMAMO GLOBALNU ANONIMNU KORPU I REGISTROVANOG PA PREKO NJEGA NJEGOVU KORPU


    public void promeniKolicinu()
    {
        if (Main.trenutniKorisnik != null)
        {
            for (Proizvod p : poljaKolicine.keySet())
            {
                Main.trenutniKorisnik.getKorpa().getProizvodi().put(p, Integer.parseInt(poljaKolicine.get(p).getText()));
            }
        }
        else
        {
            for (Proizvod p : poljaKolicine.keySet())
            {
                Main.anonimnaKorpa.getProizvodi().put(p, Integer.parseInt(poljaKolicine.get(p).getText()));
            }
        }

    }
    public void orderButtonPushed(ActionEvent event) throws IOException, IOException {
        trenutniDogadjaj = event;

        promeniKolicinu();

        if (Main.trenutniKorisnik != null)
        {
            Main.trenutniKorisnik.getKorpa().getPorudzbina().OdabranoPlacanje();
        }else{
            Main.anonimnaKorpa.getPorudzbina().OdabranoPlacanje();
        }
            /*
            if (Main.trenutniKorisnik.getKorpa().getProizvodi().size() != 0)
            {
                Parent porudzbinaParent = FXMLLoader.load(getClass().getResource("/View/Order.fxml"));
                Scene porudzbinaScene = new Scene(porudzbinaParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(porudzbinaScene);
                window.show();
            }
        }
        else
        {
            if (Main.anonimnaKorpa.getProizvodi().size() != 0)
            {
                Parent porudzbinaParent = FXMLLoader.load(getClass().getResource("/View/Order.fxml"));
                Scene porudzbinaScene = new Scene(porudzbinaParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(porudzbinaScene);
                window.show();
            }
        }
        */
        //ukoliko nema proizvoda dugme nece reagovati
    }

    @FXML
    public void izbaciButtonPushed (ActionEvent event)
    {
        if (Main.trenutniKorisnik != null)
            Main.trenutniKorisnik.getKorpa().getProizvodi().remove(Main.trenutniProizvod);
        else
            Main.anonimnaKorpa.getProizvodi().remove(Main.trenutniProizvod);

        Parent proizvodParent = null;
        try {
            proizvodParent = FXMLLoader.load(getClass().getResource("/View/Cart.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene proizvodScene = new Scene(proizvodParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(proizvodScene);
        window.show();
    }
    //da proverim jel ide na nazad button i jel  prazni korpu kod ide na nazad
    @FXML
    public void backButtonPushed(ActionEvent event) throws IOException, IOException {

        promeniKolicinu();
        if(Main.trenutniKorisnik == null || Main.trenutniKorisnik.getKorisnickoIme() == null) {
            Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));

            Scene registrovanjeScene = new Scene(registrovanjeParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(registrovanjeScene);
            window.show();
        }else{
            Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLoggedUser.fxml"));

            Scene registrovanjeScene = new Scene(registrovanjeParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(registrovanjeScene);
            window.show();
        }

    }
    public void ispisiProizvodeKorpe(java.util.HashMap<Model.Proizvod,Integer> proizvodi){

        for (java.util.Map.Entry<Model.Proizvod,Integer> s : proizvodi.entrySet())
        {
            ukupno += s.getKey().getStavkaCenovnika() * s.getValue();
            Image image = new Image(s.getKey().getSlika());
            ImageView view = new ImageView(image);
            view.setFitHeight(160);
            view.setFitWidth(90);
            Label cen = new Label(s.getKey().getStavkaCenovnika()+"\n");
            TextField t = new TextField(s.getValue().toString());
            poljaKolicine.put(s.getKey(), t);

            root.getChildren().add(view);
            root1.getChildren().add(cen);
            root2.getChildren().add(t);

            root.setSpacing(10);
            root.setPadding(new Insets(10));

            root1.setSpacing(160);
            root1.setPadding(new Insets(10));
            root2.setSpacing(160);
            root2.setPadding(new Insets(10));

            view.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                // na klik proizvoda setuje se trenutni proizvod i prelazi se na scenu za prikaz proizvoda
                Main.trenutniProizvod = s.getKey();
                event.consume();
            });
        }
        scrollPane.setContent(root);
        scrollPane.setContent(root1);
        scrollPane.setContent(root2);
        scrollPane.setContent(root3);

        scrollPane.setPannable(true);

    };


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (Main.trenutniKorisnik != null)
        {
            Main.trenutniKorisnik.getKorpa().getPorudzbina().addListener(this);
            if(Main.trenutniKorisnik.getKorpa().getProizvodi().size()!=0)
            {
                tekst.setText("Vasa korpa: ");
                ispisiProizvodeKorpe(Main.trenutniKorisnik.getKorpa().getProizvodi());
                ukupnoLabela.setText(""+ukupno);
            }
            else
                tekst.setText("Vasa korpa je prazna");
        }
        else
        {
            Main.anonimnaKorpa.getPorudzbina().addListener(this);
            if(Main.anonimnaKorpa.getProizvodi().size()!=0)
            {
                tekst.setText("Vasa korpa: ");
                ispisiProizvodeKorpe(Main.anonimnaKorpa.getProizvodi());
                ukupnoLabela.setText(""+ukupno);
            }
            else
                tekst.setText("Vasa korpa je prazna");
        }

    }

    @Override
    public void updatePerformed(UpdateEvent e) {
        // TODO: prelazak na sledece stanje
        if(e.isPromena()) {

            Parent porudzbinaParent = null;
            try {
                porudzbinaParent = FXMLLoader.load(getClass().getResource("/View/Order.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Scene porudzbinaScene = new Scene(porudzbinaParent);
            //This line gets the Stage information
            Stage window = (Stage) ((Node) trenutniDogadjaj.getSource()).getScene().getWindow();
            window.setScene(porudzbinaScene);
            window.show();

        }else{

            Parent porudzbinaParent = null;
            try {
                porudzbinaParent = FXMLLoader.load(getClass().getResource("/View/Cart.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Scene porudzbinaScene = new Scene(porudzbinaParent);
            Stage window = (Stage) ((Node) trenutniDogadjaj.getSource()).getScene().getWindow();
            window.setScene(porudzbinaScene);
            window.show();
        }
    }
}


