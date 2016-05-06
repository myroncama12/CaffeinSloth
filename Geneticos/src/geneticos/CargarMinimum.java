/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author fuabioo
 */
public class CargarMinimum {
    
    private ArrayList<ArrayList<Integer>> C; // Conjunto C
    private ArrayList<Integer> S;   // Conjunto S
    private int N;  // Tamano del conjunto S
    private int M;  // Cantidad de subconjuntos de S que se encuentran en C
    private ArrayList<Integer> lista;   // Lista temporal con elemento de C

    public CargarMinimum(String file) {
        C = new ArrayList<ArrayList<Integer>>();
        S = new ArrayList<Integer>();
        leer(file);
        fillS();
    }

    public ArrayList<ArrayList<Integer>> getC() {
        return C;
    }

    public ArrayList<Integer> getS() {
        return S;
    }
    
    private void fillS(){
        int n = 1;
        while(n<N+1){
            S.add(n);
            n++;
        }
    }
    
   public double fitness(Individuo pIndividuo){
        double res=0;
        for(int i=0; i < this.M; i++){
            if(pIndividuo.gen.genes.get(i) != 0){
                for(int j = 0; j < C.get(i).size(); j++){
                    res += C.get(i).get(j);
                }
            }
        }
        return res;
    }
    
    private void leer(String file){
        String texto = "";
        int temp;
        try {
            FileReader lector=new FileReader(file);
            BufferedReader contenido=new BufferedReader(lector);
            int i = 0;
            
            while((texto=contenido.readLine())!=null){
                lista = new ArrayList<Integer>();
                if(i==0) {
                    if(!texto.contains("SP5")){
                        break;
                    }
                }
                else if(i==1) {N = Integer.parseInt(texto);}
                else if(i==2) {M = Integer.parseInt(texto);}
                else {
                    String[] splitted = texto.split(" ");
                    for (String splitted1 : splitted) {
                        temp = Integer.parseInt(splitted1);
                        lista.add(temp);
                    }
                    C.add(lista);
                }
                i++;
            }
        }
        catch(Exception e) {
            System.out.println("Error al leer: "+e);
        }
    }
}
