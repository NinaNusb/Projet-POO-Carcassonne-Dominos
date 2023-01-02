public class PlateauDomino extends Plateau{

    // constructeur
    public PlateauDomino(SacDomino sac){
        super(sac);
        // on pioche la tuile de départ au hasard et on pose au milieu du plateau
        this.ajouterTuile(this.plateau.get(0).get(0), sac.piocheTuile());
    }
}
