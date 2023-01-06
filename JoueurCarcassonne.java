import java.util.Scanner;

public class JoueurCarcassonne extends Joueur {
    // attributs
    public int nbPartisans;
    private Tuile tuilePosee;
    private String couleur;

    // constructeur
    public JoueurCarcassonne(String nom){
        super(nom);
        this.nbPartisans = 7;
    }
    // getters nécessaires
    public int getNbPartisans(){
        return this.nbPartisans;
    }

    public Tuile getTuile(){
        return this.tuilePosee;
    }

    public String getCouleur(){
        return this.couleur;
    }

    public void setTuile(Tuile t){
        this.tuilePosee = t;
    }

    public void setCouleur(String c){
        this.couleur = c;
    }

    public boolean placePartisan(TuileCarcassonne t, Lieu lieu){
        // Gestion du cas où le joueur n'a plus de partisan
        if (nbPartisans == 0){
            System.out.println("Vous ne pouvez pas placer de partisan.");
            return false;
        }
        // son nombre de partisans diminue de 1
        this.nbPartisans -= 1;
        // la tuile concernée reçoit un partisan (ainsi qu'une trace du joueur qui l'a placé, càd son indice)
        lieu.ajouterPartisan(this);
        // ajoute joueur à liste des possesseurs
        t.getPossesseursPartisans().add(this);
        // ajoute lieu à liste des lieux qui ont un partisan
        t.getPartisansPoses().add(lieu);
        return true;
    }
}