/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author fuabioo
 */
public class CargarVertex {
    
    private int N;  // Cantidad de vertices del grafo
    private int M;  // Cantidad de aristas del grafo
    private int K;  // Cantidad de vertices cubiertos (Cover)
    private ArrayList<ArrayList<Integer>> adya; // Lista de aristas
    private ArrayList<Integer> tupla;   // Tupla temporal
    private Grafo resultante;   // Grafo resultante de la carga

    public CargarVertex(String file) {
        this.adya = new ArrayList<ArrayList<Integer>>();
        resultante = new Grafo();
        leer(file);
        resultante.setCantVertices(N);
        resultante.setCantAristas(M);
        resultante.setCovered(K);
        resultante.setAdya(adya);
    }
    
    private void agregarAdyacencia(int origen, int destino){
        tupla = new ArrayList<Integer>();
        tupla.add(origen);
        tupla.add(destino);
        adya.add(tupla);
    }
    
    public double fitnessCalc(Individuo pIndividuo){
	double result;
        result = 2 * resultante.getCovered() + resultante.unselected(pIndividuo);
	return result;
    }
    
    private void leer(String file){
        String texto = "";
        int origen;
        int destino;
        try {
            FileReader lector=new FileReader(file);
            BufferedReader contenido=new BufferedReader(lector);
            int i = 0;
            
            while((texto=contenido.readLine())!=null){
                if(i==0) {
                    if(!texto.contains("GT1")){
                        break;
                    }
                }
                else if(i==1) {N = Integer.parseInt(texto);}
                else if(i==2) {M = Integer.parseInt(texto);}
                else if(i==3) {K = Integer.parseInt(texto);}
                else {
                    String[] splitted = texto.split(" ");
                    origen = Integer.parseInt(splitted[0]);
                    destino = Integer.parseInt(splitted[1]);
                    agregarAdyacencia(origen, destino);
                }
                i++;
            }
        }
        catch(Exception e) {
            System.out.println("Error al leer: "+e);
        }
    }
    
    public Grafo getGrafo(){
        return resultante;
    }
    
}
