package Model;
import java.util.*;

public abstract class StanjePorudzbine {
   protected Porudzbina kontekst;

   public abstract void odabranoPlacanje();
   public abstract void zavrsenoPlacanje();
   public abstract void magacionerOtpremio();
   public abstract void povratakNazad();
   public abstract void entry();
   public abstract void exit();

   public StanjePorudzbine(Porudzbina k){
      kontekst = k;
   }

}