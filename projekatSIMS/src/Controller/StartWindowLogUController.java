package Controller;

import Comparators.CenaKomparator;
import Comparators.NazivKomparator;
import EventHandler.UpdateEventZaPregledSajta;
import EventHandler.UpdateListenerZaPregledSajta;
import EventHandler.UpdateListenerZaPregledProizvoda;
import EventHandler.UpdateEventZaPregledProizvoda;
import Model.Boja;
import Model.Kategorija;
import Model.Proizvod;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;

import static Controller.Main.*;

public class StartWindowLogUController implements Initializable, UpdateListenerZaPregledSajta, UpdateListenerZaPregledProizvoda {
        public ActionEvent trenutniDogadjaj;
        public MouseEvent trenutniMouse;
        @FXML
        public ScrollPane scrollPane = new ScrollPane();
        public VBox root = new VBox();
        public GridPane roott = new GridPane();

        @FXML
        public Label message = new Label("Nema rezultata pretrage.");
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

                if (male.getValue()!= null) {
                        komboMuskarci = male.getValue();
                        komboZene = "";
                }
                if (female.getValue()!=null) {
                        komboZene = female.getValue();
                        komboMuskarci = "";
                }
                if (color.getValue()!=null) {
                        komboBoja = color.getValue();
                }
                if (price.getValue()!=null) {
                        komboCena = price.getValue();
                }
                if (sort.getValue()!= null) {
                        komboSort = sort.getValue();
                }

        }
        @FXML
        public void nadjiClicked(ActionEvent event) throws IOException {

                Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));
                Scene registrovanjeScene = new Scene(registrovanjeParent);

                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(registrovanjeScene);
                window.show();
        }

        @FXML
        public void ShopCartClicked(ActionEvent event) throws IOException ,IOException {
                trenutniDogadjaj = event;
                Main.webShop.klikniNaKorpu();



        }

        public void ispisiSortirano(ArrayList<Proizvod> am, int reset){
                for (Proizvod p : am) {
                        Image image = new Image(p.getSlika());
                        ImageView view = new ImageView(image);


                        view.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                                // na klik proizvoda setuje se trenutni proizvod i prelazi se na scenu za prikaz proizvoda
                                Main.trenutniProizvod = p;

                                Parent proizvodParent = null;
                                try {
                                        proizvodParent = FXMLLoader.load(getClass().getResource("/View/Product.fxml"));
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                                Scene proizvodScene = new Scene(proizvodParent);

                                //This line gets the Stage information
                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                window.setScene(proizvodScene);
                                window.show();

                                event.consume();
                        });
                        root.getChildren().add(view);
                        root.setSpacing(10);
                        root.setPadding(new Insets(10));
                        if (reset != 0) {
                                komboCena = "";
                                komboBoja = "";
                                komboMuskarci = "";
                                komboZene = "";
                                trazi = "";
                                komboSort = "";
                        }
                }
                scrollPane.setContent(root);
                scrollPane.setPannable(true);

        }
        public void prebaciUArray(ArrayList<Proizvod> am,HashMap<String, Proizvod> hm) {
                for (Proizvod p:hm.values()) {
                        am.add(p);
                }
                hm.clear();
        }

        public void ispisProizvoda(HashMap<String,Proizvod> hm, int reset){
                if (hm.isEmpty()){
                        root.getChildren().clear();
                        root.getChildren().add(message);
                        root.setSpacing(10);
                        root.setPadding(new Insets(10));
                }

                if (komboSort.equals("cena opadajuce")) {
                        ArrayList<Proizvod> listaZaSortiranje = new ArrayList<>();
                        prebaciUArray(listaZaSortiranje,hm);
                        Collections.sort(listaZaSortiranje, new CenaKomparator("cena opadajuce"));
                        ispisiSortirano(listaZaSortiranje,1);
                }
                else if (komboSort.equals("cena rastuce")) {
                        ArrayList<Proizvod> listaZaSortiranje = new ArrayList<>();
                        prebaciUArray(listaZaSortiranje,hm);
                        Collections.sort(listaZaSortiranje, new CenaKomparator("cena rastuce"));
                        ispisiSortirano(listaZaSortiranje,1);
                }
                else if (komboSort.equals("naziv rastuce")) {
                        ArrayList<Proizvod> listaZaSortiranje = new ArrayList<>();
                        prebaciUArray(listaZaSortiranje,hm);
                        Collections.sort(listaZaSortiranje, new NazivKomparator("naziv rastuce"));
                        ispisiSortirano(listaZaSortiranje,1);
                }
                else if (komboSort.equals("naziv opadajuce")) {
                        ArrayList<Proizvod> listaZaSortiranje = new ArrayList<>();
                        prebaciUArray(listaZaSortiranje,hm);
                        Collections.sort(listaZaSortiranje, new NazivKomparator("naziv opadajuce"));
                        ispisiSortirano(listaZaSortiranje,1);
                }
                else {
                        for (String s : hm.keySet()) {
                                Image image = new Image(s);
                                ImageView view = new ImageView(image);


                                view.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                                        @Override
                                        public void handle(MouseEvent event) {
                                                trenutniMouse =  event;
                                                Main.trenutniProizvod = hm.get(s);
                                                webShop.klikNaProizvod();
                                                event.consume();

                                        }
                                });
                                root.getChildren().add(view);
                                root.setSpacing(10);
                                root.setPadding(new Insets(10));
                                if (reset != 0) {
                                        komboCena = "";
                                        komboBoja = "";
                                        komboMuskarci = "";
                                        komboZene = "";
                                        trazi = "";
                                        komboSort = "";
                                }
                        }
                        scrollPane.setContent(root);
                        scrollPane.setPannable(true);
                }
        };
        HashMap<String, Proizvod> modifikovanaZene = new HashMap<String, Proizvod>();
        HashMap<String, Proizvod> modifikovanaMuskarci = new HashMap<String, Proizvod>();
        HashMap<String, Proizvod> modifikovanaNeutralno = new HashMap<String, Proizvod>();

        public void izlistavanje() {
                double min = 0.0;
                double max = 0.0;
                if (komboCena != "") {
                        min = Double.parseDouble(komboCena.substring(0, komboCena.indexOf("-")));
                        max = Double.parseDouble(komboCena.substring(komboCena.indexOf("-") + 1, komboCena.length()));
                }
                if (komboZene != "") {
                        MuskoZensko(proizvodiZenski,komboZene, modifikovanaZene, min, max);
                        ispisProizvoda(modifikovanaZene,1);
                }
                else if (komboMuskarci!="") {
                        MuskoZensko(proizvodiMuski, komboMuskarci, modifikovanaMuskarci, min, max);
                        ispisProizvoda(modifikovanaMuskarci,1);
                }
                else if (komboMuskarci.equals("") && (komboZene.equals(""))) {
                        Neutralno(proizvodiMuski, modifikovanaNeutralno, min, max);
                        Neutralno(proizvodiZenski, modifikovanaNeutralno, min, max);
                        ispisProizvoda(modifikovanaNeutralno,1);
                }

        }
        public void Neutralno (HashMap<String, Proizvod> hm, HashMap<String, Proizvod> modifikovana, double min, double max){
                for (Proizvod p: hm.values()) {
                        if (komboCena != "" && komboBoja != "") { //ako je odabrao i cenu i boju
                                if (min <= p.getStavkaCenovnika() && p.getStavkaCenovnika() <= max) {
                                        for (Boja b : p.getBoja()) {
                                                if (komboBoja.equals(b.getNaziv())) {
                                                        modifikovana.put(p.getSlika(), p);
                                                }
                                        }
                                }
                        } else if (komboBoja != "" && komboCena == "") { //ako je odabrao samo cenu
                                for (Boja b : p.getBoja()) {
                                        if (komboBoja.equals(b.getNaziv())) {
                                                modifikovana.put(p.getSlika(), p);
                                        }
                                }
                        } else if (komboCena != "" && komboBoja == "") { //akoje odabrao samo boju
                                if (min <= p.getStavkaCenovnika() && p.getStavkaCenovnika() <= max) {
                                        modifikovana.put(p.getSlika(), p);
                                }
                        }
                        else if(komboBoja.equals("")&& komboCena.equals("")){
                                modifikovana.put(p.getSlika(), p);
                        }

                }
                //ispisProizvoda(modifikovana,1);
        }
        public HashMap<String, Proizvod> modBojaCena= new HashMap<String, Proizvod>();
        public void MuskoZensko(HashMap<String, Proizvod> hm, String kombo, HashMap<String, Proizvod> modifikacija, double min, double max){
                for (Proizvod p : hm.values()) {
                        if (p.getKategorija().getNaziv().equals(kombo)) {
                                modBojaCena.put(p.getSlika(), p);
                        }
                }
                Neutralno(modBojaCena, modifikacija, min, max);
        }
        public int Pretraga(HashMap<String,Proizvod>hm) {
                int ret = 0;
                for (Proizvod p : hm.values()) {
                        if (trazi.equals(p.getNaziv().toUpperCase()) || trazi.equals(p.getNaziv().toLowerCase()) || trazi.equals(p.getNaziv()) ) {
                                ret = 1;
                                Image image = new Image(p.getSlika());
                                ImageView view = new ImageView(image);
                                root.getChildren().clear();
                                root.getChildren().add(view);
                                root.setSpacing(10);
                                root.setPadding(new Insets(10));
                        }
                        else {}
                }
                return ret;
        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {


                Main.webShop.addListener(this);
                webShop.addListenerr(this);

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

                if (komboZene.equals("") && komboMuskarci.equals("") && komboBoja.equals("") && komboCena.equals("") && search.getText().equals("") && komboSort.equals("")) {
                        ispisProizvoda(proizvodiMuski, 0);
                        ispisProizvoda(proizvodiZenski, 0);
                }


                if (komboZene!="" || komboMuskarci!="" || komboBoja!="" || komboCena!="" || komboSort!="") {
                        izlistavanje();
                }

        if (!trazi.equals("")){
            int uspesno = 0;
            uspesno += Pretraga(proizvodiMuski);
            uspesno += Pretraga(proizvodiZenski);
            if (uspesno == 0) {
                root.getChildren().clear();
                root.getChildren().add(message);
                root.setSpacing(10);
                root.setPadding(new Insets(10));
            }
        }

        }

        @Override
        public void updatePerformed(UpdateEventZaPregledSajta e) {

                Parent korpaParent = null;
                try {
                        korpaParent = FXMLLoader.load(getClass().getResource("/View/Cart.fxml"));
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
                komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = ""; trazi="";
                Scene korpaScene = new Scene(korpaParent);

                //This line gets the Stage information
                Stage window = (Stage)((Node)trenutniDogadjaj.getSource()).getScene().getWindow();

                window.setScene(korpaScene);
                window.show();
        }

        @Override
        public void updatePerformed(UpdateEventZaPregledProizvoda ee) {
                Parent proizvodParent = null;
                try {
                        proizvodParent = FXMLLoader.load(getClass().getResource("/View/Product.fxml"));
                } catch (IOException e) {
                        e.printStackTrace();
                }
                Scene proizvodScene = new Scene(proizvodParent);

                //This line gets the Stage information
                Stage window = (Stage) ((Node) trenutniMouse.getSource()).getScene().getWindow();

                window.setScene(proizvodScene);
                window.show();

        }
}

