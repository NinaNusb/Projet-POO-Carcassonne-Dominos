public class TuileDomino extends Tuile {

    @SuppressWarnings ("unchecked")
    public TuileDomino(Integer[] haut, Integer[] droite, Integer[] bas, Integer[] gauche){
        super(haut, droite, bas, gauche);
    }

    // méthode qui renvoie le nom (haut/droite/bas/gauche) d'un des côtés égaux entre la tuileEnMain et une
    // tuile déjà posée s'il y en a
    public String cotesEgaux(Tuile t){
        boolean tripletEgal = true;
        // pour chaque int dans le tableau de valeur
        for (int i = 0; i < 3 ; i ++){
            // si une des valeurs ne correspond pas si on place la tuileEnMain en bas de la tuile déjà posée
            if (this.getHaut()[i] != t.getBas()[2-i]){
                // alors le tableau n'est pas égal
                tripletEgal = false;
                break;
            }
        }
        // on retourne le lieu où on peut poser la tuile
        if (tripletEgal) return "b";

        tripletEgal = true;
        // pour chaque int dans le tableau de valeur
        for (int i = 0; i < 3 ; i ++){
            // si une des valeurs ne correspond pas si on place la tuileEnMain à gauche de la tuile déjà posée
            if (this.getDroite()[i] != t.getGauche()[2-i]){
                // alors le tableau n'est pas égal
                tripletEgal = false;
                break;
            }
        }
        // on retourne le lieu où on peut poser la tuile
        if (tripletEgal) return "g";

        tripletEgal = true;
        // pour chaque int dans le tableau de valeur
        for (int i = 0; i < 3 ; i ++){
            // si une des valeurs ne correspond pas si on place la tuileEnMain en haut de la tuile déjà posée
            if (this.getBas()[i] != t.getHaut()[2-i]){
                // alors le tableau n'est pas égal
                tripletEgal = false;
                break;
            }
        }
        // on retourne le lieu où on peut poser la tuile
        if (tripletEgal) return "h";

        tripletEgal = true;
        // pour chaque int dans le tableau de valeur
        for (int i = 0; i < 3 ; i ++){
            // si une des valeurs ne correspond pas si on place la tuileEnMain à droite de la tuile déjà posée
            if (this.getGauche()[i] != t.getDroite()[2-i]){
                // alors le tableau n'est pas égal
                tripletEgal = false;
                break;
            }
        }
        // on retourne le lieu où on peut poser la tuile
        if (tripletEgal){
            return "d";
        }

        // si aucun des côtés de la TuileEnMain n'est égal avec la tuile déjà posée, on retourne un string vide
        return "";
    }

    public String toString(){
        /* afficher une tuile revient à l'afficher sous la forme :
         _ _ _ _ _
        |  2 3 5  |
        |2       8|
        |3       6|
        |4       5|
        |  5 6 8  |
         _ _ _ _ _
        */
        return " _ _ _ _ _ \n"
                + "|  "+this.getHaut()[0]+" "+this.getHaut()[1]+" "+this.getHaut()[2]+"  |\n"
                + "|"+this.getGauche()[2]+"       "+this.getDroite()[0]+"|\n"
                + "|"+this.getGauche()[1]+"       "+this.getDroite()[1]+"|\n"
                + "|"+this.getGauche()[0]+"       "+this.getDroite()[2]+"|\n"
                + "|  "+this.getBas()[2]+" "+this.getBas()[1]+" "+this.getBas()[0]+"  |\n"
                + " _ _ _ _ _ ";
    }
}
