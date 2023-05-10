package designpatterns.mvc.valueApp;

import java.util.EventListener;

public interface ValueChangeListener extends EventListener {
    void valueChanged(ValueChangeEvent evt);
}
