import java.io.IOException;

public class CarcassonneGraphique {
    private Vue vue;
    private Modele modele;
    private Controleur controleur;

    public CarcassonneGraphique(Plateau p) throws IOException {
        this.modele = new Modele();
        this.controleur = new Controleur(modele);
        vue = new Vue(controleur, modele, p);
        this.controleur.setVue(vue);
        vue.setVisible(true);
    }

}