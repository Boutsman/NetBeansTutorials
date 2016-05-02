/*
 * http://www.programcreek.com/2013/09/java-reflection-tutorial/
 */
package javaapplication3;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Boutsman
 * @version 0.02
 */
public class Reflection {

    /**
     * Get the  class name from an object
     * and print the result
     * @param obj the object whose Class name you want to know
     * @return name the Class name of the objecht
     */
    public String getObjClassName(Object obj) {
        Class mClass = obj.getClass();
        String name = obj.getClass().getName();
        String simpleName = obj.getClass().getSimpleName();
        return name;
    }
    
    /**
     * Get the class name from a Class
     * @param mClass
     * @return name the Class name
     */
    public String getClassName(Class mClass) {
        String name = mClass.getName();
        String simpleName = mClass.getSimpleName();
        return name;
    }
    
    /**
     * Get all the constructors from a certain Class
     * @param xClass The Class whose constructors you want to get
     * @return str the constructors of the Class
     */
    public String getAlleConstructors(Class xClass){
        StringBuilder sb = new StringBuilder();
        Constructor[] c = xClass.getConstructors();
        for (Constructor x : c) {
            sb.append(x.toString()).append("\n");
            // System.out.println(x.toString());
        }
        String str = sb.toString();
        // System.out.println(str);
        return str;
    }
    
    /**
     * Get all the methods from a certain Class
     * @param xClass the Class whose methods you want te get
     * @return a string with the methods of the Class
     */
    public String getAlleMethodes(Class xClass){
        StringBuilder sb = new StringBuilder();
        Method[] methods = xClass.getMethods();
        for (Method method : methods) {
            sb.append(method.toString()).append("\n");
            // System.out.println(method.toString());
        }
        String str = sb.toString();
        // System.out.println(str);
        return str;
    }
   
    /**
     * Invoke method on unknown object
     * @param m the object that executes the method
     * @param methodName the name of the method that must be executed
     */
    public void invokeMethod(Object m, String methodName) {

        Method method;
        try {
            method = m.getClass().getMethod(methodName, new Class<?>[0]);
            method.invoke(m);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create object from Class instance
     */
    public void makeObject() {
        //create instance of "Class"
        Class<?> c = null;
        try {
            c = Class.forName("javaapplication3.Mens");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create instance of "Mens"
        Mens m = null;

        try {
            m = (Mens) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        m.doeIets();
    }
    
    /**
     * Create object from Class instance
     */
    public Object makeObject2(String className) {
        //create instance of "Class"
        Class<?> c = null;
        try {
            c = Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create instance of "Mens"
        Mens m = null;

        try {
            m = (Mens) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return m;
    }

    /**
     * Get the constructors from a Class and create the Class
     * @param klasse the Class that you want to create
     * @return m1 the Object made from the Class
     */
    public Object createInstance(Class klasse) {
        //create instance of "Class"
        Class<?> c = null;
        try {
            c = Class.forName(klasse.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create instance of "Mens"
        Object m1 = null;

        //get all constructors
        Constructor<?> cons[] = c.getConstructors();

        try {
            m1 = cons[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return m1;
    }
    
    /**
     * Hier probeer ik de vorige methode te hervormen zodat:
     * We de constructor kunnen kiezen
     * De parameters kunnen toevoegen indien nodig
     */
    public Object createInstance2(Class klasse, int param1, int param2, int param3) {
        //create instance of "Class"
        Class<?> c = null;
        try {
            c = Class.forName(klasse.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create instance of "Mens"
        Object obj = null;

        //get all constructors
        Constructor<?> cons[] = c.getConstructors();

        try {
            obj = cons[1].newInstance(param1, param2, param3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
    
    /**
     * Shows how the changeArraySize function works
     */
    public void demoChangeArrSize() {
		int[] intArray = { 1, 2, 3, 4, 5 };
		int[] newIntArray = (int[]) changeArraySize(intArray, 10);
		print(newIntArray);
 
		String[] atr = { "a", "b", "c", "d", "e" };
		String[] str1 = (String[]) changeArraySize(atr, 10);
		print(str1);
	}

    /**
     * change array size
     * @param obj the array whose size you want to change
     * @param len the new length of the array
     * @return the resized array
     */
    public static Object changeArraySize(Object obj, int len) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArray = Array.newInstance(arr, len);

        //do array copy
        int co = Array.getLength(obj);
        System.arraycopy(obj, 0, newArray, 0, co);
        return newArray;
    }

    /**
     * Function that prints the length of an array
     * @param obj the array whose length you want to print
     */
    public static void print(Object obj) {
        Class<?> c = obj.getClass();
        if (!c.isArray()) {
            return;
        }

        System.out.println("\nArray length: " + Array.getLength(obj));

        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i) + " ");
        }
    }
}