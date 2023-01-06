public abstract class Lieu {
    // attributs
    protected int points;
    private Joueur possesseurPartisan;
    private String position;

    // constructeur
    public Lieu(){}

    // getters et setters nécessaires

    public String getPosition(){
        return this.position;
    }
    public void setPosition(String p){
        this.position = p;
    }
    public void ajouterPartisan(Joueur joueur){
        this.possesseurPartisan = joueur;
    }
    public void retirerPartisan(){
        this.possesseurPartisan = null;
    }
}
