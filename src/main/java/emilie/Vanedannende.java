package emilie;

public class Vanedannende extends Legemiddel {

    final public int styrke;

    public Vanedannende(String navn, int pris, double virkestoff, int styrke) {

        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    @Override
    public String toString() {
        return "Vanedannende{" +
                "styrke=" + styrke +
                "} " + super.toString();
    }
}