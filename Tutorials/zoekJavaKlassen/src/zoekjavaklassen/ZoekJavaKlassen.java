/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoekjavaklassen;

import java.util.Collection;
import java.util.Collections;
import static zoekjavaklassen.Collector.getClassesUsedBy;

/**
 *
 * @author Boutsman
 */
public class ZoekJavaKlassen {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) throws Exception {
        final Collection<Class<?>> classes = getClassesUsedBy(Collections.class.getName(), "java.util");
        System.out.println("Used classes:");
        for (final Class<?> cls : classes) {
            System.out.println(" - " + cls.getName());
        }
    }
}
