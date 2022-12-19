import java.io.File;

public class PlateauCarcassonne extends Plateau{
    
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

    @Override
    public void ajouterTuile(Emplacement e, Tuile t){
        super.ajouterTuile(e, t); // TODO: appel méthode Plateau et non PlateauCarcassonne
        // Vérif si il y a une tuile adjacente en haut
        if (!this.plateau.get(e.getX() +1).get(e.getY()).estVide()){
            // On copie le numéro
            t.getHaut()[1].numeroUnique = this.plateau.get(e.getX() +1).get(e.getY()).getTuile().getBas()[1].numeroUnique;
        } else {
            t.getHaut()[1].numeroUnique = genID.getAndIncrement(); 
        }
        // Vérif si il y a une tuile adjacente à droite
        if (!this.plateau.get(e.getX()).get(e.getY()+1).estVide()){
            // On copie le numéro
            t.getDroite()[1].numeroUnique = this.plateau.get(e.getX()).get(e.getY()+1).getTuile().getGauche()[1].numeroUnique;
        } else {
            t.getDroite()[1].numeroUnique = genID.getAndIncrement(); 
        }
        // Vérif si il y a une tuile adjacente en bas
        if (!this.plateau.get(e.getX() -1).get(e.getY()).estVide()){
            // On copie le numéro
            t.getBas()[1].numeroUnique = this.plateau.get(e.getX() -1).get(e.getY()).getTuile().getHaut()[1].numeroUnique;
        } else {
            t.getBas()[1].numeroUnique = genID.getAndIncrement(); 
        }
        // Vérif si il y a une tuile adjacente en haut à gauche
        if (!this.plateau.get(e.getX()).get(e.getY()-1).estVide()){
            // On copie le numéro
            t.getGauche()[1].numeroUnique = this.plateau.get(e.getX()).get(e.getY()-1).getTuile().getDroite()[1].numeroUnique;
        } else {
            t.getGauche()[1].numeroUnique = genID.getAndIncrement(); 
        }

        t.ajouterPartisan(lieu);
    }
}

