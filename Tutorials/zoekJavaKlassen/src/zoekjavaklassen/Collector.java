/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoekjavaklassen;

import com.sun.org.apache.bcel.internal.generic.EmptyVisitor;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.commons.Remapper;
import jdk.internal.org.objectweb.asm.commons.RemappingClassAdapter;

/**
 *
 * @author Boutsman
 */
public static class Collector extends Remapper {

    private final Set<Class<?>> classNames;
    private final String prefix;

    public Collector(final Set<Class<?>> classNames, final String prefix) {
        this.classNames = classNames;
        this.prefix = prefix;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String mapDesc(final String desc) {
        if (desc.startsWith("L")) {
            this.addType(desc.substring(1, desc.length() - 1));
        }
        return super.mapDesc(desc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] mapTypes(final String[] types) {
        for (final String type : types) {
            this.addType(type);
        }
        return super.mapTypes(types);
    }

    private void addType(final String type) {
        final String className = type.replace('/', '.');
        if (className.startsWith(this.prefix)) {
            try {
                this.classNames.add(Class.forName(className));
            } catch (final ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Override
    public String mapType(final String type) {
        this.addType(type);
        return type;
    }

    public static Set<Class<?>> getClassesUsedBy(
        final String name, // class name
        final String prefix // common prefix for all classes
        // that will be retrieved
    ) throws IOException {
        final ClassReader reader = new ClassReader(name);
        final Set<Class<?>> classes = new TreeSet<Class<?>>(new Comparator<Class<?>>() {

                    @Override
                    public int compare(final Class<?> o1, final Class<?> o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
        final Remapper remapper = new Collector(classes, prefix);
        final ClassVisitor inner = new EmptyVisitor();
        final RemappingClassAdapter visitor = new RemappingClassAdapter(inner, remapper);
        reader.accept(visitor, 0);
        return classes;
    }

}
