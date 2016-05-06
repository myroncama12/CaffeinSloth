/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author daryl
 */
public class Generacion {

    ArrayList<Individuo> generacionActual = new ArrayList<>();
    ArrayList listaFitness = new ArrayList<>();
    static int cantidadIndividuos;
    static int cantidadGenes;
    static double probaMutacion;
    static int cantidadGeneraciones;
    static int tipoSeleccion;
    static int cantidadCruces;
    Random rand;

    public Generacion() {
    }

    public Generacion(int cantInd, int cantGen, double prob, int cantGener, int tipo,int cantCruces) {
        cantidadGenes = cantGen;
        cantidadIndividuos = cantInd;
        probaMutacion = prob;
        cantidadGeneraciones = cantGener;
        tipoSeleccion = tipo;
        cantidadCruces=cantCruces;
        for (int i = 0; i < cantidadIndividuos; i++) {
            Individuo ind = new Individuo();
            ind.gen.llenarGenes(cantGen);
            generacionActual.add(ind);
        }
        for (int i = 0; i < cantidadIndividuos; i++) {//setea la lista como vacia
            listaFitness.add(0);
        }
    }//este metodo crea los indiciduos que pertenecen a la generacion
    //y llena sus genes aleatorios

    public void calcularFitness() {
        for (int i = 0; i < generacionActual.size(); i++) {
            listaFitness.set(i, getFitness(generacionActual.get(i)));
        }
    }

    public double getFitness(Individuo i) {
        double fitness=0.0;
        for (int j = 0; j < cantidadGenes; j++) {
            if(i.gen.getGenes(j)==1)
            {
                fitness+=1;
            }
        }
        return fitness;
    }

    
    public void reproduccion() {
        ArrayList<Individuo> nuevaGeneracion = new ArrayList<>();
        ArrayList<Integer> ruedaFitness = new ArrayList<>();
        System.out.println("Reproduccion:");
        switch (tipoSeleccion) {
            case 0: 
                System.out.println("Simple al Azar");
                
                while (nuevaGeneracion.size() < cantidadIndividuos) {
                    rand = new Random();
                    Gen parent1 = generacionActual.get(rand.nextInt(generacionActual.size())).gen;
                    rand = new Random();
                    Gen parent2 = generacionActual.get(rand.nextInt(generacionActual.size())).gen;
                    if(!parent1.equals(parent2)){
                        Individuo ind = new Individuo();
                        ind.gen.combinarGenes(parent1, parent2,cantidadCruces,cantidadGenes);
                        nuevaGeneracion.add(ind);
                    }
                }
                generacionActual = nuevaGeneracion;
                break;
            case 1:
                System.out.println("Rueda de la fortuna");
                for (int i = 0; i < generacionActual.size(); i++) {
                    int value = (int) getFitness(generacionActual.get(i));
                    for (int j = 0; j < value; j++) {
                        ruedaFitness.add(i);
                        
                    }
                }
                
                int sizeRueda=ruedaFitness.size();
                
                while (nuevaGeneracion.size() < cantidadIndividuos) {
                    rand=new Random();
                    int posicionAlpha= ruedaFitness.get(rand.nextInt(sizeRueda));
                    rand=new Random();
                    int posicionBeta= ruedaFitness.get(rand.nextInt(sizeRueda));
                    Gen alpha=generacionActual.get(posicionAlpha).gen;
                    Gen beta=generacionActual.get(posicionBeta).gen;
                    if(!alpha.equals(beta)){
                        Individuo ind = new Individuo();
                        ind.gen.combinarGenes(alpha, beta,cantidadCruces,cantidadGenes);
                        nuevaGeneracion.add(ind);
                    }
                    
                }

                generacionActual = nuevaGeneracion;
                //cruce
                break;
            case 2://torneo

                int cantidadContendientes= (int) cantidadIndividuos/4;
                while (nuevaGeneracion.size() < cantidadIndividuos) {
                    rand = new Random();
                    Individuo contendienteAlpha = generacionActual.get(rand.nextInt(generacionActual.size()));
                    for (int i = 0; i < cantidadContendientes; i++) {
                        rand = new Random();
                        Individuo contendiente2 = generacionActual.get(rand.nextInt(generacionActual.size()));   
                        if(getFitness(contendienteAlpha)<=getFitness(contendiente2))
                        {
                            contendienteAlpha=contendiente2;
                        }
                    }
                    Individuo contendienteBeta = generacionActual.get(rand.nextInt(generacionActual.size()));
                    for (int i = 0; i < cantidadContendientes; i++) {
                        rand = new Random();
                        Individuo contendiente2 = generacionActual.get(rand.nextInt(generacionActual.size()));   
                        if(getFitness(contendienteBeta)<=getFitness(contendiente2))
                        {
                            contendienteBeta=contendiente2;
                        }
                    }
                    rand = new Random();
                    
                    Gen genAlpha = contendienteAlpha.gen;
                    Gen genBeta = contendienteBeta.gen;
                    if(!genAlpha.equals(genBeta)){
                        Individuo ind = new Individuo();
                        ind.gen.combinarGenes(genAlpha, genBeta,cantidadCruces,cantidadGenes);
                        nuevaGeneracion.add(ind);
                    }
                }
                generacionActual = nuevaGeneracion;
                break;

        }

    }

    public void mutacion() {
        for (int i = 0; i < cantidadIndividuos; i++) {
            generacionActual.get(i).gen.mutacion(probaMutacion);
        }
    }

    public void verIndividuos() {
        System.out.println("Generacion Original:");
        for (int i = 0; i < cantidadIndividuos; i++) {
            generacionActual.get(i).gen.verGenes();
        }
        System.out.println("Generacion Mutada");
        mutacion();
        for (int i = 0; i < cantidadIndividuos; i++) {
            generacionActual.get(i).gen.verGenes();
        }
        reproduccion();
        System.out.println("siguiente Generacion");
        for (int i = 0; i < cantidadIndividuos; i++) {
            generacionActual.get(i).gen.verGenes();
        }
        
    }

}
