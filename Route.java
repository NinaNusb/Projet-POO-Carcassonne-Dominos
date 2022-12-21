import java.util.LinkedList;

public class Route extends Lieu{
    LinkedList <Route> chemins = new LinkedList<Route>();
    static int points; 
    

    public Route(Lieu[] lieux){
        super(lieux);
        Route.points = chemins.size(); 
    }

    public boolean estTerminee(){
        // if (!chemins instanceof Route){ //|| /*si c'est la fin du plateau*/ || /*s'il y a 3 routes dans une même tuile */ ){
        //     return true;
        // }
        return false;
    }

    // // Renvoie le nombre de partisans placés sur un ensemble de tuiles de même type
    // public int partisansEnJeu(JoueurCarcassonne j){
    //     int nbPartisanEnJeu = 0;
    //     for (Route c : chemins){
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
    //     for (Route c: chemins){
    //         if (c.possesseurPartisan == indiceJoueur){ 
    //             nbPartisanJoueurQuiJoue ++;
    //         }
    //     }
    //     return nbPartisanJoueurQuiJoue;
    // }
}