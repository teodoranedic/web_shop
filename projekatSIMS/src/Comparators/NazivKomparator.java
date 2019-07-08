package Comparators;

import Model.Proizvod;

import java.util.Comparator;

public class NazivKomparator implements Comparator<Proizvod> {

    private String parametar;

    public NazivKomparator(String par)
    {
        this.parametar = par;
    }

    @Override
    public int compare(Proizvod o1, Proizvod o2) {
        if (this.parametar.equals("rastuce"))
        {
            return o1.getNaziv().compareTo(o2.getNaziv());
        }
        else
        {
            return o2.getNaziv().compareTo(o1.getNaziv());
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
	Collections.sort(listValues, new NazivKomparator("rastuce"));
 */
