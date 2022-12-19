import java.util.LinkedList;

public class Abbaye extends TuileCarcassonne {
    private LinkedList<Champ> champsAdjacents = new LinkedList<Champ>();
    static int points; 
    
    public Abbaye(int[] h, int[] d, int[] b, int[] g, boolean partisan, int i){
        super(h, d, b, g, partisan, i);
        // Les points d'une abbaye ne sont compatabilisés que si elle est entourée de champs
        if (champsAdjacents.size() >= 11){
            Abbaye.points = 8; // TODO: nb à modifier
        } else {
            Abbaye.points = 0;  
        } 
    }

    @Override
    public boolean estTerminee(){
        return true;
    }

    // Renvoie le nombre de partisans placés sur un ensemble de tuiles de même type
    public int partisansEnJeu(JoueurCarcassonne j){
    int nbPartisanEnJeu = 0;
    for (Champ c : champsAdjacents){
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
        for (Champ c: champsAdjacents){
            if (c.possesseurPartisan == indiceJoueur){ 
                nbPartisanJoueurQuiJoue ++;
            }
        }
        return nbPartisanJoueurQuiJoue;
    }
}
