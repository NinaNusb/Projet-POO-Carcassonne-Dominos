public class Ville extends Lieu{

    public Ville(){
        this.points = 2;
        // TODO il va falloir traiter les blasons
    }

    public boolean estTerminee(){
        // if (/* la bordure de l'ensemble des quartiers est un mur */){ // TODO: les tuiles ville vont recevoir aléatoirement 0, 1, 2, 3 ou 4 murs. En tenir compte
        //     return true;
        // }
        return false;
    }

    // // Renvoie le nombre de partisans placés sur un ensemble de tuiles de même type
    // public int partisansEnJeu(JoueurCarcassonne j){
    //     int nbPartisanEnJeu = 0;
    //     for (Ville c : quartiers){
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
    //     for (Ville c: quartiers){
    //         if (c.possesseurPartisan == indiceJoueur){
    //             nbPartisanJoueurQuiJoue ++;
    //         }
    //     }
    //     return nbPartisanJoueurQuiJoue;
    // }
}
