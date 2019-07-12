import Controller.Main;
import FileHandler.*;
import Model.PregledKorpe;
import Model.Proizvod;
import Model.Stanje;
import Model.WebShop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WebShopTest {

    @Test
    public void pretraga()
    {
        WebShop ws = new WebShop();
        HashMap<String, Proizvod> rezultati = new HashMap<String, Proizvod>();
        try
        {
            BojeFile.ucitaj();
            KategorijeFile.ucitaj();
            StavkeFile.ucitaj();
            VelicineFile.ucitaj();
            ProizvodiFile.ucitaj("./data/proizvodiMuski.txt");
            ProizvodiFile.ucitaj("./data/proizvodiZenski.txt");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Main.trazi = "torba";
        rezultati = ws.Pretraga();
        assertNotEquals(0, rezultati.size());
        assertEquals("torba", rezultati.get("/productsFemale/versaceBag.jpg").getNaziv().toLowerCase());
    }

    @Test
    public void promeniStanje()
    {
        WebShop ws = new WebShop();
        Stanje novoStanje = new PregledKorpe(ws);
        ws.promeniStanje(novoStanje);
        assertEquals(novoStanje, ws.tekuceStanje);
    }
}
