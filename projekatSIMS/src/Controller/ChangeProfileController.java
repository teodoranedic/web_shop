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
    void nazadButtonPushed(ActionEvent event) throws IOException {
        Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLogU.fxml"));

        Scene registrovanjeScene = new Scene(registrovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registrovanjeScene);
        window.show();
    }

    @FXML
    void changeButtonPushed(ActionEvent event) throws IOException {
        // TODO: provera podataka (da li postoji korisnicko ime u bazi) - dodati else if izmedju

        // TODO: izmeniti podatke korisnika u bazi
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
