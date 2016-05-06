/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.io.Console;

/**
 *
 * @author fuabioo
 */
public class Geneticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String input = System.console().readLine();
        
        //Console console = System.console();
        //String username = console.readLine("User? ");
        
        Seleccion s = new Seleccion(0);
        System.out.println("Seleccion: "+s.getValor());
        
        // String file = "/home/fuabioo/Desktop/ejemplo";
        // Algoritmo a = new Algoritmo();
        // a.readPoblacion(file);
        // file = "/home/fuabioo/Desktop/ejemplo2";
        // a.writePoblacion(file);
        String file = "Vertex";
        CargarVertex v = new CargarVertex(file);
        Grafo g;
        g = v.getGrafo();
        System.out.println(g.toString());
        
        Gen gen = new Gen();
        gen.llenarGenes(10);
        
        Individuo i1 = new Individuo();
        i1.gen = gen;
        
        System.out.println(gen.genes);
        System.out.println(v.fitnessCalc(i1));
        
        // String file = "/home/fuabioo/Desktop/Minimum";
        file = "Minimum";
        CargarMinimum m = new CargarMinimum(file);
        System.out.println(m.getC());
        System.out.println(m.getS());
        
        Gen gen1 = new Gen();
        gen1.llenarGenes(5);
        
        Individuo i = new Individuo();
        i.gen = gen1;
        System.out.println(gen1.genes);
        System.out.println(m.fitness(i));
        
    }
    
    /*La cadena de bits es de tamano N (len(S))
    y cada uno representa cada indice de subconjunto de C
    
    Ej: S = {1,2,3,4,5}
        C = {{1,2,3},{2,4},{3,4},{4,5}}
        C' = 1001
        C' = {{1,2,3},{4,5}}
    
    fitness = sumatoria de */
    
    
    
}
