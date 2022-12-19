import java.io.File;
import java.util.ArrayList;

public class Plateau{
    // attributs
    protected final ArrayList<ArrayList<Emplacement>> plateau;
    protected final ArrayList<ArrayList<Integer>> matriceAdjacence;

    // constructeur
    public Plateau(Sac sac){

        this.plateau = new ArrayList<>();
        this.plateau.add(new ArrayList<>());
        this.plateau.get(0).add(new Emplacement());

        // la matrice d'adjacente est une matrice de la taille du plateau
        this.matriceAdjacence = new ArrayList<>();
        this.matriceAdjacence.add(new ArrayList<>());
        this.matriceAdjacence.get(0).add(-1);

        // dans le cas où on joue au domino
        if (sac instanceof SacDomino) {
            // on pioche la tuile de départ au hasard et on pose au milieu du plateau
            this.ajouterTuile(this.plateau.get(0).get(0), sac.piocheTuile());
        }
        // dans le cas où on joue à Carcassonne
        else {
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
    }

    // tous les getteurs nécessaires
    public ArrayList<ArrayList<Emplacement>> getPlateau(){
        return this.plateau;
    }

    // méthode pour ajouter une tuile au plateau
    public void ajouterTuile(Emplacement e, Tuile t) {
        // on enregistre les dimensions du plateau d'origine (son nombre de lignes et son nombre de colonnes)
        int[] dimensionOrigine = new int[2];
        dimensionOrigine[0] = this.plateau.size() - 1;
        dimensionOrigine[1] = this.plateau.get(0).size() - 1;
        // on pose la tuile sur l'emplacement indiqué
        this.plateau.get(e.getX()).get(e.getY()).setTuile(t);
        this.matriceAdjacence.get(e.getX()).set(e.getY(), -1);
        // on agrandit le tableau en conséquence
        this.agrandissementPlateau(e, dimensionOrigine);
    }

    // méthode pour agrandir le tableau lorsque les bords ont été atteints par la nouvelle tuile posée
    private void agrandissementPlateau(Emplacement e, int[] dimensionOrigine){

        // si la tuile est posée sur la première ligne
        if(e.getX() == 0){
            // on crée une nouvelle ligne au début du plateau
            this.plateau.add(0, new ArrayList<>(this.plateau.size()));
            this.matriceAdjacence.add(0, new ArrayList<>(this.matriceAdjacence.size()));
            // on crée autant d'emplacements que nécessaire dans cette nouvelle ligne
            for (int i = 0 ; i < this.plateau.get(1).size(); i++){
                this.plateau.get(0).add(new Emplacement());
                this.matriceAdjacence.get(0).add(0);
            }
        }
        // si la tuile est posée sur la dernière ligne
        if(e.getX() == dimensionOrigine[0]){
            // on crée une nouvelle ligne à la fin du plateau
            this.plateau.add(this.plateau.size(), new ArrayList<>(this.plateau.size()));
            this.matriceAdjacence.add(this.matriceAdjacence.size(), new ArrayList<>(this.matriceAdjacence.size()));
            // on crée autant d'emplacements que nécessaire dans cette nouvelle ligne
            for (int i = 0 ; i < this.plateau.get(0).size(); i++){
                this.plateau.get(this.plateau.size()-1).add(new Emplacement());
                this.matriceAdjacence.get(this.matriceAdjacence.size()-1).add(0);
            }
        }
        // si la tuile est posée sur la première colonne
        if (e.getY() == 0){
            // pour chaque ligne du plateau
            for (int i = 0 ; i < this.plateau.size() ; i++){
                // on crée un nouvel emplacement en début de ligne
                this.plateau.get(i).add(0, new Emplacement());
                this.matriceAdjacence.get(i).add(0, 0);
            }
        }
        // si la tuile est posée sur la dernière colonne
        if (e.getY() == dimensionOrigine[1]){
            // pour chaque ligne du plateau
            for (int i = 0 ; i < this.plateau.size() ; i++){
                // on crée un nouvel emplacement en fin de ligne
                this.plateau.get(i).add(this.plateau.get(0).size()-1, new Emplacement());
                this.matriceAdjacence.get(i).add(this.matriceAdjacence.get(0).size()-1, 0);
            }
        }

        // la matrice adjacente doit être adaptée à son tour
        // pour chaque case de la matrice adjacente
        for (int i = 0; i < this.matriceAdjacence.size(); i++){
            for (int j = 0 ; j < this.matriceAdjacence.get(0).size() ; j++){
                // si cette case ne présente pas de tuile
                if (this.matriceAdjacence.get(i).get(j) != -1) {
                    // on initialise son nombre de tuile adjacente à 0
                    this.matriceAdjacence.get(i).set(j, 0);
                    // s'il y une case en dessous
                    if ((i+1) < this.matriceAdjacence.size()) {
                        // si cette case présente une tuile
                        if (this.matriceAdjacence.get(i + 1).get(j) == -1) {
                            // on incrémente le nombre de tuiles adjacentes
                            this.matriceAdjacence.get(i).set(j, this.matriceAdjacence.get(i).get(j) + 1);
                        }
                    }
                    // s'il y une case au dessus
                    if ((i-1) > 0) {
                        // si cette case présente une tuile
                        if (this.matriceAdjacence.get(i - 1).get(j) == -1) {
                            // on incrémente le nombre de tuiles adjacentes
                            this.matriceAdjacence.get(i).set(j, this.matriceAdjacence.get(i).get(j) + 1);
                        }
                    }
                    // s'il y une case à sa droite
                    if ((j+1) < this.matriceAdjacence.get(0).size()) {
                        // si cette case présente une tuile
                        if (this.matriceAdjacence.get(i).get(j + 1) == -1) {
                            // on incrémente le nombre de tuiles adjacentes
                            this.matriceAdjacence.get(i).set(j, this.matriceAdjacence.get(i).get(j) + 1);
                        }
                    }
                    // s'il y une case à sa gauche
                    if ((j-1) > 0) {
                        // si cette case présente une tuile
                        if (this.matriceAdjacence.get(i).get(j - 1) == -1) {
                            // on incrémente le nombre de tuiles adjacentes
                            this.matriceAdjacence.get(i).set(j, this.matriceAdjacence.get(i).get(j) + 1);
                        }
                    }
                }
            }
        }
    }

    // méthode qui renvoie la liste de tous les emplacements du plateau sur lesquels on peut jouer la tuile
    public ArrayList<Emplacement> emplacementsLibres(){
        ArrayList<Emplacement> emplacementsLibres = new ArrayList<>();
        // pour chaque case du plateau
        for (int i = 0 ; i < this.matriceAdjacence.size() ; i++){
            for (int j = 0 ; j < this.matriceAdjacence.get(0).size() ; j++){
                // s'il y a au moins une tuile adjacente
                if(this.matriceAdjacence.get(i).get(j) >= 1){
                    // on ajoute l'emplacement à la liste
                    emplacementsLibres.add(new Emplacement(i,j));
                }
            }
        }
        return emplacementsLibres;
    }

    // affichage du plateau
    public void affiche(){
        /* la fonction toString de Tuile ne peut pas être appelée car les tuiles apparaîtraient les unes sous les autres
        alors qu'on veut visualiser le plateau en longueur et en hauteur.

        Le plateau s'affiche sous cette forme :
          _ _ _ _ _    _ _ _ _ _
         |  1 2 3  |  |  4 5 6  |
         |1       4|  |4       0|
         |2       5|  |5       0|
         |3       6|  |6       0|
         |  0 2 4  |  |  1 3 5  |
          _ _ _ _ _    _ _ _ _ _
          _ _ _ _ _
         |  0 2 4  |
         |0       0|
         |1       1|
         |2       2|
         |  2 3 4  |
          _ _ _ _ _
        */

        // petit décalage pour pouvoir afficher les chiffres sur la hauteur du plateau
        System.out.print("  ");
        // pour chaque colonne du plateau, on affiche une lettre
        for(int i = 0; i < this.plateau.get(0).size(); i++) {
            System.out.print("     " + (char)(i+65) + "     ");
        }
        System.out.println();
        // pour chaque ligne du plateau
        for(int i = 0; i < this.plateau.size(); i++) {
            // on affiche la bordure horizontale des tuiles
            bordureHorizontale(i);
            // petit décalage pour pouvoir afficher les chiffres sur la hauteur du plateau
            System.out.print("  ");
            // pour chaque case du plateau
            for (int j = 0; j < this.plateau.get(0).size(); j++) {
                // s'il n'y a pas de tuile, on laisse un espace libre
                if (this.plateau.get(i).get(j).estVide()){
                    System.out.print("           ");
                }
                // sinon on affiche le haut de la tuile correspondante
                else {
                    System.out.print("|  " + this.plateau.get(i).get(j).getTuile().getHaut()[0]+" "+ this.plateau.get(i).get(j).getTuile().getHaut()[1]+" "+this.plateau.get(i).get(j).getTuile().getHaut()[2]+"  |");
                }
            }
            System.out.println();
            // petit décalage pour pouvoir afficher les chiffres sur la hauteur du plateau
            System.out.print("  ");
            // pour chaque case du plateau
            for (int j = 0; j < this.plateau.get(0).size(); j++) {
                // s'il n'y a pas de tuile, on laisse un espace libre
                if (this.plateau.get(i).get(j).estVide()){
                    System.out.print("           ");
                }
                // sinon on affiche la ligne de la tuile correspondante
                else {
                    System.out.print("|"+this.plateau.get(i).get(j).getTuile().getGauche()[2]+"       "+this.plateau.get(i).get(j).getTuile().getDroite()[0]+"|");
                }
            }
            System.out.println();
            // affichage du chiffre correspondant à l'ordonnée des emplacements
            if (i+1 < 10) {
                System.out.print((i + 1) + " ");
            }
            else {
                System.out.print(i + 1);
            }
            // pour chaque case du plateau
            for (int j = 0; j < this.plateau.get(0).size(); j++) {
                // s'il n'y a pas de tuile, on laisse un espace libre
                if (this.plateau.get(i).get(j).estVide()){
                    System.out.print("           ");
                }
                // sinon on affiche la ligne de la tuile correspondante
                else {
                    System.out.print("|"+this.plateau.get(i).get(j).getTuile().getGauche()[1]+"       "+this.plateau.get(i).get(j).getTuile().getDroite()[1]+"|");
                }
            }
            System.out.println();
            // petit décalage pour pouvoir afficher les chiffres sur la hauteur du plateau
            System.out.print("  ");
            // pour chaque case du plateau
            for (int j = 0; j < this.plateau.get(0).size(); j++) {
                // s'il n'y a pas de tuile, on laisse un espace libre
                if (this.plateau.get(i).get(j).estVide()){
                    System.out.print("           ");
                }
                // sinon on affiche la ligne de la tuile correspondante
                else {
                    System.out.print("|"+this.plateau.get(i).get(j).getTuile().getGauche()[0]+"       "+this.plateau.get(i).get(j).getTuile().getDroite()[2]+"|");
                }
            }
            System.out.println();
            // petit décalage pour pouvoir afficher les chiffres sur la hauteur du plateau
            System.out.print("  ");
            // pour chaque case du plateau
            for (int j = 0; j < this.plateau.get(0).size(); j++) {
                // s'il n'y a pas de tuile, on laisse un espace libre
                if (this.plateau.get(i).get(j).estVide()){
                    System.out.print("           ");
                }
                // sinon on affiche le bas de la tuile correspondante
                else {
                    System.out.print("|  " +this.plateau.get(i).get(j).getTuile().getBas()[2]+" "+this.plateau.get(i).get(j).getTuile().getBas()[1]+" "+this.plateau.get(i).get(j).getTuile().getBas()[0]+"  |");
                }
            }
            System.out.println();
            // on affiche la bordure horizontale des tuiles
            bordureHorizontale(i);
        }
    }

    // méthode pour afficher les bordures horizontales
    private void bordureHorizontale(int i) {
        // petit décalage pour pouvoir afficher les chiffres sur la hauteur du plateau
        System.out.print("  ");
        // pour chaque colonne du plateau
        for (int j = 0; j < this.plateau.get(0).size(); j++) {
            // s'il n'y a pas de tuile, on laisse un espace libre
            if (this.plateau.get(i).get(j).estVide()){
                System.out.print("           ");
            }
            // sinon on affiche la bordure horizontale
            else {
                System.out.print(" _ _ _ _ _ ");
            }
        }
        System.out.println();
    }
}