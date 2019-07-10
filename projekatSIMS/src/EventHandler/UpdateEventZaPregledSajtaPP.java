package EventHandler;


import java.util.EventObject;

public class UpdateEventZaPregledSajtaPP extends EventObject {
    private boolean promena;

    public UpdateEventZaPregledSajtaPP(Object object, boolean p) {
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
