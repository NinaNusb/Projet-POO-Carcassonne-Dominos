import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Lieu {
    // attributs
    protected int points;
    protected ArrayList<Lieu> zone;
    private Joueur possesseurPartisan;
    private int numeroUnique;
    public static AtomicInteger genID = new AtomicInteger();
    private String position;

    // constructeur
    public Lieu(){}

    // getters et setters nécessaires

    public int getNumeroUnique(){
        return this.numeroUnique;
    }
    public String getPosition(){
        return this.position;
    }
    public void setNumeroUnique(int x){
        this.numeroUnique = x;
    }
    public void setPosition(String p){
        this.position = p;
    }
    public void donneIndice(Lieu lieuAdjacent){
        this.numeroUnique = lieuAdjacent.numeroUnique;
    }
    public void ajouterPartisan(Joueur joueur){
        this.possesseurPartisan = joueur;
    }
    public void retirerPartisan(){
        this.possesseurPartisan = null;
    }
}
