import javax.swing.*;

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
}
