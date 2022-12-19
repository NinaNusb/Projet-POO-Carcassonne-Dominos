import java.util.concurrent.atomic.AtomicInteger;

public abstract class Lieu {
    protected Lieu lieu1;
    protected Lieu lieu2;
    protected Lieu lieu3;
    int numeroUnique;
    public static AtomicInteger genID = new AtomicInteger();

    public Lieu(Lieu[] lieux){
        this.lieu1 = lieux[0];
        this.lieu2 = lieux[1];
        this.lieu3 = lieux[2];
    
    }
    public Lieu getLieu1(){
        return this.lieu1;
    }
    public Lieu getLieu2(){
        return this.lieu2;
    }
    public Lieu getLieu3(){
        return this.lieu3;
    }

    public void donneIndice(Lieu lieuAdjacent){
        this.numeroUnique = lieuAdjacent.numeroUnique;
    }
}
