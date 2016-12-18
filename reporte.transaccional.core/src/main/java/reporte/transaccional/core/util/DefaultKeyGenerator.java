/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.core.util;

import java.lang.reflect.Method;
import org.springframework.cache.interceptor.KeyGenerator;

/**
 *
 * @author administrador
 */
public class DefaultKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object o, Method method, Object... os) {

        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(method.getName());
        for (Object ob : os) {
            stringbuilder.append(ob.toString());
        }
        return stringbuilder.toString();
    }

}
