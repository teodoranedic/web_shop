package Controller;

import Model.Boja;
import Model.Kategorija;
import Model.Proizvod;
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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Controller.Main.*;

public class StartWindowLogUController implements Initializable {

        @FXML
        public ScrollPane scrollPane = new ScrollPane();
        public VBox root = new VBox();
        public GridPane roott = new GridPane();

        @FXML
        public TextField search = new TextField();
        public Button searchButton = new Button();
        public ComboBox<String> male = new ComboBox<String>();
        public ComboBox<String> female = new ComboBox<String>();
        public ComboBox<String> color = new ComboBox<String>();
        public ComboBox<String> sort = new ComboBox<String>();
        public ComboBox<String> price = new ComboBox<String>();

        @FXML
        ObservableList<String> maleList = FXCollections.observableArrayList();
        ObservableList<String> femaleList = FXCollections.observableArrayList();
        ObservableList<String> colorList = FXCollections.observableArrayList();
        ObservableList<String> priceList = FXCollections.observableArrayList("20000-30000", "50000-70000");
        ObservableList<String> sortList = FXCollections.observableArrayList("cena opadajuce", "cena rastuce", "naziv opadajuce", "naziv rastuce");


        @FXML
        public void logOutButtonPushed(ActionEvent event) throws IOException, IOException {
                komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = ""; trazi="";
                Main.trenutniKorisnik = null;
                Parent odjavaParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));
                Scene odjavaScene = new Scene(odjavaParent);

                //This line gets the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(odjavaScene);
                window.show();
        }

        @FXML
        public void ChangeProfileButtonPushed(ActionEvent event) throws IOException {
                komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = ""; trazi="";
                Parent izmenaParent = FXMLLoader.load(getClass().getResource("/View/ChangeProfileWindow.fxml"));
                Scene izmenaScene = new Scene(izmenaParent);

                //This line gets the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(izmenaScene);
                window.show();
        }

        @FXML
        void searchButtonPushed(ActionEvent event) throws IOException {
                komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = "";
                if (search.getText() != "") {
                        trazi = search.getText();
                }
                Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLoggedUser.fxml"));
                Scene registrovanjeScene = new Scene(registrovanjeParent);

                //This line gets the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(registrovanjeScene);
                window.show();
        }

        @FXML
        void comboChanged(ActionEvent event) throws IOException {

                for (Kategorija k : kategorije) {
                        if (male.getValue() != null && male.getValue().equals(k.getNaziv())) {
                                komboMuskarci = male.getValue();
                                komboZene = "";
                        }
                        if (female.getValue() != null && female.getValue().equals(k.getNaziv())) {
                                komboZene = female.getValue();
                                komboMuskarci = "";
                        }
                }
                for (Boja b : Main.boje.values()) {
                        if (color.getValue() != null && color.getValue().equals(b.getNaziv())) {
                                komboBoja = color.getValue();
                        }
                }
                if (price.getValue() != null) {
                        komboCena = price.getValue();
                }
                Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindowLoggedUser.fxml"));
                Scene registrovanjeScene = new Scene(registrovanjeParent);

                //This line gets the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(registrovanjeScene);
                window.show();


        }

        @FXML
        public void ShopCartClicked() {

        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                for (Kategorija k : kategorije) {
                        maleList.add(k.getNaziv());
                        femaleList.add(k.getNaziv());
                }
                for (Boja b : Main.boje.values()) {
                        colorList.add(b.getNaziv());
                }


                male.setItems(maleList);
                female.setItems(femaleList);
                color.setItems(colorList);
                sort.setItems(sortList);
                price.setItems(priceList);

                if (komboMuskarci.equals("") && komboZene.equals("") && komboSort.equals("") && komboBoja.equals("") && komboCena.equals("") && trazi.equals("")) {
                        for (String s : Main.proizvodiMuski.keySet()) {
                                Image image = new Image(s);
                                ImageView view = new ImageView(image);
                                root.getChildren().add(view);
                                root.setSpacing(10);
                                root.setPadding(new Insets(10));
                        }
                        for (String s : Main.proizvodiZenski.keySet()) {
                                Image image = new Image(s);
                                ImageView view = new ImageView(image);
                                root.getChildren().add(view);
                                root.setSpacing(10);
                                root.setPadding(new Insets(10));
                        }

                        scrollPane.setContent(root);
                        scrollPane.setPannable(true);
                }
                if (komboMuskarci != "") {
                        komboBoja = "";
                        komboCena = "";
                        for (Proizvod p : Main.proizvodiMuski.values()) {
                                if (p.getKategorija().getNaziv().equals(komboMuskarci)) {
                                        Image image = new Image(p.getSlika());
                                        ImageView view = new ImageView(image);
                                        root.getChildren().add(view);
                                        root.setSpacing(10);
                                        root.setPadding(new Insets(10));
                                } else {
                                }
                        }
                        scrollPane.setContent(root);
                        scrollPane.setPannable(true);
                }


                if (komboZene != "") {
                        komboBoja = "";
                        komboCena = "";
                        for (Proizvod p : proizvodiZenski.values()) {
                                if (p.getKategorija().getNaziv().equals(komboZene)) {
                                        Image image = new Image(p.getSlika());
                                        ImageView view = new ImageView(image);
                                        root.getChildren().add(view);
                                        root.setSpacing(10);
                                        root.setPadding(new Insets(10));
                                } else {

                                }

                        }
                        scrollPane.setContent(root);
                        scrollPane.setPannable(true);
                }

                if (komboBoja != "") {
                        if (komboZene != "" || (komboZene == "" && komboMuskarci == "")) {
                                for (Proizvod p : proizvodiZenski.values()) {
                                        for (Boja b : p.getBoja()) {
                                                if (b.getNaziv().equals(komboBoja)) {
                                                        Image image = new Image(p.getSlika());
                                                        ImageView view = new ImageView(image);
                                                        root.getChildren().add(view);
                                                        root.setSpacing(10);
                                                        root.setPadding(new Insets(10));
                                                } else {

                                                }
                                        }
                                }
                                scrollPane.setContent(root);
                                scrollPane.setPannable(true);
                        }
                        if (komboMuskarci != "" || (komboZene == "" && komboMuskarci == "")) {
                                for (Proizvod p : proizvodiMuski.values()) {
                                        for (Boja b : p.getBoja()) {
                                                if (b.getNaziv().equals(komboBoja)) {
                                                        Image image = new Image(p.getSlika());
                                                        ImageView view = new ImageView(image);
                                                        root.getChildren().add(view);
                                                        root.setSpacing(10);
                                                        root.setPadding(new Insets(10));
                                                } else {

                                                }
                                        }
                                }
                                scrollPane.setContent(root);
                                scrollPane.setPannable(true);
                        }
                }
                if (komboCena != "") {
                        int min = Integer.parseInt(komboCena.substring(0, komboCena.indexOf("-")));
                        int max = Integer.parseInt(komboCena.substring(komboCena.indexOf("-") + 1, komboCena.length()));
                        System.out.println(max);
                        if (komboZene != "" || (komboZene == "" && komboMuskarci == "")) {
                                for (Proizvod p : proizvodiZenski.values()) {
                                        if (min <= p.getStavkaCenovnika() && p.getStavkaCenovnika() <= max) {
                                                Image image = new Image(p.getSlika());
                                                ImageView view = new ImageView(image);
                                                root.getChildren().add(view);
                                                root.setSpacing(10);
                                                root.setPadding(new Insets(10));
                                        } else {

                                        }
                                }
                                scrollPane.setContent(root);
                                scrollPane.setPannable(true);
                        }
                        if (komboMuskarci != "" || (komboZene == "" && komboMuskarci == "")) {
                                for (Proizvod p : proizvodiMuski.values()) {
                                        if (min <= p.getStavkaCenovnika() && p.getStavkaCenovnika() <= max) {
                                                Image image = new Image(p.getSlika());
                                                ImageView view = new ImageView(image);
                                                root.getChildren().add(view);
                                                root.setSpacing(10);
                                                root.setPadding(new Insets(10));
                                        } else {

                                        }
                                }
                                scrollPane.setContent(root);
                                scrollPane.setPannable(true);
                        }
                }
                if (trazi != "") {
                        for (Proizvod p : Main.proizvodiMuski.values()) {
                                if (trazi.equals(p.getNaziv().toUpperCase()) || trazi.equals(p.getNaziv().toLowerCase()) || trazi.equals(p.getNaziv())) {
                                        Image image = new Image(p.getSlika());
                                        ImageView view = new ImageView(image);
                                        root.getChildren().add(view);
                                        root.setSpacing(10);
                                        root.setPadding(new Insets(10));
                                } else {
                                }
                        }
                        for (Proizvod p : Main.proizvodiZenski.values()) {

                                if (trazi.equals(p.getNaziv().toUpperCase()) || trazi.equals(p.getNaziv().toLowerCase()) || trazi.equals(p.getNaziv())) {
                                        Image image = new Image(p.getSlika());
                                        ImageView view = new ImageView(image);
                                        root.getChildren().add(view);
                                        root.setSpacing(10);
                                        root.setPadding(new Insets(10));
                                } else {
                                }
                        }

                        scrollPane.setContent(root);
                        scrollPane.setPannable(true);
                        trazi = "";
                }
        }
}