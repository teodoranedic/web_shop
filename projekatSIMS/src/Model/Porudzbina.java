package Model;
import java.util.*;

/** @pdOid c012e309-db8a-44e3-b032-b41641001173 */
public class Porudzbina {
   /** @pdOid 993ae0c7-3ab0-4c4d-9d22-a45b6a32fc8c */
   private StanjePorudzbine stanje;
   /** @pdOid 671c0af3-5ee3-4113-ba81-2dbad5f03ab1 */
   private Date datum;
   /** @pdOid 9e39d5d3-5d14-4b55-8c8b-a63f365a7491 */
   private NacinPlacanja nacinPlacanja;
   
   /** @pdRoleInfo migr=no name=PodaciZaSlanje assc=association20 mult=1..* */
   public PodaciZaSlanje[] podaciZaSlanje;
   /** @pdRoleInfo migr=no name=StanjePorudzbine assc=association22 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<StanjePorudzbine> stanjePorudzbine;
   
   /** @pdOid 8da915b3-eacb-4f05-be14-88275789bc9c */
   public int unesiPodatke() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid c5ad2143-431b-40de-adac-abafc23b67ce */
   public int unesiNacinPlacanja() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid a34705cd-9b91-4a79-bfcf-526718bbf297 */
   public int pokusajPlacanje() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 0c3f1fb4-33d1-46b9-8b76-32007d967ae2 */
   public int salji() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid ea1a0e0f-e735-4bbd-8019-5eadc11c7c8a */
   public int informisiMagacionera() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 94ea12a5-004d-42da-944a-99a7227b142e */
   public int OdabranoPlacanje() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid a9809cb6-d7f3-4f89-8d3d-a8d22e4d4ca9 */
   public int ZavrsenoPlacanje() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 457a9835-6692-4298-9ea2-49af516e5aef */
   public int MagacionerOtpremio() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 3577a15a-be6d-4109-a800-aaf129abdc48 */
   public int promeniStanje() {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<StanjePorudzbine> getStanjePorudzbine() {
      if (stanjePorudzbine == null)
         stanjePorudzbine = new java.util.HashSet<StanjePorudzbine>();
      return stanjePorudzbine;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStanjePorudzbine() {
      if (stanjePorudzbine == null)
         stanjePorudzbine = new java.util.HashSet<StanjePorudzbine>();
      return stanjePorudzbine.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStanjePorudzbine */
   public void setStanjePorudzbine(java.util.Collection<StanjePorudzbine> newStanjePorudzbine) {
      removeAllStanjePorudzbine();
      for (java.util.Iterator iter = newStanjePorudzbine.iterator(); iter.hasNext();)
         addStanjePorudzbine((StanjePorudzbine)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStanjePorudzbine */
   public void addStanjePorudzbine(StanjePorudzbine newStanjePorudzbine) {
      if (newStanjePorudzbine == null)
         return;
      if (this.stanjePorudzbine == null)
         this.stanjePorudzbine = new java.util.HashSet<StanjePorudzbine>();
      if (!this.stanjePorudzbine.contains(newStanjePorudzbine))
         this.stanjePorudzbine.add(newStanjePorudzbine);
   }
   
   /** @pdGenerated default remove
     * @param oldStanjePorudzbine */
   public void removeStanjePorudzbine(StanjePorudzbine oldStanjePorudzbine) {
      if (oldStanjePorudzbine == null)
         return;
      if (this.stanjePorudzbine != null)
         if (this.stanjePorudzbine.contains(oldStanjePorudzbine))
            this.stanjePorudzbine.remove(oldStanjePorudzbine);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStanjePorudzbine() {
      if (stanjePorudzbine != null)
         stanjePorudzbine.clear();
   }

}