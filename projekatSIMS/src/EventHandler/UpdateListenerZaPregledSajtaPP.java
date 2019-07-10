package EventHandler;

import java.io.IOException;
import java.util.EventListener;

public interface UpdateListenerZaPregledSajtaPP extends EventListener {
    public void updatePerformed(UpdateEventZaPregledSajtaPP e) throws IOException;
}
