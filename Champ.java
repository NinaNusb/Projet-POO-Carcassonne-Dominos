import java.util.LinkedList;

public class Champ extends TuileCarcassonne{
    private LinkedList<Champ> parcelles = new LinkedList<Champ>();
    static int points; 
    
    public Champ(int[] h, int[] d, int[] b, int[] g, boolean partisan, int i){
        super(h, d, b, g, partisan, i);
        Champ.points = parcelles.size();
    }

    @Override
    public boolean estTerminee(){
        if (Jeu.jeuFini(null) || /*si les tuiles adjacentes sont des villes ou des routes*/){ // TODO: table = null ??
            return true;
        }
    }

    // Renvoie le nombre de partisans placés sur un ensemble de tuiles de même type
    public int partisansEnJeu(JoueurCarcassonne j){
        int nbPartisanEnJeu = 0;
        for (Champ c : parcelles){
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
        for (Champ c: parcelles){
            if (c.possesseurPartisan == indiceJoueur){ 
                nbPartisanJoueurQuiJoue ++;
            }
        }
        return nbPartisanJoueurQuiJoue;
    }
}
