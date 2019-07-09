package Controller;

import FileHandler.KorisniciFile;
import Model.Korisnik;
import Model.Registrovani;
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

public class ChangeProfileController implements Initializable {

    @FXML
    private TextField prezimeText;

    @FXML
    private TextField kimeText;

    @FXML
    private PasswordField lozinkaText;

    @FXML
    private Button izmenaButton;

    @FXML
    private TextField adresaText;

    @FXML
    private Label porukaLabela;

    @FXML
    private TextField imeText;

    @FXML
    private TextField brTelText;

    @FXML
    private TextField email;

    @FXML
    private TextField karticaText;


    @FXML
    void istorijaKupovinePushed(ActionEvent event) throws IOException {
        //*****ANDJA DONE

        Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/History.fxml"));
        Scene registrovanjeScene = new Scene(registrovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registrovanjeScene);
        window.show();
    }
    @FXML
    void nazadButtonPushed(ActionEvent event) throws IOException {
        Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLoggedUser.fxml"));
        Scene registrovanjeScene = new Scene(registrovanjeParent);
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registrovanjeScene);
        window.show();
    }

    @FXML
    void changeButtonPushed(ActionEvent event) throws IOException {
        // TODO: provera podataka (da li postoji korisnicko ime u bazi) - dodati else if izmedju
        if(imeText.getText().equals("") || prezimeText.getText().equals("") || adresaText.getText().equals("")
                || brTelText.getText().equals("") || kimeText.getText().equals("")||
                lozinkaText.getText().equals("") || email.getText().equals("")) {
            porukaLabela.setText("Sva polja su obavezna!");
        }
        else if (!Main.trenutniKorisnik.getKorisnickoIme().equals(kimeText.getText()))
        {
            //menjano korisnicko ime
            if (Main.korisnici.get(kimeText.getText()) == null)
            {
                //moze da promeni korisnicko ime
               KorisniciFile.izmeniKorisnika(imeText.getText(), prezimeText.getText(), adresaText.getText(), brTelText.getText(),
                        karticaText.getText(), kimeText.getText(), lozinkaText.getText(), email.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText("Obavestenje");
                alert.setContentText("Izmene sacuvane!");

                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {

                        // nakon izmene vraca se na prozor za ulogovane korisnike, cak i ako je menjao lozinku

                        Parent izmenaParent = null;
                        try {
                            izmenaParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLoggedUser.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Scene izmenaScene = new Scene(izmenaParent);
                        //This line gets the Stage information
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(izmenaScene);
                        window.show();
                    }
                });
            }
            else
            {
                porukaLabela.setText("Korisnicko ime postoji!");
            }

        }
        else {
            KorisniciFile.izmeniKorisnika(imeText.getText(), prezimeText.getText(), adresaText.getText(), brTelText.getText(),
                    karticaText.getText(), kimeText.getText(), lozinkaText.getText(), email.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText("Obavestenje");
            alert.setContentText("Izmene sacuvane!");

            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {

                    // nakon izmene vraca se na prozor za ulogovane korisnike, cak i ako je menjao lozinku

                    Parent izmenaParent = null;
                    try {
                        izmenaParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLoggedUser.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Scene izmenaScene = new Scene(izmenaParent);
                    //This line gets the Stage information
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(izmenaScene);
                    window.show();
                }
            });
        }

        // ima fja KosirniciFajl.daLiPostoji(korIme, lozinka) vrati true ako se korisnicko ime + lozinka nalaze u bazi
        // TODO: izmeniti podatke korisnika u bazi pozivom fje KosisniciFile.upis();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        prezimeText.setText(((Korisnik)Main.trenutniKorisnik).getPodaciZaSlanje().getPrezime());
        kimeText.setText(Main.trenutniKorisnik.getKorisnickoIme());
        lozinkaText.setText(Main.trenutniKorisnik.getLozinka());
        adresaText.setText(((Korisnik)Main.trenutniKorisnik).getPodaciZaSlanje().getAdresa());
        imeText.setText(((Korisnik)Main.trenutniKorisnik).getPodaciZaSlanje().getIme());
        brTelText.setText(((Korisnik)Main.trenutniKorisnik).getPodaciZaSlanje().getBrojTelefona());
        email.setText(Main.trenutniKorisnik.getMejl());
        karticaText.setText(((Korisnik)Main.trenutniKorisnik).getPodaciZaSlanje().getBrKartice());
    }
}
