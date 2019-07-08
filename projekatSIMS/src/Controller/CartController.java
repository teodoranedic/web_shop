package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    public void orderButtonPushed(ActionEvent event) throws IOException, IOException {
       //to do da ide na kupovinu
        //ovde pravim instance proizvoda
        //tu povezujem sa scenoom narucivanja tj podataka za narucivanje
    }

    //da proverim jel ide na nazad button i jel  prazni korpu kod ide na nazad
    @FXML
    public void backButtonPushed(ActionEvent event) throws IOException, IOException {
        Parent korpaParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));

        Scene korpaScene = new Scene(korpaParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(korpaScene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


