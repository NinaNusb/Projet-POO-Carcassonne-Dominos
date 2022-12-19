public abstract class Tuile<T> {
    // attributs
    protected T[] haut;
    protected T[] gauche;
    protected T[] droite;
    protected T[] bas;

    // constructeur
    public Tuile(T[] haut, T[] droite, T[] bas, T[] gauche){
        this.haut = haut;
        this.gauche = gauche;
        this.droite = droite;
        this.bas = bas;
    }

    // tous les getteurs nécessaires
    public T[] getHaut(){
        return this.haut;
    }
    public T[] getGauche(){
        return this.gauche;
    }
    public T[] getDroite(){
        return this.droite;
    }
    public T[] getBas(){
        return this.bas;
    }

    // méthode pour tourner la tuile de 90° vers la droite
    public void tourner(){
        /* On tourne la tuile vers la droite, ce qui revient à donner aux attributs
        la valeur de l'attribut à sa gauche. */
        T[] tmp = this.haut;
        this.haut = this.gauche;
        this.gauche = this.bas;
        this.bas = this.droite;
        this.droite = tmp;
    }

    // méthode qui renvoie le nom (haut/droite/bas/gauche) d'un des côtés égaux entre la tuileEnMain et une
    // tuile déjà posée s'il y en a
    public abstract String cotesEgaux(Tuile t);

}
