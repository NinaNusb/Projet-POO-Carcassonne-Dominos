import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class SacCarcassonne extends Sac {
    /*
    quand on crée le sac, on lit toutes les images du dossier. On crée ainsi les tuilesCarcassonne une à une
    en instanciant "chemin" à l'url et comme c'est dans l'ordre, on peut savoir quelles sont les valeurs
    des côtés
     */

    // constructeur
    public SacCarcassonne(int nbTuiles){
            ArrayList<Tuile> sac = new ArrayList<>();

            // construction de la liste ordonnée de tous les fichiers images des tuiles
            ArrayList<File> listeImages = new ArrayList<>();
                            
            try {
                // new File("src/Image tuile").listFiles();
                Collections.addAll(listeImages, new File("src/Image tuile").listFiles());
            } catch (Exception e) {
                e.printStackTrace();
            }
            // on génère autant de nombres aléatoires (différents les uns des autres)
            // que de tuiles souhaitées pour le jeu
            ArrayList<Integer> nbAlea = new ArrayList<>();
            for (int i = 0 ; i < nbTuiles-1 ; i++){
                int r = super.rd.nextInt(71);
                if (!nbAlea.contains(r)) {
                    nbAlea.add(r);
                }
                else {
                    i -= 1;
                }
            }

            // on remplit petit à petit le sac selon les nombres aléatoires générés
            if (nbAlea.contains(0)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(0), false));
            }
            if (nbAlea.contains(1)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(0), false));
            }
            if (nbAlea.contains(2)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(2), false));
            }
            if (nbAlea.contains(3)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(2), false));
            }
            if (nbAlea.contains(4)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(2), false));
            }
            if (nbAlea.contains(5)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(2), false));
            }
            if (nbAlea.contains(6)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Ville();
                bas[1] = new Ville();
                bas[2] = new Ville();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(6), true));
            }
            if (nbAlea.contains(7)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(7), false));
            }
            if (nbAlea.contains(8)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(7), false));
            }
            if (nbAlea.contains(9)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(7), false));
            }
            if (nbAlea.contains(10)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(10), false));
            }
            if (nbAlea.contains(11)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(10), false));
            }
            if (nbAlea.contains(12)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(10), false));
            }
            if (nbAlea.contains(13)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(10), false));
            }
            if (nbAlea.contains(14)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(10), false));
            }
            if (nbAlea.contains(15)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(15), true));
            }
            if (nbAlea.contains(16)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(15), true));
            }
            if (nbAlea.contains(17)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(17), false));
            }
            if (nbAlea.contains(18)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(17), false));
            }
            if (nbAlea.contains(19)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(17), false));
            }
            if (nbAlea.contains(20)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(17), false));
            }
            if (nbAlea.contains(21)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(21), false));
            }
            if (nbAlea.contains(22)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(21), false));
            }
            if (nbAlea.contains(23)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(23), false));
            }
            if (nbAlea.contains(24)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(23), false));
            }
            if (nbAlea.contains(25)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(23), false));
            }
            if (nbAlea.contains(26)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(26), false));
            }
            if (nbAlea.contains(27)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(26), false));
            }
            if (nbAlea.contains(28)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(26), false));
            }
            if (nbAlea.contains(29)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(29), false));
            }
            if (nbAlea.contains(30)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(29), false));
            }
            if (nbAlea.contains(31)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(29), false));
            }
            if (nbAlea.contains(32)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(32), true));
            }
            if (nbAlea.contains(33)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(32), true));
            }
            if (nbAlea.contains(34)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(34), false));
            }
            if (nbAlea.contains(35)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(34), false));
            }
            if (nbAlea.contains(36)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(34), false));
            }
            if (nbAlea.contains(37)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(37), true));
            }
            if (nbAlea.contains(38)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(37), true));
            }
            if (nbAlea.contains(39)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(39), false));
            }
            if (nbAlea.contains(40)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(39), false));
            }
            if (nbAlea.contains(41)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(39), false));
            }
            if (nbAlea.contains(42)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(42), true));
            }
            if (nbAlea.contains(43)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(43), false));
            }
            if (nbAlea.contains(44)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(43), false));
            }
            if (nbAlea.contains(45)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Champ();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(43), false));
            }
            if (nbAlea.contains(46)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(46), true));
            }
            if (nbAlea.contains(47)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(46), true));
            }
            if (nbAlea.contains(48)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Ville();
                haut[1] = new Ville();
                haut[2] = new Ville();
                droite[0] = new Ville();
                droite[1] = new Ville();
                droite[2] = new Ville();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Ville();
                gauche[1] = new Ville();
                gauche[2] = new Ville();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(48), false));
            }
            if (nbAlea.contains(49)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Route();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(49), false));
            }
            if (nbAlea.contains(50)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Route();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(49), false));
            }
            if (nbAlea.contains(51)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Route();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(49), false));
            }
            if (nbAlea.contains(52)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Route();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(49), false));
            }
            if (nbAlea.contains(53)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Route();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(49), false));
            }
            if (nbAlea.contains(54)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Route();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(49), false));
            }
            if (nbAlea.contains(55)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Route();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(49), false));
            }
            if (nbAlea.contains(56)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Route();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Champ();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(49), false));
            }
            if (nbAlea.contains(57)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(57), false));
            }
            if (nbAlea.contains(58)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(57), false));
            }
            if (nbAlea.contains(59)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(57), false));
            }
            if (nbAlea.contains(60)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(57), false));
            }
            if (nbAlea.contains(61)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(57), false));
            }
            if (nbAlea.contains(62)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(57), false));
            }
            if (nbAlea.contains(63)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(57), false));
            }
            if (nbAlea.contains(64)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(57), false));
            }
            if (nbAlea.contains(65)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Champ();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(57), false));
            }
            if (nbAlea.contains(66)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(66), false));
            }
            if (nbAlea.contains(67)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(66), false));
            }
            if (nbAlea.contains(68)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(66), false));
            }
            if (nbAlea.contains(69)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Champ();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(66), false));
            }
            if (nbAlea.contains(70)) {
                Lieu[] haut = new Lieu[3];
                Lieu[] droite = new Lieu[3];
                Lieu[] bas = new Lieu[3];
                Lieu[] gauche = new Lieu[3];
                haut[0] = new Champ();
                haut[1] = new Route();
                haut[2] = new Champ();
                droite[0] = new Champ();
                droite[1] = new Route();
                droite[2] = new Champ();
                bas[0] = new Champ();
                bas[1] = new Route();
                bas[2] = new Champ();
                gauche[0] = new Champ();
                gauche[1] = new Route();
                gauche[2] = new Champ();
                sac.add(new TuileCarcassonne(haut, droite, bas, gauche, listeImages.get(70), false));
            }
            this.sac = sac;
    }
}
