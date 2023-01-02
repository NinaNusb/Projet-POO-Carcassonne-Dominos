import java.io.IOException;

public class DominoGraphique {

    public DominoGraphique(Jeu jeu) throws IOException {
        Modele modele = new Modele();
        Controleur controleur = new Controleur(modele);
        Vue vue = new Vue(controleur, modele, jeu);
        vue.setVisible(true);
    }

}