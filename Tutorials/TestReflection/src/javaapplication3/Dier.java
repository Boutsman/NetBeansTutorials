/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Boutsman
 */
public class Dier {
    String ras;
    int gewicht;
    int leeftijd;
    
    /**
     * Maak een standaard object hond voor te testen
     */
    public Dier(){
        ras = "hond";
        gewicht = 30;
        leeftijd = 9;
    }
    
    /**
     * Maakt een dier met de gegeven parameters
     * @param ras het ras van de hond
     * @param gewicht het gewicht van de hond
     * @param leeftijd de leeftijd van de hond
     */
    public Dier(String ras, int gewicht, int leeftijd){
        this.ras = ras;
        this.gewicht = gewicht;
        this.leeftijd = leeftijd;        
    }
    
    public void doeIets(){
            System.out.println("Hoi, ik ben een object gemaakt van de klasse Dier.");
            System.out.println("WOEF!!!");
    }
    
    /**
    * Setter for ras
    * @param ras het ras van de hond
    */
    public void setRas(String ras){
        this.ras = ras;
    }
    
    /**
    * Setter for gewicht
    * @param gewicht het gewicht van de hond
    */
    public void setGewicht(int gewicht){
        this.gewicht = gewicht;
    }
    
    /**
    * Setter for leeftijd
    * @param leeftijd de leeftijd van de hond
    */
    public void setLeeftijd(int leeftijd){
        this.leeftijd = leeftijd;
    }
    
    /**
    * Getter for ras
    * @return ras het ras van de hond
    */
    public String getRas() {
        return ras;
    }
    
    /**
    * Getter for gewicht
    * @return gewicht het gewicht van de hond
    */
    public int getGewicht() {
        return gewicht;
    }
    
    /**
    * Getter for leeftijd
    * @return leeftijd de leeftijd van de hond
    */
    public int getLeeftijd() {
        return leeftijd;
    }            
}
