package Controller;

import FileHandler.KorisniciFile;
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
    private Label porukaLabela;

    @FXML
    public void poruciButtonPushed(ActionEvent event) throws IOException, IOException {
        if (Main.trenutniKorisnik != null)
        {
            for (java.util.Map.Entry<Model.Proizvod,Integer> s : Main.trenutniKorisnik.getKorpa().getProizvodi().entrySet())
            {
                Main.trenutniKorisnik.dodajProizvod(s.getKey(),s.getValue());
            }
            //upis u fajl ovde
            KorisniciFile.upis();
            Main.trenutniKorisnik.getKorpa().getProizvodi().clear();
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
        else {
            if (imeTekst.getText().equals("") || prezimeTekst.getText().equals("") || adresaTekst.getText().equals("")
                    || brTelTekst.getText().equals("") ||
                    emailTekst.getText().equals("") || brKarticeTekst.getText().equals("")) {
                porukaLabela.setText("Sva polja su obavezna!");
            }
            else
            {
                Main.anonimnaKorpa.getProizvodi().clear();
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
        }

    }
    @FXML
    public void backButtonPushed(ActionEvent event) throws IOException, IOException {

            if (Main.trenutniKorisnik == null)
            {
                Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));
                Scene registrovanjeScene = new Scene(registrovanjeParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(registrovanjeScene);
                window.show();
            }
            else
            {
                Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLoggedUser.fxml"));
                Scene registrovanjeScene = new Scene(registrovanjeParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(registrovanjeScene);
                window.show();
            }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (Main.trenutniKorisnik != null)
        {
            if(Main.trenutniKorisnik.getKorpa().getProizvodi().size()!=0)
            {
                prezimeTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getPrezime());

                imeTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getIme());

                adresaTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getAdresa());

                brKarticeTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getBrKartice());

                brTelTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getBrojTelefona());

                emailTekst.setText(Main.trenutniKorisnik.getMejl());
            }
        }

    }
}