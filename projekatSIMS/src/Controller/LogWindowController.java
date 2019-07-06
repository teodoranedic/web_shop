package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogWindowController implements Initializable {


    @FXML
    private PasswordField lozinkaText;

    @FXML
    private TextField kImeText;

    @FXML
    private Label porukaLabela;

    // akcija za logovanje
    @FXML
    public void logButtonPushed(ActionEvent event) throws IOException, IOException {

        // ovde da se proveri da li korisnik postoji
        String korIme = kImeText.getText();
        String lozinka = lozinkaText.getText();

       /*
        Parent logovanjeParent = FXMLLoader.load(getClass().getResource("CheckWindow.fxml"));
        Scene logovanjeScene = new Scene(logovanjeParent);
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logovanjeScene);
        window.show();
        */
    }

    @FXML
    public void nazadButtonPushed(ActionEvent event) throws IOException, IOException {
        Parent logovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));

        Scene logovanjeScene = new Scene(logovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(logovanjeScene);
        window.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
