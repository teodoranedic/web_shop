package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {

    @FXML
    private Label obavestenjeTekst;
    @FXML
    private VBox root11;
    @FXML
    private VBox root12;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    public void backButtonPushed(ActionEvent event) throws IOException, IOException {

        if(Main.trenutniKorisnik == null || Main.trenutniKorisnik.getKorisnickoIme() == null) {
            Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));

            Scene registrovanjeScene = new Scene(registrovanjeParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(registrovanjeScene);
            window.show();
        }else{
            Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLoggedUser.fxml"));

            Scene registrovanjeScene = new Scene(registrovanjeParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(registrovanjeScene);
            window.show();
        }

    }
    public void ispisiProizvodeKorpe(java.util.HashMap<Model.Proizvod,Integer> proizvodi) {

        if (Main.trenutniKorisnik.getKupljeniProizvodi().size()==0) {
            obavestenjeTekst =new Label("Niste jos nista porucili");
        } else {
            obavestenjeTekst =new Label("Istorija porudzbenica");
            for (java.util.Map.Entry<Model.Proizvod, Integer> s : Main.trenutniKorisnik.getKupljeniProizvodi().entrySet()) {

                Image image = new Image(s.getKey().getSlika());
                ImageView view = new ImageView(image);
                view.setFitHeight(160);
                view.setFitWidth(90);
                Label t = new Label(s.getValue().toString());
                root11.getChildren().add(view);
                root12.getChildren().add(t);
                root11.setSpacing(10);
                root11.setPadding(new Insets(10));
                root12.setSpacing(160);
                root12.setPadding(new Insets(10));
            }
            scrollPane.setContent(root11);
            scrollPane.setContent(root12);
            scrollPane.setPannable(true);
        }
    } ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
