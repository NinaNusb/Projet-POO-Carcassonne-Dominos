public class Champ extends Lieu{

    public Champ(){
        this.points = 1;
    }

    /*public boolean estTerminee(){
        if (Jeu.jeuFini()){ //|| si les tuiles adjacentes sont des villes ou des routes){ TODO: table = null ??
            return true;
        }
        return false;
    }*/

    // // Renvoie le nombre de partisans placés sur un ensemble de tuiles de même type
    // public int partisansEnJeu(JoueurCarcassonne j){
    //     int nbPartisanEnJeu = 0;
    //     for (Champ c : parcelles){
    //         if (c.partisan == true){
    //             nbPartisanEnJeu ++;
    //         }
    //     }
    //     return nbPartisanEnJeu;
    // }

    // @Override
    // // Renvoie le nombre de partisans appartenant à un joueur donné
    // public int nbPartisanJoueurQuiJoue(int indiceJoueur){ // NOTE_TO_MYSELF: Quand on appelle la méthode il faut utiliser JoueurCarcassonne.joueurQuiJoue
    //     int nbPartisanJoueurQuiJoue = 0;
    //     for (Champ c: parcelles){
    //         if (c.possesseurPartisan == indiceJoueur){ 
    //             nbPartisanJoueurQuiJoue ++;
    //         }
    //     }
    //     return nbPartisanJoueurQuiJoue;
    // }
}
