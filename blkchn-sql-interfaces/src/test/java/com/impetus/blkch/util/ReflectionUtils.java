/*******************************************************************************
* * Copyright 2018 Impetus Infotech.
* *
* * Licensed under the Apache License, Version 2.0 (the "License");
* * you may not use this file except in compliance with the License.
* * You may obtain a copy of the License at
* *
* * http://www.apache.org/licenses/LICENSE-2.0
* *
* * Unless required by applicable law or agreed to in writing, software
* * distributed under the License is distributed on an "AS IS" BASIS,
* * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* * See the License for the specific language governing permissions and
* * limitations under the License.
******************************************************************************/
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
