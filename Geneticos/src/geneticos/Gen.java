/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author daryl
 */
public class Gen {

    Random rand;
    ArrayList<Integer> genes = new ArrayList<>();

    public Gen() {

    }

    public void llenarGenes(int cant) {
        int cont = 0;
        while (cont < cant) {
            genes.add(generarRandom());
            cont++;
        }
    }

    public int getGenes(int indice) {
        return genes.get(indice);
    }

    public int generarRandom() {
        rand = new Random();
        int value = rand.nextInt(100);
        if (value < 50) {
            return 0;
        }
        return 1;
    }

    public void mutacion(double probMutacion) {
        for (int i = 0; i < genes.size(); i++) {
            rand = new Random();
            double value = rand.nextDouble();
            if (probMutacion >= value) {
                genes.set(i, mutacionAuxiliar(i));
            }
        }
    }

    public int mutacionAuxiliar(int posicion) {
        if (genes.get(posicion) == 0)//ish
        {
            return 1;
        } else {
            return 0;
        }
    }

    public void verGenes() {
        String res = "";
        for (int i = 0; i < genes.size(); i++) {
            res += genes.get(i).toString();

        }
        System.out.println(res);
    }

    public void combinarGenes(Gen parent1, Gen parent2, int cantidadCruces, int tamañoGenes) // cantidaddesaltos/mitadcantidadtotal = numero saltos
    {
        int saltos = (int) tamañoGenes / (cantidadCruces + 1);
        Gen padreActual = parent1;
        for (int i = 0; i < tamañoGenes; i++) {
            if (i % saltos == 0) {
                genes.add(padreActual.genes.get(i));
                if(cambiarPadre(padreActual,parent1)==1)
                    padreActual=parent2;
                padreActual=parent1;
                
            }
            else
            {
                genes.add(padreActual.genes.get(i));
            }

        }

    }
    public int cambiarPadre(Gen actual,Gen p1)
    {
        if(actual==p1)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.genes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gen other = (Gen) obj;
        if (!Objects.equals(this.genes, other.genes)) {
            return false;
        }
        return true;
    }
    
    
}
