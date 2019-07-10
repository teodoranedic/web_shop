package EventHandler;

import java.util.EventObject;

public class UpdateEventZaOtpremu extends EventObject {
    private boolean promena;

    public UpdateEventZaOtpremu(Object object, boolean p) {
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
