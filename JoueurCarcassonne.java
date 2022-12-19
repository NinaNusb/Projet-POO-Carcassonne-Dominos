public class JoueurCarcassonne extends Joueur{
    public int nbPartisans;
    TuileCarcassonne tuileEnMain;
    int joueurQuiJoue; //TODO: pertinent ici?

    public JoueurCarcassonne(String nom){
        super(nom);
        this.nbPartisans = 7;
    }
    
    public Tuile getTuileEnMain(){
        return this.tuileEnMain;
    }

    public boolean placePartisan(TuileCarcassonne t, Lieu lieu){
        // Affiche le nombre de partisans que le joueur peut placer
        System.out.println("Le nombre de vos partisan(s) restant(s) est: " + nbPartisans + "\n");
        // Gestion du cas où le joueur n'a plus de partisan
        if (nbPartisans == 0){
            System.out.println("Vous ne pouvez pas placer de partisan.");
            return false;
        }
        // Demande d'action quand le joueur a des partisans à disposition
        System.out.println("Souhaitez-vous placer un de vos partisans sur cette tuile? Entrez 'o' pour oui ou 'n' pour non. (format : o)");
        String rep = sc.nextLine();
        // Si le joueur souhaite placer un partisan sur la tuile jouée:
        if (rep.equals("o")){
            // son nombre de partisans diminue de 1
            this.nbPartisans -= 1;
            // la tuile concernée reçoit un partisan (ainsi qu'une trace du joueur qui l'a placé, càd son indice)
            ((TuileCarcassonne)t).ajouterPartisan(lieu, this);
            System.out.println("Nombre de partisan(s) restant(s): " + nbPartisans + "\n");
            return true;
        }
        return false;
    }

    // public void recuperePartisan(TuileCarcassonne t){
    //     // Si un élément du plateau est terminé suite à l'ajout d'une tuile, le joueur récupère ses partisans en jeu
    //     if (t.estTerminee()){
    //         for (TuileCarcassonne t : ){
    //             nbPartisans += t.retirerPartisan(t.haut[1]);
    //             nbPartisans += t.retirerPartisan(t.droite[1]);
    //             nbPartisans += t.retirerPartisan(t.bas[1]);
    //             nbPartisans += t.retirerPartisan(t.gauche[1]);
    //         }
            
    //     }
    // }
}
