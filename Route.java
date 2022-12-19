import java.util.LinkedList;

public class Route extends TuileCarcassonne{
    LinkedList <Route> chemins = new LinkedList<Route>();
    static int points; 
    

    public Route(int h[], int[] d, int[] b, int[] g, boolean partisan, int i){
        super(h, d, b, g, partisan, i);
        Route.points = chemins.size(); 
    }

    @Override
    public boolean estTerminee(){
        if (!chemin[1] instanceof Route || /*si c'est la fin du plateau*/ || /*s'il y a 3 routes dans une même tuile */ ){
            return true;
        }
    }

    // Renvoie le nombre de partisans placés sur un ensemble de tuiles de même type
    public int partisansEnJeu(JoueurCarcassonne j){
        int nbPartisanEnJeu = 0;
        for (Route c : chemins){
            if (c.partisan == true){
                nbPartisanEnJeu ++;
            }
        }
        return nbPartisanEnJeu;
    }

    @Override
    // Renvoie le nombre de partisans appartenant à un joueur donné
    public int nbPartisanJoueurQuiJoue(int indiceJoueur){ // NOTE_TO_MYSELF: Quand on appelle la méthode il faut utiliser JoueurCarcassonne.joueurQuiJoue
        int nbPartisanJoueurQuiJoue = 0;
        for (Route c: chemins){
            if (c.possesseurPartisan == indiceJoueur){ 
                nbPartisanJoueurQuiJoue ++;
            }
        }
        return nbPartisanJoueurQuiJoue;
    }
}