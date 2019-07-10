package EventHandler;

import java.util.EventObject;

public class UpdateEventZaPregledSajta extends EventObject {
    private boolean promena;

    public UpdateEventZaPregledSajta(Object object, boolean p) {
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
