/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.util.Objects;

/**
 *
 * @author daryl
 */
public class Individuo {
    public Gen gen=new Gen();
    public Individuo() {
        gen= new Gen();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.gen);
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
        final Individuo other = (Individuo) obj;
        if (!Objects.equals(this.gen, other.gen)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
   
}
