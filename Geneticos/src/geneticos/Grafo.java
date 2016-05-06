/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.util.ArrayList;

/**
 *
 * @author fuabioo
 */
public class Grafo {
    private ArrayList<Integer> tupla;
    private ArrayList<ArrayList<Integer>> adya;
    private int cantVertices;
    private int cantAristas;
    private int covered;

    public Grafo() {
        this.adya = new ArrayList<ArrayList<Integer>>();
    }

    public Grafo(int cantVertices, int cantAristas) {
        this.adya = new ArrayList<ArrayList<Integer>>();
        this.cantVertices = cantVertices;
        this.cantAristas = cantAristas;
    }
    
    public void agregarAdyacencia(int origen, int destino){
        tupla = new ArrayList<Integer>();
        tupla.add(origen);
        tupla.add(destino);
        adya.add(tupla);
    }
    public int unselected(Individuo pIndividuo){
        int res = 0;
        for (int i=0;i < this.cantVertices;i++){
            if(pIndividuo.gen.genes.get(i) == 1){
                res+=pIndividuo.gen.genes.get(i);
            }
        }
        return res;
    }
    
    /*
    GT1 Vertez cover
    cada cadena de bits tiene n bits
    donde cada bit representa un vertice
    si el vertice esta seleccionado tiene 1
    uno proporciona el cover
    esta puede ser una manera de sacar el fitness
    
    public double fitnessCalc(){
	double result;
        result = 2 * this.covered + this.unselected(individuo);
	return result;
    }
    */

    public ArrayList<ArrayList<Integer>> getAdya() {
        return adya;
    }

    public void setAdya(ArrayList<ArrayList<Integer>> adya) {
        this.adya = adya;
    }

    public int getCantVertices() {
        return cantVertices;
    }

    public void setCantVertices(int cantVertices) {
        this.cantVertices = cantVertices;
    }

    public int getCantAristas() {
        return cantAristas;
    }

    public void setCantAristas(int cantAristas) {
        this.cantAristas = cantAristas;
    }

    public int getCovered() {
        return covered;
    }

    public void setCovered(int covered) {
        this.covered = covered;
    }

    @Override
    public String toString() {
        return "Grafo{" + "\nadya=" + adya + ", \ncantVertices=" + cantVertices + ", \ncantAristas=" + cantAristas + ", \ncovered=" + covered + '}';
    }
}
