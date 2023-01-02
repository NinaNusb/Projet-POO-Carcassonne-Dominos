import java.util.ArrayList;
import java.util.Random;

public abstract class Sac{
    // attributs
    protected ArrayList<Tuile> sac;
    protected final Random rd = new Random();

    // tous les getteurs nécessaires
    public int getLength(){
        return this.sac.size();
    }

    // méthode qui vérifie si le sac est vide
    public boolean estVide(){
        return this.getLength() == 0;
    }

    // méthode qui renvoie une tuile piochée au hasard
    public Tuile piocheTuile(){
        // une tuile au hasard est choisie
        int i = rd.nextInt(this.getLength());
        // elle est piochée
        Tuile t = this.sac.get(i);
        // et donc enlevée du sac
        this.sac.remove(i);
        return t;
    }
}


