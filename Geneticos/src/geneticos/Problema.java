/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.io.File;
import java.io.FileWriter;

import java.io.FileReader;
import java.io.BufferedReader;


/**
 *
 * @author fuabioo
 */
public class Problema {
    
    int geneSize;
    String nombre;

    public Problema() {
    }
    public void readProblema(String file) {
        
    }
    public int geneSize() {
        return this.geneSize;
    }
    public double fitness(Gen x){
        return 0;
    }
    public String nombre(){
        return this.nombre;
    }
}
