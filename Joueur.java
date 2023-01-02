import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    // attributs
    private Tuile tuileEnMain;
    private String nom;
    private String type;
    private int nbPoints;
    private final Scanner sc = new Scanner(System.in);

    // constructeur
    public Joueur(String nom){
        this.nom = nom;
        this.nbPoints = 0;
    }

    // tous les getters nécessaires
    public Tuile getTuileEnMain(){
        return this.tuileEnMain;
    }
    public String getNom(){
        return this.nom;
    }
    public String getType(){
        return this.type;
    }
    public int getNbPoints(){
        return this.nbPoints;
    }
    // tous les setters nécessaires
    public void setTuileEnMain(Tuile tuile){
        this.tuileEnMain = tuile;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setType(String type){
        this.type = type;
    }

    public String toString(){
        /* affiche le joueur sous la forme :
        Jean a en main la tuile
         _ _ _ _ _
        |  0 2 2  |
        |1       2|
        |0       0|
        |4       0|
        |  1 4 2  |
         _ _ _ _ _
         */
        return nom + " a en main la tuile :\n" + tuileEnMain;
    }

    // méthode pour piocher une tuile dans le sac
    public void pioche(Sac sac){
        // le joueur pioche une tuile dans le sac
        this.tuileEnMain = sac.piocheTuile();
    }

    // méthode pour que le joueur humain choisisse un emplacement où placer sa tuile
    public int[] choixEmplacement(Plateau p){ // TODO : est-ce la bonne classe où la mettre ? on utilise jamais Joueur
        int[] coordonnees = new int[2];
        boolean emplacementValide = false;
        // tant que l'emplacement choisi n'est pas valide
        while (!emplacementValide){
            // on demande à l'utilisateur de donner les coordonnées où il veut placer sa tuile
            System.out.println("Dans quel emplacement voulez-vous placer votre tuile ? (format : A2)");
            String emplacementChoisi = sc.nextLine();
            // conversion des coordonnées de plateau en coordonnées numériques
            String x = "";
            char y = ' ';
            for(char c : emplacementChoisi.toCharArray()){
                if (Character.isDigit(c)){
                    x = x + c;
                }
                else {
                    y = c;
                }
            }
            // si les coordonnées sont compatibles avec celles des emplacements
            try {
                Emplacement emplacementConverti = new Emplacement(Integer.parseInt(x) - 1, (int) y - 65);
                ArrayList<Emplacement> emplacementsLibres = p.emplacementsLibres();
                boolean emplacementLibreTrouve = false;
                // pour chaque emplacement libre
                for (Emplacement e : emplacementsLibres){
                    // si cet emplacement a les mêmes coordonnées que celles choisies
                    if (e.getX() == emplacementConverti.getX() && e.getY() == emplacementConverti.getY()) {
                        // alors l'emplacement choisi et libre et la tuile peut y être jouer
                        emplacementLibreTrouve = true;
                        break;
                    }
                }
                // si un emplacement libre est choisi
                if (emplacementLibreTrouve){
                    // cela signifie que l'emplacement choisi est valide
                    emplacementValide = true;
                    // les coordonnées sont enregistrées pour être renvoyées
                    coordonnees[0] = Integer.parseInt(x)-1;
                    coordonnees[1] = (int)y-65;
                }
                else {
                    System.out.println("L'emplacement choisi est invalide. Choisissez-en un autre.");
                }
            }
            // si elles ne sont pas compatibles
            catch(NumberFormatException e){
                // on demande à l'utilisateur de choisir une nouvelle fois un emplacement
                System.out.println("L'emplacement choisi est invalide. Choisissez-en un autre.");
                choixEmplacement(p);
            }
        }
        return coordonnees;
    }

    // méthode pour défausser la tuile en main
    public void defausse(){
        this.tuileEnMain = null;
    }

    // méthode pour que l'utilisateur humain choisisse l'action qu'il souhaite effectuer
    public String choixAction(){
        // Choix de l'action
        System.out.println("Indiquez si vous souhaitez placer (entrez p), défausser (entrez d) la tuile ou abandonner (entrez a) : (format : p)\nVous pouvez également la tourner (entrez t) avant de prendre votre décision.");
        String action = sc.nextLine();
        // tant que l'action n'est pas compatible avec ce qu'on attend de lui
        while (!(action.equals("p") || action.equals("d") || action.equals("t") || action.equals("a"))) {
            // la question lui est reposée
            System.out.println("L'action choisie est invalide. Choisissez-en une autre.");
            System.out.println("Indiquez si vous souhaitez placer (entrez p) ou défausser (entrez d) la tuile: (format : p)\nVous pouvez également la tourner (entrez t) avant de prendre votre décision.");
            action = sc.nextLine();
        }
        return action;
    }

    // méthode qui compte les points gagnés une fois la tuile posée
    public void gagnePoints(Emplacement e, Plateau p){
        // si l'emplacement sur lequel la tuile est jouée est la première ligne ou la première colonne, on doit décaler
        // l'emplacement d'une case car la plateau a entre temps été agrandi d'une case
        if (e.getY() == 0){
            gagnePoints(new Emplacement(e.getX(), e.getY()+1), p);
        }
        else if (e.getX() == 0){
            gagnePoints(new Emplacement(e.getX()+1, e.getY()), p);
        }

        else {
            int nbPoints = 0;
            // s'il y a une tuile au dessus de la tuile posée
            if (!p.getPlateau().get(e.getX() - 1).get(e.getY()).estVide()) {
                // on ajoute les points de chacun des int correspondant au bas de la tuile déjà présente
                for (Object pt : p.getPlateau().get(e.getX() - 1).get(e.getY()).getTuile().getBas()) {
                    nbPoints += (int)pt;
                }
            }
            // s'il y a une tuile en dessous de la tuile posée
            if (!p.getPlateau().get(e.getX()).get(e.getY() + 1).estVide()) {
                // on ajoute les points de chacun des int correspondant à la gauche de la tuile déjà présente
                for (Object pt : p.getPlateau().get(e.getX()).get(e.getY() + 1).getTuile().getGauche()) {
                    nbPoints += (int)pt;
                }
            }
            // s'il y a une tuile à droite de la tuile posée
            if (!p.getPlateau().get(e.getX() + 1).get(e.getY()).estVide()) {
                // on ajoute les points de chacun des int correspondant au haut de la tuile déjà présente
                for (Object pt : p.getPlateau().get(e.getX() + 1).get(e.getY()).getTuile().getHaut()) {
                    nbPoints += (int)pt;
                }
            }
            // s'il y a une tuile à gauche de la tuile posée
            if (!p.getPlateau().get(e.getX()).get(e.getY() - 1).estVide()) {
                // on ajoute les points de chacun des int correspondant à la droite de la tuile déjà présente
                for (Object pt : p.getPlateau().get(e.getX()).get(e.getY() - 1).getTuile().getDroite()) {
                    nbPoints += (int)pt;
                }
            }
            // affichage du nombre de points gagnés à ce tour
            System.out.println(this.nom + " a gagné " + nbPoints + " points.\n");
            this.nbPoints += nbPoints;
        }
    }
}

