package course2.oop.task1;

import course2.oop.task1.utils.Randomizer;

import java.lang.reflect.Method;

public class MethodsArray {
    private Method[] methods;

    public MethodsArray(Method[] m) {
        this.methods = m;
    }

    public Method get(Randomizer rdz) {
        return methods[rdz.random(0, methods.length - 1)];
    }
}
