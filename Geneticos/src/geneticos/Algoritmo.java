/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author fuabioo
 */
public class Algoritmo {
    public Seleccion Politica;
    public int NumCruces;
    public double Mutacion;
    public int TamPoblacion;

    public Algoritmo() {
    }

    public Algoritmo(Seleccion Politica, int NumCruces, double Mutacion) {
        this.Politica = Politica;
        this.NumCruces = NumCruces;
        this.Mutacion = Mutacion;
    }
    
    /**
     * Toma un tamano de poblacion y genera una poblacion
     * aleatoria, este metodo consulta al objeto problema 
     * para saber el tamano del gen.
     * @param Tamano : int
     */
    public void resetPoblacion(int Tamano){
        if(Tamano==0){
            // tomar tamano de la poblacion que se encuentra en el archivo de datos
        }
        else{
            this.TamPoblacion = Tamano;
        }
        // generar generacion aleatoriamente
    }
    /**
     * Lee una poblacion de un archivo, el archivo de 
     * poblacion tiene el siguiente formato:
     *  1- nombre del problema en la primera linea
     *  2- cantidad de genes
     *  3- lista de genes, 1 por linea escritos como 
     *     una secuencia de 1’s y 0’s.
     * @param file : string
     */
    public void readPoblacion(String file){
        String texto = "";
        String nombre = "";
        String cantGenes = "";
        String listaGenes = "";
        try {
            FileReader lector=new FileReader(file);
            BufferedReader contenido=new BufferedReader(lector);
            int i = 0;
            
            while((texto=contenido.readLine())!=null){
                //System.out.println("Linea #"+i+": "+texto);
                if(i==0) {nombre = texto;}
                else if(i==1) {cantGenes = texto;}
                else {listaGenes+=texto;}
                i++;
            }
        }
        catch(Exception e) {
            System.out.println("Error al leer: "+e);
        }
        System.out.println("nombre: "+nombre);
        System.out.println("cantGenes: "+cantGenes);
        System.out.println("listaGenes: "+listaGenes);
    }
    public void writePoblacion(String file){
        String nombre = "problema x";
        String cantGenes = "10000";
        String listaGenes = "1011101011";
        String nwln = "\n";
        try{
            File archivo = new File(file);
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(nombre+nwln);
            escribir.write(cantGenes+nwln);
            for (int i=0; i<listaGenes.length();i++){
                escribir.write(listaGenes.charAt(i)+nwln);
            }
            escribir.close();
        }
        catch(Exception e){
            System.out.println("Error al escribir: "+e);
        }
    }
    public void generacion(){
        
    }
    public Gen getBest(){
        Gen gen = new Gen();
        return gen;
    }
}
