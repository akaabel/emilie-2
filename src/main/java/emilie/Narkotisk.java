package emilie;

public class Narkotisk extends Legemiddel {

    final public int styrke;

    public Narkotisk(String navn, int pris, double virkestoff, int styrke) {

        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    @Override
    public String toString() {
        return "Narkotisk{" +
                "styrke=" + styrke +
                "} " + super.toString();
    }
}