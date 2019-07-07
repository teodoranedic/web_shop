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

public class StartWindowLogUController implements Initializable {

        @FXML
        public void logOutButtonPushed(ActionEvent event) throws IOException, IOException {

            Main.trenutniKorisnik = null;
            Parent odjavaParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));
            Scene odjavaScene = new Scene(odjavaParent);

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(odjavaScene);
            window.show();
        }
        @FXML
        public void ChangeProfileButtonPushed(ActionEvent event) throws  IOException {
                Parent izmenaParent = FXMLLoader.load(getClass().getResource("/View/ChangeProfileWindow.fxml"));
                Scene izmenaScene = new Scene(izmenaParent);

                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(izmenaScene);
                window.show();
        }

        @FXML
        void comboCategoryChanged(ActionEvent event) {

        }

        @FXML
        void comboSortChanged(ActionEvent event) {

        }

        @FXML
        void comboFilterChanged(ActionEvent event) {

        }

        @FXML
        void searchButtonPushed(ActionEvent event) {

        }

        @FXML
        void ShopCartClicked(ActionEvent event) {

        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }
}