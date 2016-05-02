/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 * @author Boutsman
 * @version v0.1
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Momenteel gebruikt om code te testen
        test();
    }

    public static void test() {
        //Eerst wordt een Reflection object aangemaakt zodat we het kunnen gebruiken
        Reflection reflect = new Reflection();
        Mens m = new Mens();
        //We slaan de klasse Mens op
        Class mClass = m.getClass();
        Class dClass = Dier.class;
        //We roepen de constructors en methodes op van de Class die we willen construeren
        //System.out.print(reflect.getAlleConstructors(mClass));
        //System.out.print(reflect.getAlleMethodes(mClass));
        //Er wordt een standaard object gemaakt van de klasse Mens
        Object m1 = reflect.createInstance(mClass);
        //Er wordt een custom object gemaakt van de klasse Mens
        Object m2 = reflect.createInstance2(mClass, 1, 10, 100);
        //Er wordt een standaard object gemaakt van de klasse Dier
        Object d = reflect.createInstance(dClass);
        //Op te bewijzen dat het object bestaat laten we het een methode uitvoeren
        //reflect.invokeMethod(m1, "doeIets");
        reflect.invokeMethod(m2, "doeIets");
        //reflect.invokeMethod(d, "doeIets");        
    }
}
