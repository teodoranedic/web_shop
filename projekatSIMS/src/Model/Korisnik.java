package Model;
import java.util.*;

/** @pdOid 7456d81e-ca9e-4589-b655-f1c463935706 */
public class Korisnik {
   /** @pdRoleInfo migr=no name=PodaciZaSlanje assc=association1 mult=1..1 */
   public PodaciZaSlanje podaciZaSlanje;
   /** @pdRoleInfo migr=no name=Korpa assc=association2 mult=1..1 */
   public Korpa korpa;

}