import java.util.Scanner;

public class JoueurCarcassonne extends Joueur {
    // attributs
    public int nbPartisans;
    private Tuile tuilePosee;

    // constructeur
    public JoueurCarcassonne(String nom){
        super(nom);
        this.nbPartisans = 7;
    }
    // getters nécessaires
    public int getNbPartisans(){
        return this.nbPartisans;
    }

    public Tuile getTuile(){
        return this.tuilePosee;
    }

    public void setTuile(Tuile t){
        this.tuilePosee = t;
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Souhaitez-vous placer un de vos partisans sur cette tuile? Entrez 'o' pour oui ou 'n' pour non. (format : o)");
        String rep = sc.nextLine();
        // Si le joueur souhaite placer un partisan sur la tuile jouée:
        if (rep.equals("o")){
            // son nombre de partisans diminue de 1
            this.nbPartisans -= 1;
            // la tuile concernée reçoit un partisan (ainsi qu'une trace du joueur qui l'a placé, càd son indice)
            lieu.ajouterPartisan(this); // TODO pas sûre que ça marche
            System.out.println("Nombre de partisan(s) restant(s): " + nbPartisans + "\n");
            // ajoute joueur à liste des possesseurs
            t.getPossesseursPartisans().add(this);
            // ajoute lieu à liste des lieux qui ont un partisan
            t.getPartisansPoses().add(lieu);
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