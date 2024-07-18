package InversionOfControl.amazon;

import java.lang.reflect.InvocationTargetException;

public class Locator {




    public static  <T> T Get(T type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (T) type.getClass().getConstructor().newInstance();
    }
}
