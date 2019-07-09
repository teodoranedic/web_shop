package Controller;

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
import java.util.ResourceBundle;

public class CartController implements Initializable{


    @FXML
    private Label tekst;    //to da ce pisati korpa je prazna ili vasa korpa
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
    @FXML
    private Label ukupno;   //ukupno nisam izracunala


    public void orderButtonPushed(ActionEvent event) throws IOException, IOException {

        if (Main.trenutniKorisnik.getKorpa().getProizvodi().size() != 0 || Main.anonimnaKorpa.getProizvodi().size() != 0)
        {
            Parent porudzbinaParent = FXMLLoader.load(getClass().getResource("/View/Order.fxml"));
            Scene porudzbinaScene = new Scene(porudzbinaParent);
            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(porudzbinaScene);
            window.show();
        }
        //ukoliko nema proizvoda dugme nece reagovati
    }

    //da proverim jel ide na nazad button i jel  prazni korpu kod ide na nazad
    @FXML
    public void backButtonPushed(ActionEvent event) throws IOException, IOException {

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

            Image image = new Image(s.getKey().getSlika());
            ImageView view = new ImageView(image);
            view.setFitHeight(160);
            view.setFitWidth(90);
            Label cen = new Label(s.getKey().getStavkaCenovnika()+"\n");
            TextField t = new TextField(s.getValue().toString());

            root.getChildren().add(view);
            root1.getChildren().add(cen);
            root2.getChildren().add(t);

            root.setSpacing(10);
            root.setPadding(new Insets(10));

            root1.setSpacing(160);
            root1.setPadding(new Insets(10));
            root2.setSpacing(160);
            root2.setPadding(new Insets(10));
        }
        scrollPane.setContent(root);
        scrollPane.setContent(root1);
        scrollPane.setContent(root2);
        scrollPane.setContent(root3);

        scrollPane.setPannable(true);
    };


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Main.trenutniKorisnik.getKorpa().getProizvodi().size()!=0)
        {
            tekst.setText("Vasa korpa: ");
            ispisiProizvodeKorpe(Main.trenutniKorisnik.getKupljeniProizvodi());

        }
        else if(Main.anonimnaKorpa.getProizvodi().size()!=0)
        {
            tekst.setText("Vasa korpa: ");
            ispisiProizvodeKorpe(Main.anonimnaKorpa.getProizvodi());
        }
        else{
            tekst.setText("Vasa korpa je prazna");
        }
    }
}


