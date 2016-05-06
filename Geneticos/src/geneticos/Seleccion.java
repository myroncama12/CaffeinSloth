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
public class Seleccion {
    private ArrayList<String> l;
    int valor;

    public Seleccion(int valor) {
        l = new ArrayList<String>();
        l.add("Azar");
        l.add("RuedaFortuna");
        l.add("Torneo");
        this.valor = valor;
    }

    public String getValor() {
        return l.get(valor);
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
