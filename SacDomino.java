import java.util.ArrayList;

public class SacDomino extends Sac {

    public SacDomino(int nbTuiles){
        ArrayList<Tuile> wipSac = new ArrayList<>();
        // pour chaque tuile à mettre dans le sac
        for (int i = 0; i < nbTuiles; i++){
            // on remplit les attributs haut, droite, bas et gauche avec des nombres
            // aléatoires entre 0 et 4 inclus.

            // haut
            Integer[] haut = new Integer[3];
            for (int j = 0; j <3; j++){
                haut[j] = rd.nextInt(2);
            }
            // droite
            Integer[] droite = new Integer[3];
            for (int j = 0; j <3; j++){
                droite[j] = rd.nextInt(2);
            }
            // bas
            Integer[] bas = new Integer[3];
            for (int j = 0; j <3; j++){
                bas[j] = rd.nextInt(2);
            }
            // gauche
            Integer[] gauche = new Integer[3];
            for (int j = 0; j <3; j++){
                gauche[j] = rd.nextInt(2);
            }
            // une fois tous les attributs construits, on crée la tuile
            TuileDomino tuile = new TuileDomino(haut,droite,bas,gauche);
            // on ajoute cette tuile au sac en construction
            wipSac.add(tuile);
        }
        sac = wipSac;
    }
}
