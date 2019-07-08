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
import java.util.HashMap;
import java.util.ResourceBundle;

import static Controller.Main.*;

public class StartWindowController implements Initializable {

    @FXML
    public ScrollPane scrollPane = new ScrollPane();
    public VBox root =new VBox();
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
    public void logButtonPushed(ActionEvent event) throws IOException, IOException {
        Parent logovanjeParent = FXMLLoader.load(getClass().getResource("/View/LogWindow.fxml"));
        komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = ""; trazi="";
        Scene logovanjeScene = new Scene(logovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(logovanjeScene);
        window.show();
    }

    @FXML
    void signUpButtonPushed(ActionEvent event) throws IOException {
        komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = ""; trazi="";
        Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/SignUpWindow.fxml"));
        Scene registrovanjeScene = new Scene(registrovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registrovanjeScene);
        window.show();
    }
    @FXML
    void searchButtonPushed(ActionEvent event) throws IOException {
        komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = "";
        if (search.getText()!= "") {
            trazi = search.getText();
        }

        Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));
        Scene registrovanjeScene = new Scene(registrovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registrovanjeScene);
        window.show();
    }

    @FXML void comboChanged(ActionEvent event) throws IOException {

        for (Kategorija k : kategorije) {
            if (male.getValue()!= null && male.getValue().equals(k.getNaziv())) {
                komboMuskarci = male.getValue();
                komboZene = "";
            }
            if (female.getValue()!= null && female.getValue().equals(k.getNaziv())){
                komboZene = female.getValue();
                komboMuskarci = "";
            }
        }
        for (Boja b : Main.boje.values()) {
            if (color.getValue() != null && color.getValue().equals(b.getNaziv())) {
                komboBoja = color.getValue();
            }
        }
        if (price.getValue()!=null) {
            komboCena = price.getValue();
        }
        Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));
        Scene registrovanjeScene = new Scene(registrovanjeParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registrovanjeScene);
        window.show();


    }

    @FXML
    public void ShopCartClicked() {

    }
    public void ispisProizvoda(HashMap<String,Proizvod> hm) {
        for (String s : hm.keySet()) {
            Image image = new Image(s);
            ImageView view = new ImageView(image);
            root.getChildren().add(view);
            root.setSpacing(10);
            root.setPadding(new Insets(10));
        }
    };

    public void ispisProizvodaP(HashMap<String, Proizvod> hm, String kombo) {
        int uspesno = 0;
        for (Proizvod p: hm.values()) {
            if (p.getKategorija().getNaziv().equals(kombo)) {
                uspesno = 1;
                Image image = new Image(p.getSlika());
                ImageView view = new ImageView(image);
                root.getChildren().add(view);
                root.setSpacing(10);
                root.setPadding(new Insets(10));
            }
        }
        if (uspesno==0){
            root.getChildren().add(message);
            root.setSpacing(10);
            root.setPadding(new Insets(10));
        }
    }

    public int IspisBoja(HashMap<String,Proizvod> hm, int k) {
        int uspesno = 0;
        for (Proizvod p : hm.values()) {
            for (Boja b : p.getBoja()) {
                if (b.getNaziv().equals(komboBoja)){
                    uspesno = 1;
                    Image image = new Image(p.getSlika());
                    ImageView view = new ImageView(image);
                    if (k==1) {
                        root.getChildren().clear();
                    }
                    root.getChildren().add(view);
                    root.setSpacing(10);
                    root.setPadding(new Insets(10));
                }
            }
        }
        return uspesno;
    }
    HashMap<String,Proizvod> modifikovanaZene = new HashMap<String,Proizvod>();
    public int IspisBojaZene(HashMap<String, Proizvod> hm) {
        int uspesno = 0;
        for (Proizvod p : hm.values()){ //svaki proizvod se proverava
            if (p.getKategorija().getNaziv().equals(komboZene)){
                modifikovanaZene.put(p.getSlika(), p);
            }
        }
        if (!modifikovanaZene.isEmpty()) {
            uspesno = IspisBoja(modifikovanaZene, 1);
        }
        return  uspesno;
    }
    HashMap<String,Proizvod> modifikovanaMuskarci = new HashMap<String,Proizvod>();
    public int IspisBojaMuskarci(HashMap<String, Proizvod> hm) {

        int uspesno = 0;
        for (Proizvod p : hm.values()){ //svaki proizvod se proverava
            if (p.getKategorija().getNaziv().equals(komboMuskarci)){
                modifikovanaMuskarci.put(p.getSlika(), p);
            }
        }
        if (!modifikovanaMuskarci.isEmpty()) {
            uspesno = IspisBoja(modifikovanaMuskarci, 1);
        }
        return  uspesno;
    }

    public int IspisCena(HashMap<String,Proizvod>hm, int min, int max, int k) {
        int uspesno = 0;
        for (Proizvod p : hm.values()) {
            if (min <= p.getStavkaCenovnika() && p.getStavkaCenovnika()<= max) {
                Image image = new Image(p.getSlika());
                ImageView view = new ImageView(image);
                uspesno = 1;
                if (k == 1) {
                    root.getChildren().clear();
                }
                root.getChildren().add(view);
                root.setSpacing(10);
                root.setPadding(new Insets(10));
            } else {}
        }
        return uspesno;
    }
    HashMap<String, Proizvod > zeneCeneModifikovana = new HashMap<String, Proizvod>();
    public int IspisCenaZene(HashMap<String,Proizvod>hm, int min, int max, int k) {
        int uspesno = 0;
        for (Proizvod p : hm.values()){ //svaki proizvod se proverava
            if (p.getKategorija().getNaziv().equals(komboZene)){
                zeneCeneModifikovana.put(p.getSlika(), p);
            }
        }
        if (!zeneCeneModifikovana.isEmpty()) {
            uspesno = IspisCena(zeneCeneModifikovana, min, max, k);
        }
        return  uspesno;
    }
    HashMap<String, Proizvod > muskarciCeneModifikovana = new HashMap<String, Proizvod>();
    public int IspisCenaMuskarci(HashMap<String,Proizvod>hm, int min, int max, int k) {
        int uspesno = 0;
        for (Proizvod p : hm.values()){ //svaki proizvod se proverava
            if (p.getKategorija().getNaziv().equals(komboMuskarci)){
                muskarciCeneModifikovana.put(p.getSlika(), p);
            }
        }
        if (!muskarciCeneModifikovana.isEmpty()) {
            uspesno = IspisCena(muskarciCeneModifikovana, min, max, k);
        }
        return  uspesno;
    }

    public void Pretraga(HashMap<String,Proizvod>hm) {
        for (Proizvod p : hm.values()) {
            if (trazi.equals(p.getNaziv().toUpperCase()) || trazi.equals(p.getNaziv().toLowerCase()) || trazi.equals(p.getNaziv()) ) {
                Image image = new Image(p.getSlika());
                ImageView view = new ImageView(image);
                root.getChildren().add(view);
                root.setSpacing(10);
                root.setPadding(new Insets(10));
            }
            else {}
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Kategorija k: kategorije) {
            maleList.add(k.getNaziv());
            femaleList.add(k.getNaziv());
        }
        for (Boja b: Main.boje.values()) {
            colorList.add(b.getNaziv());
        }


        male.setItems(maleList);
        female.setItems(femaleList);
        color.setItems(colorList);
        sort.setItems(sortList);
        price.setItems(priceList);

        if (komboMuskarci.equals("") && komboZene.equals("") && komboSort.equals("") && komboBoja.equals("") && komboCena.equals("") && trazi.equals("")) {

            ispisProizvoda(proizvodiZenski);
            ispisProizvoda(proizvodiMuski);
        }
        if (komboMuskarci!="" ) { //ispis kada su odabrani muski proizvodi
            ispisProizvodaP(proizvodiMuski, komboMuskarci);
        }


        if (komboZene != "" ) { //ispis kada su odabrani zenski proizvodi
            ispisProizvodaP(proizvodiZenski, komboZene);
        }

        if (komboBoja!="") { //ispis po boji
            int uspesno = 0;
            if (komboZene != "") {
                uspesno += IspisBojaZene(proizvodiZenski);
            }
            else if (komboZene.equals("") && komboMuskarci.equals("")){
                uspesno += IspisBoja(proizvodiMuski, 0); //samo muskarce proveri
                uspesno += IspisBoja(proizvodiZenski, 0); //samo zene proveri
            }
            if (komboMuskarci!= "") {
                uspesno += IspisBojaMuskarci(proizvodiMuski);
            }
            if (uspesno==0){
                root.getChildren().clear();
                root.getChildren().add(message);
                root.setSpacing(10);
                root.setPadding(new Insets(10));
                komboMuskarci = "";
                komboZene = "";
                komboBoja = "";
            }
            else {
                komboMuskarci = "";
                komboZene = "";
                komboBoja = "";
            }
        }

        if (komboCena != "") { //ispis po rasponu cene
            int uspesno = 0;
            int min = Integer.parseInt(komboCena.substring(0,komboCena.indexOf("-")));
            int max = Integer.parseInt(komboCena.substring(komboCena.indexOf("-")+1, komboCena.length()));
            if (komboZene != "") {
                uspesno += IspisCenaZene(proizvodiZenski, min, max, 1);

            }
            else if (komboZene.equals("") && komboMuskarci.equals("")) {
                uspesno += IspisCena(proizvodiMuski,min,max,0);
                uspesno += IspisCena(proizvodiZenski,min,max,0);
            }
            else if (komboMuskarci!= "" ){
                uspesno += IspisCenaMuskarci(proizvodiMuski, min, max, 1);

            }
            if (uspesno==0){
                root.getChildren().clear();
                root.getChildren().add(message);
                root.setSpacing(10);
                root.setPadding(new Insets(10));
                komboMuskarci = "";
                komboZene = "";
                komboCena = "";
            }
            else {
                komboMuskarci = "";
                komboZene = "";
                komboCena = "";
            }
        }

        if (trazi != "") {
            Pretraga(proizvodiMuski);
            Pretraga(proizvodiZenski);
            trazi = "";
        }
        scrollPane.setContent(root);
        scrollPane.setPannable(true);
    }

}

