package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    @FXML
    private TextField prezimeTekst;

    @FXML
    private TextField imeTekst;

    @FXML
    private TextField adresaTekst;

    @FXML
    private TextField brKarticeTekst;

    @FXML
    private TextField brTelTekst;

    @FXML
    private TextField emailTekst;

    @FXML
    public void poruciButtonPushed(ActionEvent event) throws IOException, IOException {
        for (java.util.Map.Entry<Model.Proizvod,Integer> s : Main.trenutniKorisnik.getKorpa().getProizvodi().entrySet())
        {
            Main.trenutniKorisnik.dodajProizvod(s.getKey(),s.getValue());
        }
        //upis u fajl ovde
        Main.trenutniKorisnik.getKorpa().setProizvodi(null);
        //obrisi korpu
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Obavestenje");
        alert.setHeaderText("Porudzbina se obradjuje.");
        alert.setContentText("Detaljne informacije dobicete putem email-a.Hvala na poverenju.");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK)
                //ovde pitam gde treba da se vrati
                alert.close();
        });
    }
    @FXML
    public void backButtonPushed(ActionEvent event) throws IOException, IOException {

            Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/Cart.fxml"));
            Scene registrovanjeScene = new Scene(registrovanjeParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(registrovanjeScene);
            window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(Main.trenutniKorisnik.getKorpa().getProizvodi().size()!=0)
        {
             prezimeTekst = new TextField(Main.trenutniKorisnik.getPodaciZaSlanje().getPrezime());

             imeTekst= new TextField(Main.trenutniKorisnik.getPodaciZaSlanje().getIme());

             adresaTekst= new TextField(Main.trenutniKorisnik.getPodaciZaSlanje().getAdresa());

             brKarticeTekst= new TextField(Main.trenutniKorisnik.getPodaciZaSlanje().getBrKartice());

             brTelTekst= new TextField(Main.trenutniKorisnik.getPodaciZaSlanje().getBrojTelefona());

             emailTekst= new TextField(Main.trenutniKorisnik.getMejl());
        }
    }
}