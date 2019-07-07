package Controller;

import Model.Kategorija;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Controller.Main.kategorije;

public class StartWindowController implements Initializable {

    @FXML
    public ScrollPane scrollPane = new ScrollPane();
    public VBox root =new VBox();
    public GridPane roott = new GridPane();

    @FXML
    public ComboBox<String> category = new ComboBox<String>();
    public ComboBox<String> filter = new ComboBox<String>();
    public ComboBox<String> sort = new ComboBox<String>();

    @FXML
    ObservableList<String> categoryList = FXCollections.observableArrayList();
    ObservableList<String> filterList = FXCollections.observableArrayList("boja", "raspon cene", "brend"); //ovo da se sad ne zajebavam sa ovim
    ObservableList<String> sortList = FXCollections.observableArrayList("cena opadajuce", "cena rastuce", "naziv opadajuce", "naziv rastuce");




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
        for (Kategorija k: kategorije) {
            categoryList.add(k.getNaziv());
        }

        category.setItems(categoryList);
        filter.setItems(filterList);
        sort.setItems(sortList);
        for (String s : Main.proizvodi.keySet()) {
            Image image = new Image(s);
            ImageView view = new ImageView(image);
            root.getChildren().add(view);
            root.setSpacing(10);
            root.setPadding(new Insets(10));
        }

            scrollPane.setContent(root);
            scrollPane.setPannable(true);



    }
}
