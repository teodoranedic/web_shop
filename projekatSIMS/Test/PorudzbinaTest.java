import Controller.Main;
import Model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class PorudzbinaTest {
    private static Porudzbina p;


    @Test
    public void promeniStanje()
    {
        p = new Porudzbina();
        p.setTekuceStanje(new Priprema(p));
        Placanje pla = new Placanje(p);
        p.promeniStanje(pla);
        assertEquals(pla, p.getTekuceStanje());
    }

    @Test
    public void isprazniKorpu()
    {
        Proizvod p = new Proizvod();
        HashMap<Proizvod, Integer> proizvodi = new HashMap<Proizvod, Integer>();
        proizvodi.put(p, 1);

        Main.anonimnaKorpa  = new Korpa(proizvodi);
        Main.anonimnaKorpa.getPorudzbina().isprazniKorpu();
        assertEquals(0, Main.anonimnaKorpa.getProizvodi().size());
    }
}
