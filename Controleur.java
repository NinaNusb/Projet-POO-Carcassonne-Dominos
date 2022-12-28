import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controleur {
    Modele modele;
    Vue vue;
    public Controleur(Modele modele){
        this.modele = modele;
    }
    public void setVue(Vue vue){
        this.vue = vue;
    }
    public void tuileTournee(JPanel tuilePiochee) {
        modele.setTuilePiochee(tuilePiochee);
        vue.miseAJourTuilePiochee();
    }
    public void tuilePosee(int x, int y, TuileCarcassonne t, Jeu jeu) throws IOException {
        ((PlateauCarcassonne)jeu.getP()).ajouterTuile(new Emplacement(x, y), t, jeu.getJoueurQuiJoue());
        vue.miseAJourPlateau(jeu);
    }

    public void pioche(Jeu jeu) throws IOException {
        jeu.setNbTour(jeu.getNbTour()+1);
        int numeroJoueurQuiJoue = jeu.getNbTour() % jeu.getTable().getNbJoueurs() - 1;
        if (numeroJoueurQuiJoue == -1) {
            numeroJoueurQuiJoue = jeu.getTable().getNbJoueurs() - 1;
        }
        jeu.setJoueurQuiJoue(jeu.getTable().getJoueurs().get(numeroJoueurQuiJoue));

        jeu.getJoueurQuiJoue().pioche(jeu.getSac());
        File file = ((TuileCarcassonne)jeu.getJoueurQuiJoue().getTuileEnMain()).getChemin();
        BufferedImage path = ImageIO.read(file);
        vue.tuilePiochee = new ImagePane(path);
        this.modele.setTuilePiochee(vue.tuilePiochee);
        vue.miseAJourPanneauChoix(jeu);
    }
}
