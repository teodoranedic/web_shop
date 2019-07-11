package EventHandler;

import java.util.EventObject;

public class UpdateEventSajt extends EventObject {
    private boolean promena;

    public UpdateEventSajt(Object source, boolean p) {
        super(source);
        promena = p;
    }

    public boolean isPromena() {
        return promena;
    }

    public void setPromena(boolean promena) {
        this.promena = promena;
    }
}
