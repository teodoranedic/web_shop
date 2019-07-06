package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartWindowController implements Initializable {

    @FXML
    public void logButtonPushed(ActionEvent event) throws IOException, IOException {
        Parent logovanjeParent = FXMLLoader.load(getClass().getResource("/View/LogWindow.fxml"));
        Scene logovanjeScene = new Scene(logovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(logovanjeScene);
        window.show();
    }

    @FXML
    void signUpButtonPushed(ActionEvent event) throws IOException {
        Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/SignUpWindow.fxml"));
        Scene registrovanjeScene = new Scene(registrovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registrovanjeScene);
        window.show();
    }
    @FXML
    void searchButtonPushed(ActionEvent event) throws IOException {

    }
    @FXML
    public void comboCategoryChanged() {

    }
    @FXML
    public void comboSortChanged() {

    }
    @FXML
    public void comboFilterChanged() {

    }
    @FXML
    public void ShopCartClicked() {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
