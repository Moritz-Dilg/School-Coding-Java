package designpatterns.mvc.magicMarbles.magicmarbles.ui;

import java.util.EventListener;

public interface MMChangeListener extends EventListener {
    void fieldChanged(MMChangeEvent evt);
}
