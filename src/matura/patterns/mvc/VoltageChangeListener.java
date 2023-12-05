package matura.patterns.mvc;

import java.util.EventListener;

public interface VoltageChangeListener extends EventListener {
    void voltageChanged(VoltageChangeEvent evt);
}
