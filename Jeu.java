import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Jeu {
    // attributs
    private Joueur joueurQuiJoue;
    private Sac sac;
    private Plateau p;
    private boolean jeuFini;
    private int nbTour;
    private Parametres parametres;

    // constructeur
    public Jeu(){
        this.nbTour = 0;
    }

    // getters et setters nécessaires
    public Plateau getP(){
        return this.p;
    }
    public Joueur getJoueurQuiJoue(){
        return this.joueurQuiJoue;
    }
    public Sac getSac(){
        return this.sac;
    }
    public int getNbTour(){
        return this.nbTour;
    }
    public Parametres getParametres(){
        return this.parametres;
    }
    public void setJoueurQuiJoue(Joueur j){
        this.joueurQuiJoue = j;
    }
    public void setNbTour(int x){
        this.nbTour = x;
    }
    public void setParametres(Parametres parametres){
        this.parametres = parametres;
    }

    // méthode qui fait jouer le joueur humain ou ordinateur
    public void jouerTour(String typeJeu) throws IOException {
        // le joueur pioche une tuile au hasard
        this.joueurQuiJoue.pioche(sac);
        // affichage de la tuile et du plateau pour avoir un visuel
        System.out.println(this.joueurQuiJoue);
        System.out.println("Voici le plateau :");
        this.p.affiche();

        // si on joue à Carcassonne
        if (typeJeu.equals("c")){
            // on lance l'interface graphique
            new CarcassonneGraphique(this);
            this.jeuFini = true;
        }
        // si on joue à domino
        else {
            // et qu'on a choisi de jouer en terminal
            if (this.getParametres().getModeDeJeu().equals("t")) {
                // redirection de l'action suivant le type joueur
                if (this.joueurQuiJoue.getType().equals("o")) {
                    this.jouerIA();
                } else {
                    this.jouerHumain();
                }
            }
            // et qu'on a choisi de jouer en interface graphique
            else {
                // on lance l'interface graphique
                new DominoGraphique(this);
                this.jeuFini = true;
            }
        }
    }

    // méthode qui fait jouer le joueur humain
    public void jouerHumain() {
        boolean emplacementPossible = false;
        // Pour chaque emplacement dans la liste des emplacements libres
        for (Emplacement emplacementLibre : this.p.emplacementsLibres()) {
            // on vérifie que le joueur peut jouer sa tuile
            if (emplacementOuJouer(emplacementLibre, false)) {
                emplacementPossible = true;
            }
        }
        // s'il ne peut pas jouer sa tuile
        if (!emplacementPossible){
            // on la défausse automatiquement
            System.out.println("Il n'y a pas d'emplacement valide pour jouer cette tuile. Vous la défaussez automatiquement.");
            this.joueurQuiJoue.defausse();
            return;
        }
        // on demande quelle action il veut faire
        String action = this.joueurQuiJoue.choixAction();
        switch (action){
            // s'il veut abandonner la partie
            case "a":
                System.out.println(this.joueurQuiJoue.getNom() + " a abandonné.");
                // on termine le jeu
                this.jeuFini = true;
    
            // s'il veut défausser sa tuile
            case "d" :
                System.out.println("Vous avez choisi de défausser votre tuile.\n");
                // il la défausse
                this.joueurQuiJoue.defausse();
            
            // s'il veut la tourner
            case "t":
                // on la tourne
                this.joueurQuiJoue.getTuileEnMain().tourner();
                System.out.println(this.joueurQuiJoue.getTuileEnMain());
                // puis on recommence son tour de jeu avec la tuile tournée
                this.jouerHumain();
            
            // s'il veut la placer
            default:
                // on enregistre les coordonnées de l'emplacement sur lequel le joueur veut jouer
                int[] coordonnees = this.joueurQuiJoue.choixEmplacement(p);
                // tant qu'on ne peut pas jouer à cet emplacement
                while (!emplacementOuJouer(new Emplacement(coordonnees[0], coordonnees[1]), true)) {
                    // on lui redemande de choisir
                    System.out.println("Votre tuile ne peut pas être placée là. Choisissez un autre emplacement.");
                    coordonnees = this.joueurQuiJoue.choixEmplacement(p);
                }
        }
    
    }

    private int pointsPotentiels(Emplacement e){
        int nbPoints = 0;
        // si on ne dépasse pas des bordures du plateau
        if(e.getX() - 1 >= 0) {
            // s'il y a une tuile au-dessus de la tuile posée
            if (!p.getPlateau().get(e.getX() - 1).get(e.getY()).estVide()) {
                // on ajoute les points de chacun des int correspondant au bas de la tuile déjà présente
                for (Object pt : p.getPlateau().get(e.getX() - 1).get(e.getY()).getTuile().getBas()) {
                    nbPoints += (int)pt;
                }
            }
        }
        // si on ne dépasse pas des bordures du plateau
        if(e.getY() + 1 < p.getPlateau().get(e.getX()).size()) {
            // s'il y a une tuile en dessous de la tuile posée
            if (!p.getPlateau().get(e.getX()).get(e.getY() + 1).estVide()) {
                // on ajoute les points de chacun des int correspondant à la gauche de la tuile déjà présente
                for (Object pt : p.getPlateau().get(e.getX()).get(e.getY() + 1).getTuile().getGauche()) {
                    nbPoints += (int)pt;
                }
            }
        }
        // si on ne dépasse pas des bordures du plateau
        if(e.getX() + 1 < p.getPlateau().size()) {
            // s'il y a une tuile à droite de la tuile posée
            if (!p.getPlateau().get(e.getX() + 1).get(e.getY()).estVide()) {
                // on ajoute les points de chacun des int correspondant au haut de la tuile déjà présente
                for (Object pt : p.getPlateau().get(e.getX() + 1).get(e.getY()).getTuile().getHaut()) {
                    nbPoints += (int)pt;
                }
            }
        }
        // si on ne dépasse pas des bordures du plateau
        if(e.getY() - 1 >= 0) {
            // s'il y a une tuile à gauche de la tuile posée
            if (!p.getPlateau().get(e.getX()).get(e.getY() - 1).estVide()) {
                // on ajoute les points de chacun des int correspondant à la droite de la tuile déjà présente
                for (Object pt : p.getPlateau().get(e.getX()).get(e.getY() - 1).getTuile().getDroite()) {
                    nbPoints += (int)pt;
                }
            }
        }
        return nbPoints;
    }

    // méthode pour faire jouer le joueur ordinateur
    public void jouerIA(){
        // l'ordinateur joue stratégique si on joue aux dominos
        if (this.getParametres().getTypeDeJeu().equals("d")) {
            jouerStrategique();
        }
        else {
            jouerNonStrategique();
        }

        // si on n'a pu jouer pour aucun des emplacements libres
        if(this.joueurQuiJoue.getTuileEnMain() != null){
            // alors on défausse la tuile, car il n'y a pas d'emplacement valide possible
            System.out.println("Il n'y a pas d'emplacement valide pour jouer cette tuile. Elle est défaussée.\n");
            this.joueurQuiJoue.defausse();
        }
    }
    // méthode pour jouer non stratégique avec l'ordinateur
    private void jouerNonStrategique() {
        // Pour chaque emplacement dans la liste des emplacements libres
        for (Emplacement emplacementLibre : this.p.emplacementsLibres()) {
            // si on peut jouer sur cet emplacement
            if (emplacementOuJouer(emplacementLibre, false)) {
                // on y joue
                emplacementOuJouer(emplacementLibre, true);
                break;
            }
        }
    }

    // méthode pour jouer stratégique avec l'ordinateur
    private void jouerStrategique() {
        HashMap<Emplacement, Integer> nbPointsParEmplacement = new HashMap<>();
        // Pour chaque emplacement dans la liste des emplacements libres
        for (Emplacement emplacementLibre : this.p.emplacementsLibres()) {
            // si on peut jouer sur cet emplacement, on le stocke
            if (emplacementOuJouer(emplacementLibre, false)) {
                nbPointsParEmplacement.put(emplacementLibre, this.pointsPotentiels(emplacementLibre));
            }
        }

        if (nbPointsParEmplacement.size() > 0) {
            // pour jouer "stratégique", on repère quel est l'emplacement qui rapporte le plus de points
            int max = -1;
            Emplacement e = new Emplacement();
            // pour chaque entrée de la HashMap
            for (Map.Entry<Emplacement, Integer> entry : nbPointsParEmplacement.entrySet()) {
                // si on gagne plus de points à jouer à cet emplacement
                if (entry.getValue() > max) {
                    // on stocke l'emplacement et le nombre de points gagnés
                    max = entry.getValue();
                    e = entry.getKey();
                }
            }
            // on joue à l'emplacement qui rapporte le plus de points
            emplacementOuJouer(e, true);
        }
    }

    // méthode pour vérifier (et jouer selon le booléen) si une tuile peut être jouée sur un emplacement libre
    public boolean emplacementOuJouer(Emplacement emplacementLibre, boolean jouer){

        Tuile tuileBis = copieTuile(this.joueurQuiJoue.getTuileEnMain());
        int j = 0;

        // on tourne la tuile maximum quatre fois
        for (int i = 0; i < 4 ; i++) {
            j = i;
            // si une tuile est déjà présente en dessous de l'emplacement libre
            if (emplacementLibre.getX() + 1 < this.p.getPlateau().size() && !this.p.getPlateau().get(emplacementLibre.getX() + 1).get(emplacementLibre.getY()).estVide()) {
                // mais que les deux tuiles n'ont pas ce côté commun égal
                if (!this.joueurQuiJoue.getTuileEnMain().cotesEgaux(this.p.getPlateau().get(emplacementLibre.getX() + 1).get(emplacementLibre.getY()).getTuile()).contains("h")) {
                    // on tourne la tuile et on continue de vérifier
                    this.joueurQuiJoue.getTuileEnMain().tourner();
                    continue;
                }
            }
            // si une tuile est déjà présente à droite de l'emplacement libre
            if (emplacementLibre.getY() + 1 < this.p.getPlateau().get(0).size() && !this.p.getPlateau().get(emplacementLibre.getX()).get(emplacementLibre.getY()+1).estVide()){
                // mais que les deux tuiles n'ont pas ce côté commun égal
                if (!this.joueurQuiJoue.getTuileEnMain().cotesEgaux(this.p.getPlateau().get(emplacementLibre.getX()).get(emplacementLibre.getY()+1).getTuile()).contains("g")) {
                    // on tourne la tuile et on continue de vérifier
                    this.joueurQuiJoue.getTuileEnMain().tourner();
                    continue;
                }
            }
            // si une tuile est déjà présente au-dessus de l'emplacement libre
            if (emplacementLibre.getX() - 1 >= 0 && !this.p.getPlateau().get(emplacementLibre.getX()-1).get(emplacementLibre.getY()).estVide()){
                // mais que les deux tuiles n'ont pas ce côté commun égal
                if (!this.joueurQuiJoue.getTuileEnMain().cotesEgaux(this.p.getPlateau().get(emplacementLibre.getX()-1).get(emplacementLibre.getY()).getTuile()).contains("b")) {
                    // on tourne la tuile et on continue de vérifier
                    this.joueurQuiJoue.getTuileEnMain().tourner();
                    continue;
                }
            }
            // si une tuile est déjà présente à gauche de l'emplacement libre
            if (emplacementLibre.getY() - 1 >= 0 && !this.p.getPlateau().get(emplacementLibre.getX()).get(emplacementLibre.getY()-1).estVide()){
                // mais que les deux tuiles n'ont pas ce côté commun égal
                if (!this.joueurQuiJoue.getTuileEnMain().cotesEgaux(this.p.getPlateau().get(emplacementLibre.getX()).get(emplacementLibre.getY()-1).getTuile()).contains("d")) {
                    // on tourne la tuile et on continue de vérifier
                    this.joueurQuiJoue.getTuileEnMain().tourner();
                    continue;
                }
            }
            // si le jeu est Carcassonne
            if(this.getParametres().getTypeDeJeu().equals("c")){
                // on sauvegarde le nombre de pivots
                ((TuileCarcassonne)this.joueurQuiJoue.getTuileEnMain()).setNbPivot(j);
            }

            // si on souhaite jouer la tuile
            if (jouer) {
                if (this.joueurQuiJoue.getType().equals("o")){
                    // on l'ajoute au plateau
                    this.p.ajouterTuile(emplacementLibre, this.joueurQuiJoue.getTuileEnMain());
                    this.joueurQuiJoue.setTuileEnMain(null);
                    // on compte les points ainsi gagnés si on joue à dominos
                    if(this.getParametres().getTypeDeJeu().equals("d")) {
                    this.joueurQuiJoue.gagnePoints(emplacementLibre, this.p);  
                }
              
                }
            }
            // si on ne souhaite pas jouer la tuile
            else {
                // on la remet dans l'orientation d'origine
                if(this.joueurQuiJoue.getTuileEnMain() instanceof TuileDomino) {
                    this.joueurQuiJoue.setTuileEnMain(tuileBis);
                }
                else if (this.joueurQuiJoue.getTuileEnMain() instanceof TuileCarcassonne){
                    this.joueurQuiJoue.setTuileEnMain(new TuileCarcassonne((Lieu[])tuileBis.getHaut(), (Lieu[])tuileBis.getDroite(), (Lieu[])tuileBis.getBas(), (Lieu[])tuileBis.getGauche(), ((TuileCarcassonne) this.joueurQuiJoue.getTuileEnMain()).getChemin(), ((TuileCarcassonne)this.joueurQuiJoue.getTuileEnMain()).getBlason()));
                }
            }
            return true;
        }
        return false;
    }

    private Tuile copieTuile(Tuile t){
        // on copie la tuile afin de ne pas perdre d'information sur son orientation originale

        // dans le cas où la tuile sert pour le jeu domino
        if (t instanceof TuileDomino){
            return new TuileDomino((Integer[]) t.getHaut(), (Integer[]) t.getDroite(), (Integer[]) t.getBas(), (Integer[]) t.getGauche());
        }
        else {
            return new TuileCarcassonne((Lieu[]) t.getHaut(), (Lieu[]) t.getDroite(), (Lieu[]) t.getBas(), (Lieu[]) t.getGauche(), new File(""),false);
        }
    }

    // méthode qui vérifie si le jeu est terminé selon la condition que le sac est vide
    // (l'abandon d'un joueur est traité à un autre moment)
    public boolean jeuFini(){
        return this.sac.estVide();
    }

    // méthode qui annonce les points finaux lorsque le jeu est terminé
    public void annoncePoints(Table table){
        // tableau dans le cas où des joueurs soient à égalité
        ArrayList<Joueur> joueursAEgalite = new ArrayList<>();
        joueursAEgalite.add(table.getJoueurs().get(0));

        Joueur gagnant = table.getJoueurs().get(0);
        // pour chaque joueur autour de la table
        for (Joueur j: table.getJoueurs()){
            System.out.println(j.getNom() + " a gagné " + j.getNbPoints() + " points");
            // si ce joueur a gagné davantage de point que le gagnant actuel
            if (j.getNbPoints() > gagnant.getNbPoints()){
                // on change de gagnant
                gagnant = j;
                // et on réinitialise la liste des joueurs à égalité
                joueursAEgalite = new ArrayList<>();
                joueursAEgalite.add(gagnant);
            }
            // dans le cas où le nombre de points est égal
            else if (j.getNbPoints() == gagnant.getNbPoints() && gagnant != j){
                // on ajoute le joueur à la liste des joueurs à égalité
                joueursAEgalite.add(j);
            }
        }
        // s'il y a une égalité
        if (joueursAEgalite.size() > 1){
            // on affiche les joueurs à égalité
            System.out.print("Il y a égalité entre ");
            for (int i = 0 ; i < joueursAEgalite.size()-1; i++){
                System.out.print(joueursAEgalite.get(i).getNom() + " et ");
            }
            System.out.println(joueursAEgalite.get(joueursAEgalite.size()-1).getNom() + ". Bravo !");
        }
        // sinon on affiche le gagnant
        else {
            System.out.println("Bravo à " + gagnant.getNom() + " !");
        }
    }
    public void tourSuivant(int nbTour, Table table, String typeJeu) throws IOException {
        // on détermine quel joueur doit jouer ce nouveau tour
        int numeroJoueurQuiJoue = nbTour % table.getNbJoueurs() - 1;
        if (numeroJoueurQuiJoue == -1) {
            numeroJoueurQuiJoue = table.getNbJoueurs() - 1;
        }
        this.setJoueurQuiJoue(table.getJoueurs().get(numeroJoueurQuiJoue));

        // affichage en console du joueur
        System.out.println("C'est à " + this.joueurQuiJoue.getNom() + " de jouer");

        // lancement du tour
        this.jouerTour(typeJeu);

        // si le joueur n'a pas abandonné (et donc que le jeu n'est pas terminé), on vérifie que le sac n'est pas vide
        if (!this.jeuFini) {
            this.jeuFini = this.jeuFini();
        }
    }

    public void jouerPartie() throws IOException {
        if (parametres.getTypeDeJeu().equals("c")){
            this.sac = new SacCarcassonne(parametres.getNbTuiles()); // TODO : bizarre de pas avoir de setter
            this.p = new PlateauCarcassonne((SacCarcassonne) this.sac); // TODO : bizarre de pas avoir de setter
            System.out.println("Le jeu est Carcassonne et il y a " + (parametres.getNbTuiles() - 1) + " tuiles restantes dans le sac.\n");
        }
        else {
            this.sac = new SacDomino(parametres.getNbTuiles());
            this.p = new PlateauDomino((SacDomino) this.sac);

            // récapitulatif des initialisations TODO : mettre la même chose pour carcassonne
            System.out.print("Voici la table de jeu :\n");
            System.out.print(parametres.getTable());
            System.out.println("Le jeu est Dominos et il y a " + (parametres.getNbTuiles() - 1) + " tuiles restantes dans le sac.\n");
        }
        // début du jeu
        this.jeuFini = false;
        // tant que le jeu n'est pas terminé
        while (!this.jeuFini) {
            // on incrémente le nombre de tours
            this.setNbTour(this.getNbTour() + 1);
            this.tourSuivant(this.getNbTour(), parametres.getTable(), parametres.getTypeDeJeu());
        }
        // une fois le jeu terminé, on affiche le plateau final
        this.p.affiche();
        // et les points gagnés ainsi que le gagnant de la partie
        this.annoncePoints(parametres.getTable());
    }

    public static void main(String[] args) throws IOException {
        // initialisation du jeu et de ses paramètres
        Jeu jeu = new Jeu();
        Parametres parametres = new Parametres();
        jeu.setParametres(parametres);

        jeu.jouerPartie();
    }
}
