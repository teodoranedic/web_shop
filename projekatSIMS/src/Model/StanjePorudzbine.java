package Model;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class StanjePorudzbine {
   protected Porudzbina kontekst;

   public abstract void odabranoPlacanje();
   public abstract void zavrsenoPlacanje() throws FileNotFoundException;
   public abstract void magacionerOtpremio();
   public abstract void povratakNazad();
   public abstract void entry();
   public abstract void exit();

   public StanjePorudzbine(Porudzbina k){
      kontekst = k;
   }

}