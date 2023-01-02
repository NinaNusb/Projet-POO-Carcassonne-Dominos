import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controleur {
    // attributs
    Modele modele;
    Vue vue;

    // constructeur
    public Controleur(Modele modele){
        this.modele = modele;
    }

    // setter nécessaire
    public void setVue(Vue vue){
        this.vue = vue;
    }

    // méthode pour tourner une tuile après que le joueur a pressé le bouton
    public void tuileTournee(JPanel tuilePiochee) {
        modele.setTuilePiochee(tuilePiochee);
        vue.miseAJourTuilePiochee();
    }

    // méthode pour poser une tuile après que le joueur a pressé le bouton
    public void tuilePosee(int x, int y, TuileCarcassonne t, Jeu jeu) throws IOException {
        ((PlateauCarcassonne)jeu.getP()).ajouterTuile(new Emplacement(x, y), t, jeu.getJoueurQuiJoue());
        vue.miseAJourPlateau(jeu);
    }

    // méthode pour piocher une tuile
    public void pioche(Jeu jeu) throws IOException {
        // on détermine le joueur qui doit jouer le nouveau tour
        jeu.setNbTour(jeu.getNbTour()+1);
        int numeroJoueurQuiJoue = jeu.getNbTour() % jeu.getParametres().getTable().getNbJoueurs() - 1;
        if (numeroJoueurQuiJoue == -1) {
            numeroJoueurQuiJoue = jeu.getParametres().getTable().getNbJoueurs() - 1;
        }
        jeu.setJoueurQuiJoue(jeu.getParametres().getTable().getJoueurs().get(numeroJoueurQuiJoue));

        // ce joueur pioche une tuile
        jeu.getJoueurQuiJoue().pioche(jeu.getSac());

        // mise à jour de l'affichage selon la tuile piochée
        File file = ((TuileCarcassonne)jeu.getJoueurQuiJoue().getTuileEnMain()).getChemin();
        BufferedImage path = ImageIO.read(file);
        vue.tuilePiochee = new ImagePane(path);
        this.modele.setTuilePiochee(vue.tuilePiochee);
        vue.miseAJourPanneauChoix(jeu);
    }
}
