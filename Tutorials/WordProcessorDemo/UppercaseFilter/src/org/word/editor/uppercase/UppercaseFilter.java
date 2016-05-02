/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.word.editor.uppercase;

/**
 *
 * @author Boutsman
 */

import org.openide.util.lookup.ServiceProvider;
import org.word.editor.api.WordFilter; 

@ServiceProvider(service=WordFilter.class) 
public class UppercaseFilter implements WordFilter { 
    @Override public String process(String s) { 
        return s.toUpperCase(); 
    } 
}