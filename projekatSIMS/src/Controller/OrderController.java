package Controller;

import EventHandler.UpdateEvent;
import EventHandler.UpdateListener;
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

public class OrderController implements Initializable, UpdateListener {
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
        }

    }

    @Override
    public void updatePerformed(UpdateEvent e) {
        Parent porudzbinaParent = null;
        try {
            porudzbinaParent = FXMLLoader.load(getClass().getResource("/View/Cart.fxml"));
            System.out.println("TU SMO");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene porudzbinaScene = new Scene(porudzbinaParent);
        //This line gets the Stage information
        Stage window = (Stage) ((Node) trenutniDogadjaj.getSource()).getScene().getWindow();
        System.out.println(window == null);
        window.setScene(porudzbinaScene);
        window.show();
    }
}