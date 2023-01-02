import java.util.ArrayList;

public class Abbaye extends Lieu { // TODO : à voir si cette classe sert à quelque chose

    public Abbaye(){
        this.points = 0;
    }

    public boolean estTerminee(){
        return true;
    }

    // // Renvoie le nombre de partisans placés sur un ensemble de tuiles de même type
    // public int partisansEnJeu(JoueurCarcassonne j){
    // int nbPartisanEnJeu = 0;
    // for (Champ c : champsAdjacents){
    //     if (c.partisan == true){
    //         nbPartisanEnJeu ++;
    //     }
    // }
    // return nbPartisanEnJeu;
    // }

    // @Override
    // // Renvoie le nombre de partisans appartenant à un joueur donné
    // public int nbPartisanJoueurQuiJoue(int indiceJoueur){ // NOTE_TO_MYSELF: Quand on appelle la méthode il faut utiliser JoueurCarcassonne.joueurQuiJoue
    //     int nbPartisanJoueurQuiJoue = 0;
    //     for (Champ c: champsAdjacents){
    //         if (c.possesseurPartisan == indiceJoueur){ 
    //             nbPartisanJoueurQuiJoue ++;
    //         }
    //     }
    //     return nbPartisanJoueurQuiJoue;
    // }
}