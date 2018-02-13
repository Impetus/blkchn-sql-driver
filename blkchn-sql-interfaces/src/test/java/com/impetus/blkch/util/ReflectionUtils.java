package com.impetus.blkch.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static Object invoke(Object object, String name, Class<?> parameterTypes[], Object args[]) throws Throwable {
        if (object == null) {
            throw new IllegalArgumentException("Invalid null object argument");
        }
        Class<?> cls = object.getClass();
        while (cls != null) {
            try {
                Method method = cls.getDeclaredMethod(name, parameterTypes);
                method.setAccessible(true);
                return method.invoke(object, args);
            } catch (InvocationTargetException e) {
                /*
                 * if the method throws an exception, it is embedded into an
                 * InvocationTargetException.
                 */
                throw e.getTargetException();
            } catch (Exception ex) {
                // IGNORE
            }
            cls = cls.getSuperclass();
        }
        throw new NoSuchMethodException("Failed method invocation: " + object.getClass().getName() + "." + name + "()");
    }
}
