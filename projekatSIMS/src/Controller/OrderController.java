package Controller;

import EventHandler.UpdateEvent;
import EventHandler.UpdateEventZaOtpremu;
import EventHandler.UpdateListener;
import EventHandler.UpdateListenerZaOtpremu;
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

public class OrderController implements Initializable, UpdateListener, UpdateListenerZaOtpremu {
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

    public ActionEvent trenutniDogadjaj;

    @FXML
    public void poruciButtonPushed(ActionEvent event) throws IOException, IOException {
        trenutniDogadjaj = event;
        if (Main.trenutniKorisnik != null)
        {
            Main.trenutniKorisnik.getKorpa().getPorudzbina().ZavrsenoPlacanje();

            //TODO : prebaciti negde
            /*for (java.util.Map.Entry<Model.Proizvod,Integer> s : Main.trenutniKorisnik.getKorpa().getProizvodi().entrySet())
            {
                Main.trenutniKorisnik.dodajProizvod(s.getKey(),s.getValue());
            }*/



            /*KorisniciFile.upis();
            Main.trenutniKorisnik.getKorpa().getProizvodi().clear();
            //obrisi korpu
            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText("Porudzbina se obradjuje.");
            alert.setContentText("Detaljne informacije dobicete putem email-a.Hvala na poverenju.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK)
                    //ovde pitam gde treba da se vrati
                    alert.close();
            });*/
        }
        else {
            if (imeTekst.getText().equals("") || prezimeTekst.getText().equals("") || adresaTekst.getText().equals("")
                    || brTelTekst.getText().equals("") ||
                    emailTekst.getText().equals("") || brKarticeTekst.getText().equals("")) {
                porukaLabela.setText("Sva polja su obavezna!");
            }
            else
            {
                Main.anonimnaKorpa.getPorudzbina().ZavrsenoPlacanje();
                Main.anonimnaKorpa.getProizvodi().clear();

            /*  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje");
                alert.setHeaderText("Porudzbina se obradjuje.");
                alert.setContentText("Detaljne informacije dobicete putem email-a.Hvala na poverenju.");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK)
                        //ovde pitam gde treba da se vrati
                        alert.close();
                });*/
            }
        }

    }
    @FXML
    public void backButtonPushed(ActionEvent event) throws IOException, IOException {

        trenutniDogadjaj = event;


        if (Main.trenutniKorisnik == null)
            {
                Main.anonimnaKorpa.getPorudzbina().PovratakNazad();
            }
            else
            {
             Main.trenutniKorisnik.getKorpa().getPorudzbina().PovratakNazad();
            }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        if (Main.trenutniKorisnik != null)
        {
            Main.trenutniKorisnik.getKorpa().getPorudzbina().addListener(this);
            Main.trenutniKorisnik.getKorpa().getPorudzbina().addListenerZaOtpremu(this);

            if(Main.trenutniKorisnik.getKorpa().getProizvodi().size()!=0)
            {
                prezimeTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getPrezime());

                imeTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getIme());

                adresaTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getAdresa());

                brKarticeTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getBrKartice());

                brTelTekst.setText(Main.trenutniKorisnik.getPodaciZaSlanje().getBrojTelefona());

                emailTekst.setText(Main.trenutniKorisnik.getMejl());
            }
        } else {
            Main.anonimnaKorpa.getPorudzbina().addListener(this);
            Main.anonimnaKorpa.getPorudzbina().addListenerZaOtpremu(this);
        }

    }

    @Override
    public void updatePerformed(UpdateEvent e) {
        Parent porudzbinaParent = null;
        try {
            porudzbinaParent = FXMLLoader.load(getClass().getResource("/View/Cart.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene porudzbinaScene = new Scene(porudzbinaParent);
        //This line gets the Stage information
        Stage window = (Stage) ((Node) trenutniDogadjaj.getSource()).getScene().getWindow();
        window.setScene(porudzbinaScene);
        window.show();
    }

    @Override
    public void updatePerformed(UpdateEventZaOtpremu e) {

        if (Main.trenutniKorisnik != null) {
            Main.izbor = "/View/StartWindowLoggedUser.fxml";
        }
        else {
            Main.izbor = "/View/StartWindow.fxml";
        }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText("Porudzbina se obradjuje.");
            alert.setContentText("Detaljne informacije dobicete putem email-a.Hvala na poverenju.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK)
                    //ovde pitam gde treba da se vrati
                    alert.close();
                Parent porudzbinaParent = null;
                try {
                    porudzbinaParent = FXMLLoader.load(getClass().getResource(Main.izbor ));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Scene porudzbinaScene = new Scene(porudzbinaParent);
                //This line gets the Stage information
                Stage window = (Stage) ((Node) trenutniDogadjaj.getSource()).getScene().getWindow();
                window.setScene(porudzbinaScene);
                window.show();
            });

        }

}