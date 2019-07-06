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

public class SignUpWindowController implements Initializable {

    @FXML
    private TextField prezimeText;

    @FXML
    private TextField kimeText;

    @FXML
    private PasswordField lozinkaText;

    @FXML
    private Button registrovanjeButton;

    @FXML
    private TextField adresaText;

    @FXML
    private Label porukaLabela;

    @FXML
    private TextField imeText;

    @FXML
    private TextField brTelText;

    @FXML
    void nazadButtonPushed(ActionEvent event) throws IOException {
        Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));

        Scene registrovanjeScene = new Scene(registrovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registrovanjeScene);
        window.show();
    }

    @FXML
    void signUpButtonPushed(ActionEvent event) throws IOException {
        // TODO: provera podataka (da li postoji korisnicko ime u bazi) - dodati else if izmedju
        if(imeText.getText().equals(" ") || prezimeText.getText().equals("") || adresaText.getText().equals("")
            || brTelText.getText().equals("") || kimeText.getText().equals("")||lozinkaText.getText().equals("")) {
            porukaLabela.setText("Sva polja su obavezna!");
        } else {
            // TODO: dodati korisnika u bazu
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavestenje");
            alert.setHeaderText("Obavestenje");
            alert.setContentText("Uspesna registracija!");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {

                    // nakon registracije ide na prozor za logovanje da se uloguje pa tek onda na glavni prozor za ulogovane

                    Parent registrovanjeParent = null;
                    try {
                        registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/LogWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Scene registrovanjeScene = new Scene(registrovanjeParent);
                    //This line gets the Stage information
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(registrovanjeScene);
                    window.show();
                }
            });

        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
