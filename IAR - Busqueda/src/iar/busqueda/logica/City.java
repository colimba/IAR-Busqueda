/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iar.busqueda.logica;

/**
 *
 * @author Andres
 */
public class City implements Comparable<City> {
    
    private String name;
    private int weight;
    
    /**
    * Constructor por defecto.
    */    
    public City() {
    }

    public City(String name) {
        this.name = name;
        this.weight = 0;
    }
    
    public City(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "City{" + "name=" + name + ", weight=" + weight + '}';
    }
    
    @Override
    public int compareTo(City o) {
        return this.getName().compareTo(o.getName());
    }
}
