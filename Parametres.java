import java.util.Scanner;

public class Parametres {
    // attributs
    private Scanner sc;
    private int nbJoueurs;
    private String typeDeJeu;
    private int nbTuiles;
    private final Table table;
    private String modeDeJeu;

    // constructeur
    public Parametres(){
        // initialisation de tous les paramètres pour le jeu
        this.sc = new Scanner(System.in);
        demandeTypeDeJeu();
        demandeNombreJoueur();
        this.table = new Table(this.nbJoueurs, this.typeDeJeu);
        table.creationTable(nbJoueurs, this);
        demandeNombreTuiles();
        if (this.typeDeJeu.equals("d")){
            modeDeJeu();
        }
    }

    // tous les getters nécessaires
    public Table getTable(){
        return this.table;
    }
    public int getNbTuiles(){
        return this.nbTuiles;
    }
    public String getTypeDeJeu(){
        return this.typeDeJeu;
    }
    public String getModeDeJeu(){
        return this.modeDeJeu;
    }

    // on demande aux joueurs les informations qui servent à créer la Table, le Sac, le Plateau
    private void demandeNombreJoueur(){
        System.out.println("Combien de joueurs vont jouer ? (format : 2) ");
        this.nbJoueurs = sc.nextInt();
    }
    public String demandeNomJoueur(){
        System.out.println("Entrez le nom du joueur : ");
        return this.sc.nextLine();
    }
    public String typeAdversaire(){
        this.sc = new Scanner(System.in);
        System.out.println("est-ce un ordinateur (entrez o) ou un humain (entrez h) ? (format : o)");
        return this.sc.nextLine();
    }
    private void demandeTypeDeJeu(){
        System.out.println("Voulez-vous jouer aux dominos (entrez d) ou à Carcassonne (entrez c) : (format : c)");
        this.typeDeJeu = sc.nextLine();
        while(!(this.typeDeJeu.equals("c")||this.typeDeJeu.equals("d"))){
            demandeTypeDeJeu();
        }
    }
    private void demandeNombreTuiles(){
        boolean nbValide = false;
        int nb = 0;
        while (!nbValide){
            System.out.println("Avec combien de tuiles voulez-vous jouer (nombre inférieur ou égal à 72) ? (format : 10)");
            nb = sc.nextInt();
            nbValide = nb <= 72 && nb > 0;
        }
        this.nbTuiles = nb;
    }
    private void modeDeJeu(){
        this.sc = new Scanner(System.in);
        System.out.println("Voulez-vous jouer sur terminal (entrez t) ou sur interface graphique (entrez i) ? : (format : i)");
        this.modeDeJeu = sc.nextLine();
        while(!(this.modeDeJeu.equals("t")||this.modeDeJeu.equals("i"))){
            modeDeJeu();
        }
    }
}
