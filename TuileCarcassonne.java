import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class TuileCarcassonne extends Tuile {
    // attributs
    private File chemin;
    private ArrayList<Lieu> partisansPoses;
    private ArrayList<Joueur> possesseursPartisans;
    private boolean blason;
    private int nbPivot;

    // constructeur
    @SuppressWarnings ("unchecked")
    public TuileCarcassonne(Lieu[] haut, Lieu[] droite, Lieu[] bas, Lieu[] gauche, File file, boolean blason){
        super(haut, droite, bas, gauche);
        this.chemin = file;
        this.partisansPoses = new ArrayList<>();
        this.possesseursPartisans = new ArrayList<>();
        this.blason = blason;
        this.nbPivot = 0;
    }

    // tous les getters et setters nécessaires
    public File getChemin(){
        return this.chemin;
    }
    public boolean getBlason(){
        return this.blason;
    }
    public int getNbPivot(){
        return this.nbPivot;
    }
    public void setNbPivot(int x){
        this.nbPivot = x;
    }
    public ArrayList<Lieu> getPartisansPoses(){
        return this.partisansPoses;
    }
    public ArrayList<Joueur> getPossesseursPartisans(){
        return this.possesseursPartisans;
    }

    public ArrayList<String> cotesEgaux(Tuile t){

        ArrayList<String> possibilites = new ArrayList<>();
        if (this.getHaut()[1].getClass().equals(((Lieu)t.getBas()[1]).getClass())){
            // on retourne le lieu où on peut poser la tuile
            possibilites.add("b");
        }
        if (this.getDroite()[1].getClass().equals(((Lieu)t.getGauche()[1]).getClass())){
            // on retourne le lieu où on peut poser la tuile
            possibilites.add("g");
        }
        if (this.getBas()[1].getClass().equals(((Lieu)t.getHaut()[1]).getClass())){
            // on retourne le lieu où on peut poser la tuile
            possibilites.add("h");
        }
        if (this.getGauche()[1].getClass().equals(((Lieu)t.getDroite()[1]).getClass())){
            // on retourne le lieu où on peut poser la tuile
            possibilites.add("d");
        }

        // si aucun des côtés de la TuileEnMain n'est égal avec la tuile déjà posée, on retourne un string vide
        return possibilites;
    }

    //public boolean estTerminee(){};

    //public int nbPartisanJoueurQuiJoue(int indiceJoueur){};
    public String toString(){ // TODO à enlever
        System.out.print("haut " + Arrays.toString(this.getHaut()));
        System.out.print(" droite " + Arrays.toString(this.getDroite()));
        System.out.print(" bas " + Arrays.toString(this.getBas()));
        System.out.print(" gauche " + Arrays.toString(this.getGauche()));
        System.out.print(chemin);
        System.out.print(" " + blason);
        return "";
    }
}
