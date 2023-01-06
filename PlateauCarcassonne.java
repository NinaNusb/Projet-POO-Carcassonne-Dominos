import java.io.File;

public class PlateauCarcassonne extends Plateau {

    // constructeur
    public PlateauCarcassonne(){
        super();
        // on définit la tuile de départ qui est toujours la même
        Lieu[] haut = new Lieu[3];
        Lieu[] droite = new Lieu[3];
        Lieu[] bas = new Lieu[3];
        Lieu[] gauche = new Lieu[3];
        haut[0] = new Ville();
        haut[1] = new Ville();
        haut[2] = new Ville();
        droite[0] = new Champ();
        droite[1] = new Route();
        droite[2] = new Champ();
        bas[0] = new Champ();
        bas[1] = new Champ();
        bas[2] = new Champ();
        gauche[0] = new Champ();
        gauche[1] = new Route();
        gauche[2] = new Champ();
        this.ajouterTuile(this.plateau.get(0).get(0), new TuileCarcassonne(haut, droite, bas, gauche, new File("C:/Users/carol/IdeaProjects/Carcassonne V2/src/Image tuile/Base_Game_C2_Tile_Z.jpg"), false));
    }

    public void ajouterTuile(Emplacement e, TuileCarcassonne t, Joueur j){
        super.ajouterTuile(e, t);
    }
}