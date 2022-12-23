import java.io.IOException;

public class CarcassonneGraphique {
    private Vue vue;
    private Modele modele;
    private Controleur controleur;

    public CarcassonneGraphique(Jeu jeu) throws IOException {
        this.modele = new Modele();
        this.controleur = new Controleur(modele);
        vue = new Vue(controleur, modele, jeu);
        this.controleur.setVue(vue);
        vue.setVisible(true);
    }

}
