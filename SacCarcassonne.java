import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class SacCarcassonne extends Sac {
    /*
    quand on crée le sac, on lit toutes les images du dossier. On crée ainsi les tuilesCarcassonne une à une
    en instanciant "chemin" à l'url et comme c'est dans l'ordre, on peut savoir quelles sont les valeurs
    des côtés
     */

    public SacCarcassonne(){ // TODO faire un constructeur où on peut choisir au hasard un certain nombre de tuiles
        ArrayList<Tuile> wipSac = new ArrayList<>();
        ArrayList<File> listeImages = new ArrayList<>();
        Collections.addAll(listeImages, new File("src/Image tuile").listFiles());

        int j = -1;
        for(int i = 0; i < 2; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Champ(haut);
            haut[1] = new Champ(haut);
            haut[2] = new Champ(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Champ(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Champ(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 4; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Champ(haut);
            haut[1] = new Champ(haut);
            haut[2] = new Champ(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Champ(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Champ(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 1; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Ville(bas);
            bas[1] = new Ville(bas);
            bas[2] = new Ville(bas);
            gauche[0] = new Ville(gauche);
            gauche[1] = new Ville(gauche);
            gauche[2] = new Ville(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), true));
        }
        for(int i = 0; i < 3; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Route(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Route(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 5; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Champ(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Champ(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 2; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Champ(haut);
            haut[1] = new Champ(haut);
            haut[2] = new Champ(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Ville(gauche);
            gauche[1] = new Ville(gauche);
            gauche[2] = new Ville(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), true));
        }
        for(int i = 0; i < 4; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Champ(haut);
            haut[1] = new Champ(haut);
            haut[2] = new Champ(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Ville(gauche);
            gauche[1] = new Ville(gauche);
            gauche[2] = new Ville(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 2; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Champ(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 3; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Route(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Champ(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 3; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Champ(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Route(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 3; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Route(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Route(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 2; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Champ(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), true));
        }
        for(int i = 0; i < 3; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Champ(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 2; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Route(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Ville(gauche);
            gauche[1] = new Ville(gauche);
            gauche[2] = new Ville(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), true));
        }
        for(int i = 0; i < 3; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Route(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Ville(gauche);
            gauche[1] = new Ville(gauche);
            gauche[2] = new Ville(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 1; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Ville(gauche);
            gauche[1] = new Ville(gauche);
            gauche[2] = new Ville(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), true));
        }
        for(int i = 0; i < 3; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Champ(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Ville(gauche);
            gauche[1] = new Ville(gauche);
            gauche[2] = new Ville(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 2; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Ville(gauche);
            gauche[1] = new Ville(gauche);
            gauche[2] = new Ville(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), true));
        }
        for(int i = 0; i < 1; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Ville(haut);
            haut[1] = new Ville(haut);
            haut[2] = new Ville(haut);
            droite[0] = new Ville(droite);
            droite[1] = new Ville(droite);
            droite[2] = new Ville(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Ville(gauche);
            gauche[1] = new Ville(gauche);
            gauche[2] = new Ville(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 8; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Champ(haut);
            haut[1] = new Route(haut);
            haut[2] = new Champ(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Champ(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Champ(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 9; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Champ(haut);
            haut[1] = new Champ(haut);
            haut[2] = new Champ(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Champ(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Route(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 4; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Champ(haut);
            haut[1] = new Champ(haut);
            haut[2] = new Champ(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Route(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Route(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        for(int i = 0; i < 1; i++) {
            j++;
            Lieu[] haut = new Lieu[3];
            Lieu[] droite = new Lieu[3];
            Lieu[] bas = new Lieu[3];
            Lieu[] gauche = new Lieu[3];
            haut[0] = new Champ(haut);
            haut[1] = new Route(haut);
            haut[2] = new Champ(haut);
            droite[0] = new Champ(droite);
            droite[1] = new Route(droite);
            droite[2] = new Champ(droite);
            bas[0] = new Champ(bas);
            bas[1] = new Route(bas);
            bas[2] = new Champ(bas);
            gauche[0] = new Champ(gauche);
            gauche[1] = new Route(gauche);
            gauche[2] = new Champ(gauche);
            wipSac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(j), false));
        }
        this.sac = wipSac;
    }
}
