import java.util.ArrayList;

public class Table {
    // attributs
    private final ArrayList<Joueur> joueurs;

    // constructeur
    public Table(int nbJoueurs, String typeJeu){
        this.joueurs = new ArrayList<>();
        if (typeJeu.equals("d")) {
            // pour chaque joueur
            for (int i = 0; i < nbJoueurs; i++) {
                // on l'ajoute à la liste de joueur avec un nom vide le temps que
                // l'utilisateur donne un vrai nom
                // type vide
                this.joueurs.add(new Joueur(""));
            }
        }
        else if (typeJeu.equals("c")){
            // pour chaque joueur
            for (int i = 0; i < nbJoueurs; i++) {
                // on l'ajoute à la liste de joueur avec un nom vide le temps que
                // l'utilisateur donne un vrai nom
                // type vide
                this.joueurs.add(new JoueurCarcassonne(""));
                if(i==0) {
                    ((JoueurCarcassonne) (this.joueurs.get(i))).setCouleur("#000");
                }
                if(i==1){
                    ((JoueurCarcassonne) (this.joueurs.get(i))).setCouleur("#ff0000");
                }
                if(i==2){
                    ((JoueurCarcassonne) (this.joueurs.get(i))).setCouleur("#ffff00");
                }
                if(i==3){
                    ((JoueurCarcassonne) (this.joueurs.get(i))).setCouleur("#00ff00");
                }
                if(i==4){
                    ((JoueurCarcassonne) (this.joueurs.get(i))).setCouleur("#0000ff");
                }
                if(i==5){
                    ((JoueurCarcassonne) (this.joueurs.get(i))).setCouleur("#ff00ff");
                }
            }
        }
    }

    // tous les getteurs nécessaires
    public ArrayList<Joueur> getJoueurs(){
        return this.joueurs;
    }
    public int getNbJoueurs(){
        return this.joueurs.size();
    }

    // méthode pour initialiser une table de joueurs au début de la partie
    public void creationTable(int nbJoueurs, Parametres parametres){
        // pour chaque joueur
        for (int i = 0; i < nbJoueurs; i++){
            // on demande quel doit être son type (entre humain et ordinateur)
            System.out.print("Concernant le joueur numéro "+(i+1)+", ");
            String adv = parametres.typeAdversaire();
            // tant que la réponse n'est pas satisfaisante, on redemande
            while(!(adv.equals("o") || adv.equals("h"))){
                System.out.print("Concernant le joueur numéro "+(i+1)+", ");
                adv = parametres.typeAdversaire();
            }
            // si le joueur est un ordinateur
            if (adv.equals("o")){
                // on donne le nom "ordinateurI" au joueur
                this.joueurs.get(i).setNom("ordinateur".concat(String.valueOf(i+1)));
                this.joueurs.get(i).setType("o");
            }
            // si le joueur est un humain
            else {
                // on lui demande son nom pour le donner au joueur
                this.joueurs.get(i).setNom(parametres.demandeNomJoueur());
                this.joueurs.get(i).setType("h");
            }
        }
    }

    public String toString(){
        /* affiche la table sous la forme :
        Joueur 1 : ordinateur 1
        Joueur 2 : Jean
        Joueur 3 : Marie
        Joueur 4 : ordinateur4
         */
        StringBuilder tablee = new StringBuilder();
        for(int i = 0 ; i < this.getNbJoueurs() ; i++){
            tablee.append("Joueur ").append(i + 1).append(" : ").append(joueurs.get(i).getNom()).append("\n");
        }
        return tablee.toString();
    }
}