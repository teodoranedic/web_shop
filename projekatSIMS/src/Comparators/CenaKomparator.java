package Comparators;

import Model.Proizvod;

import java.util.Comparator;

public class CenaKomparator implements Comparator<Proizvod> {

    private String parametar;

    public CenaKomparator(String par)
    {
        this.parametar = par;
    }


    @Override
    public int compare(Proizvod o1, Proizvod o2) {
        if (this.parametar.equals("rastuce"))
        {
            double cena1 = o1.getStavkaCenovnika();
            double cena2 = o2.getStavkaCenovnika();
            return (int)(cena1*100 - cena2*100);
        }
        else
        {
            double cena1 = o2.getStavkaCenovnika();
            double cena2 = o1.getStavkaCenovnika();
            return (int)(cena1*100 - cena2*100);
        }

    }
}
/*
ovako se poziva sortiranje
ArrayList<Proizvod> listaRezultataPretrage;
	if ( == null) {
		System.out.println("Nema rezultata");
		return;
	}
	Collections.sort(listValues, new CenaKomparator("rastuce"));
 */

