import java.util.Objects;

public class Emplacement {
    // attributs
    private int x;
    private int y;
    private Tuile tuile;

    // constructeur à utiliser quand les coordonnées sont importantes
    public Emplacement(int x, int y){
        this.x = x;
        this.y = y;
    }
    // deuxième constructeur à utiliser quand on crée un emplacement sans avoir besoin de ses coordonnées
    public Emplacement(){
    }

    // tous les getters nécessaires
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public Tuile getTuile(){
        return this.tuile;
    }

    // tous les setters nécessaires
    public void setTuile(Tuile tuile){
        this.tuile = tuile;
    }

    // méthode qui vérifie si un emplacement est vide
    public boolean estVide(){
        return Objects.isNull(this.getTuile());
    }

    public String toString(){ // TODO à enlever
        return "X : " + this.x + " Y : " + this.y;
    }
}