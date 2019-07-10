package EventHandler;

import java.util.EventObject;


/**
 * Dogadjaj koji opisuje promene u podacima kontrolera.
 * Kontroler parkinga prosledjuje ovaj dogadjaj svima koji su se registrovali da ga slusaju.
 * U ozbiljnijim sistemima obicno postoji hijerarhija dogadjaja gde svaki opisuje neku specificnu promenu.
 * Za vezbu, mozete napraviti hijerarhiju dogadjaja: apstraktni UpdateEvent i vise naslednika: za promenjeno svetlo
 * na semaforu, za promenjen broj slobodnih mesta, kada je izaslo poslednje vozilo...
 */

public class UpdateEvent extends EventObject {
    private boolean promena;

    public UpdateEvent(Object object, boolean p) {
        super(object);
        promena = p;
    }

    public boolean isPromena() {
        return promena;
    }

    public void setPromena(boolean promena) {
        this.promena = promena;
    }
}