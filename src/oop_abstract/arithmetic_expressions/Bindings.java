package oop_abstract.arithmetic_expressions;

import java.util.HashMap;

public class Bindings {
    private final HashMap<String, Integer> bindings = new HashMap<>();

    public void set(String name, int value) {
        bindings.put(name, value);
    }

    public int get(String name) {
        if (bindings.containsKey(name))
            return bindings.get(name);

        return 0;
    }
}
