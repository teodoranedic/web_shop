import Model.Proizvod;
import Model.Registrovani;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KorisnikTest {
    Registrovani korisnik1 = new Registrovani("Milica", "Poparic", "Bogdana Suputa 81", "0695110998", "2365148", "Popara", "janaMara", "covekimastan@gmail.com");
    Registrovani korisnik2 = new Registrovani("Andjela", "Trajkovic", "Kralja Petra I 8", "0695110665", "45213692", "Trajko", "janaMara", "trajkovic@gmail.com");
    @Test
    public void setMejl() {
        korisnik1.setMejl("fnakjbnfa@gmail.com");
        assertEquals("fnakjbnfa@gmail.com", korisnik1.getMejl());
    }

    @Test
    public void setIme() {
        korisnik2.getPodaciZaSlanje().setIme("Milica");
        assertEquals("Milica", korisnik2.getPodaciZaSlanje().getIme());
    }
}
