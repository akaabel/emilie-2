package oblig2;

public class Subsekvens {

    private int antall; 
    public final String subsekvens;

    public Subsekvens(String subsekvens, int antall){
        this.subsekvens = subsekvens; 
        this.antall = antall;
    }

    public int hentAntall(){
        return antall;
    }

    public void endre(int forekomst){
        antall += forekomst;

    }

    @Override
    public String toString(){
        return (subsekvens + "," + antall);

    }

}