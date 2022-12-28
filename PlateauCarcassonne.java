import java.io.File;

public class PlateauCarcassonne extends Plateau {

    public PlateauCarcassonne(SacCarcassonne sac){
        super(sac);
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
/*        // Vérif s'il y a une tuile adjacente en haut
        if (!this.plateau.get(e.getX() +1).get(e.getY()).estVide()){
            // On copie le numéro
            ((Lieu)t.getBas()[1]).setNumeroUnique(((Lieu)this.plateau.get(e.getX() +1).get(e.getY()).getTuile().getBas()[1]).getNumeroUnique());
        } else {
            ((Lieu)t.getHaut()[1]).setNumeroUnique(Lieu.genID.getAndIncrement());
        }
        // Vérif s'il y a une tuile adjacente à droite
        if (!this.plateau.get(e.getX()).get(e.getY()+1).estVide()){
            // On copie le numéro
            ((Lieu)t.getDroite()[1]).setNumeroUnique(((Lieu)this.plateau.get(e.getX()).get(e.getY()+1).getTuile().getGauche()[1]).getNumeroUnique());
        } else {
            ((Lieu)t.getDroite()[1]).setNumeroUnique(Lieu.genID.getAndIncrement());
        }
        // Vérif s'il y a une tuile adjacente en bas
        if (!this.plateau.get(e.getX() -1).get(e.getY()).estVide()){
            // On copie le numéro
            ((Lieu)t.getBas()[1]).setNumeroUnique(((Lieu)this.plateau.get(e.getX() -1).get(e.getY()).getTuile().getHaut()[1]).getNumeroUnique());
        } else {
            ((Lieu)t.getBas()[1]).setNumeroUnique(Lieu.genID.getAndIncrement());
        }
        // Vérif s'il y a une tuile adjacente en haut à gauche
        if (!this.plateau.get(e.getX()).get(e.getY()-1).estVide()){
            // On copie le numéro
            ((Lieu)t.getGauche()[1]).setNumeroUnique(((Lieu)this.plateau.get(e.getX()).get(e.getY()-1).getTuile().getDroite()[1]).getNumeroUnique());
        } else {
            ((Lieu)t.getGauche()[1]).setNumeroUnique(Lieu.genID.getAndIncrement());
        }

        // on ne peut pas poser de partisan sur un champ, seulement sur une ville, une route ou une abbaye
        ((Lieu)t.getHaut()[1]).ajouterPartisan(j);
        if(!t.getDroite()[1].getClass().equals(t.getHaut()[1].getClass())){
            ((Lieu)t.getDroite()[1]).ajouterPartisan(j);
        }
        if(!t.getBas()[1].getClass().equals(t.getDroite()[1].getClass()) && (!t.getBas()[1].getClass().equals(t.getHaut()[1].getClass()) || (t.getBas()[1].getClass().equals(t.getHaut()[1].getClass()) && t.getGauche()[1] instanceof Ville && t.getDroite()[1] instanceof Ville))){
            ((Lieu)t.getBas()[1]).ajouterPartisan(j);
        }
        if(!t.getGauche()[1].getClass().equals(t.getHaut()[1].getClass()) && !t.getGauche()[1].getClass().equals(t.getBas()[1].getClass()) && (!t.getGauche()[1].getClass().equals(t.getDroite()[1].getClass()) || (t.getGauche()[1].getClass().equals(t.getDroite()[1].getClass()) && t.getHaut()[1] instanceof Ville && t.getBas()[1] instanceof Ville))){
            ((Lieu)t.getGauche()[1]).ajouterPartisan(j);
        }

        */
    }
}
