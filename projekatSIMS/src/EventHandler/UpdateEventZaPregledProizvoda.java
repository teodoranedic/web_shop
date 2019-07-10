package EventHandler;

import java.util.EventObject;

public class UpdateEventZaPregledProizvoda extends EventObject {
    private boolean promena;

    public UpdateEventZaPregledProizvoda(Object object, boolean p) {
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
