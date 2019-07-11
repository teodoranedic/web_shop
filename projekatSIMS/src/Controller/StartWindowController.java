package Controller;

import Comparators.CenaKomparator;
import Comparators.NazivKomparator;
import EventHandler.UpdateEventZaPregledProizvoda;
import EventHandler.UpdateEventZaPregledSajta;
import EventHandler.UpdateEventSajt;
import EventHandler.UpdateListenerSajt;
import EventHandler.UpdateEventZaPregledSajtaPP;
import EventHandler.UpdateListenerZaPregledSajtaPP;
import EventHandler.UpdateListenerZaPregledSajta;
import EventHandler.UpdateListenerZaPregledProizvoda;
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
import java.util.*;

import static Controller.Main.*;

public class StartWindowController implements Initializable, UpdateListenerZaPregledSajta, UpdateListenerZaPregledProizvoda, UpdateListenerSajt {


    public ActionEvent trenutniDogadjaj;
    public MouseEvent trenutniMouse;
    @FXML
    public static Button korpaa;
    public ScrollPane scrollPane = new ScrollPane();
    public VBox root =new VBox();
    public GridPane roott = new GridPane();

    @FXML
    public Label message = new Label("Nema rezultata pretrage.");
    public TextField search = new TextField("");
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
        //komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = ""; trazi="";
        Scene logovanjeScene = new Scene(logovanjeParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logovanjeScene);
        window.show();
    }

    @FXML
    void signUpButtonPushed(ActionEvent event) throws IOException {
        //komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = ""; trazi="";
        Parent registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/SignUpWindow.fxml"));
        Scene registrovanjeScene = new Scene(registrovanjeParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registrovanjeScene);
        window.show();
    }
    @FXML
    void searchButtonPushed(ActionEvent event) throws IOException {
        //komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = "";
        if (search.getText()!= "") {
            trazi = search.getText();
        }
        trenutniDogadjaj = event;
        webShop.klikNaPretrazi();


    }

    @FXML void comboChanged(ActionEvent event) throws IOException {

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
        if (sort.getValue() != null) {
            komboSort = sort.getValue();
        }

    }
    @FXML
    public void nadjiClicked(ActionEvent event) throws IOException {

        trenutniDogadjaj = event;
        webShop.klikNaNadji();
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
          /*  if (reset != 0) {
                komboCena = "";
                komboBoja = "";
                komboMuskarci = "";
                komboZene = "";
                trazi = "";
                komboSort = "";
            }*/
        }
        scrollPane.setContent(root);
        scrollPane.setPannable(true);
        webShop.listaZaSortiranje.clear(); //mora da bude prazna kad god se udje na sortiranje opet
    }

    public void ispisProizvoda(HashMap<String,Proizvod> hm, int reset){
        if (hm.isEmpty()){
            root.getChildren().clear();
            root.getChildren().add(message);
            root.setSpacing(10);
            root.setPadding(new Insets(10));
        }

        webShop.proveriFiltere(hm);

        if (!webShop.listaZaSortiranje.isEmpty()) {
            ispisiSortirano(webShop.listaZaSortiranje,1);
        }
        else{
            for (String s : hm.keySet()) {
                Image image = new Image(s);
                ImageView view = new ImageView(image);


                view.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        trenutniMouse = event;
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {
            Main.webShop.addListener(this);
            webShop.addListenerr(this);
            webShop.addListenerSajt(this);


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


        if (webShop.proveriUcitavanje()==1) {
            ispisProizvoda(proizvodiMuski, 0);
            ispisProizvoda(proizvodiZenski, 0);
        }


        else if (webShop.proveriUcitavanje()==2) {
            HashMap<String, Proizvod> zaIspisProizvoda = webShop.izlistavanje();
            ispisProizvoda(zaIspisProizvoda,1); //ovo mora da radi kontroler
            webShop.iscistiHesh();
            webShop.resetujFiltere();
        }
        else if (webShop.proveriUcitavanje() == 3) {
            ispisProizvoda(webShop.Pretraga(), 1);
        }


    }

    @Override
    public void updatePerformed(UpdateEventSajt e)  {

        Parent registrovanjeParent = null;
        try {
            registrovanjeParent = FXMLLoader.load(getClass().getResource("/View/StartWindow.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene registrovanjeScene = new Scene(registrovanjeParent);
        Stage window = (Stage)((Node)trenutniDogadjaj.getSource()).getScene().getWindow();
        window.setScene(registrovanjeScene);
        window.show();
    }
    @Override
    public void updatePerformed(UpdateEventZaPregledSajta e)  {

        Parent korpaParent = null;
        try {
            korpaParent = FXMLLoader.load(getClass().getResource("/View/Cart.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        komboBoja = ""; komboCena = ""; komboZene= ""; komboMuskarci = ""; komboSort = ""; trazi="";
        Scene korpaScene = new Scene(korpaParent);
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




