import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class TuileCarcassonne extends Tuile {
    private File chemin;
    private ArrayList<Lieu> partisansPoses;
    private ArrayList<Joueur> possesseursPartisans;
    private boolean blason;

    @SuppressWarnings ("unchecked")
    public TuileCarcassonne(Lieu[] haut, Lieu[] droite, Lieu[] bas, Lieu[] gauche, File file, boolean blason){
        super(haut, droite, bas, gauche);
        this.chemin = file;
        this.partisansPoses = new ArrayList<>();
        this.possesseursPartisans = new ArrayList<>();
        this.blason = blason;
    }
    public File getChemin(){
        return this.chemin;
    }

    public ArrayList<Lieu> getPartisansPoses(){
        return this.partisansPoses;
    }

    public ArrayList<Joueur> getPossesseursPartisans(){
        return this.possesseursPartisans;
    }

    public void ajouterPartisan(Lieu lieu, Joueur joueur){
        partisansPoses.add(lieu);
        possesseursPartisans.add(joueur);
    }

    public void retirerPartisan(Lieu lieu){
        int i = this.partisansPoses.indexOf(lieu);
        this.partisansPoses.remove(i);
        ((JoueurCarcassonne)this.possesseursPartisans.get(i)).nbPartisans += 1;
        this.possesseursPartisans.remove(i);

    }

    public String cotesEgaux(Tuile t){return "";};

    public boolean estTerminee(){};

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
