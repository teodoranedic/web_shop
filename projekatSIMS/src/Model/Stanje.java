package Model;

import java.io.IOException;
import java.util.*;

public abstract class Stanje {
   protected WebShop kontekst;
   public Stanje(WebShop wb){
      kontekst = wb;
   }
   public abstract void entry();
   public abstract void exit();
   public abstract void ubacivanjeUKorpu();
   public abstract void odabraniFilter(String f);
   public abstract void klikNaProizvod() throws IOException;
   public abstract void klikNaNadji() throws IOException;
   public abstract void klikNaPretrazi() throws IOException;
   public abstract void nastavakKupovine();
   public abstract void klikniNaKorpu();
   public abstract void potrvrdaKupovine();
   public abstract void brisanjeProizvoda();
   public abstract void neodobrenaKupovina();
   public abstract void izvrsenoPlacanje();
   public abstract void odobrenaKupovina();
}