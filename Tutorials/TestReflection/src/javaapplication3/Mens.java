/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *@author Boutsman
 */
public class Mens {
    int gewicht;
    int leeftijd;
    int lengte;
    
    public Mens(){
        setGewicht(65);
        setLeeftijd(30);
        setLengte(186);
    }
    
    public Mens(int gewicht, int leeftijd, int lengte){
        setGewicht(gewicht);
        setLeeftijd(leeftijd);
        setLengte(lengte);
    }
    
    public void doeIets(){
            System.out.println("Hoi, ik ben een object gemaakt van de klasse Mens.");
            System.out.println("Ik antwoord dus ik besta.");
    }
    
    public void setGewicht(int gewicht){
        this.gewicht = gewicht;
    }
    
    public void setLeeftijd(int leeftijd){
        this.leeftijd = leeftijd;
    }
    
    public void setLengte(int lengte){
        this.lengte = lengte;
    }
    
    public int getGewicht(){
        return gewicht;
    }
    
    public int getLeeftijd(){
        return leeftijd;
    }
    
    public int getLengte(){
        return lengte;
    }
}
