package emilie;

public abstract class Legemiddel {

    final public String navn;
    public int pris;
    final public double virkestoff;
    final public int idNummer;
    private static int idTeller = 0;

    public Legemiddel(String navn, int pris, double virkestoff) {
        
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.idNummer = idTeller++;
    }

    public int hentPris() {
        return this.pris;
    }

    public void settNyPris(int nyPris) {
        this.pris = nyPris;
    }

    public int hentIdNummer() {
        return this.idNummer;
    }

    @Override
    public String toString() {
        return "Legemiddel{" +
                "navn='" + navn + '\'' +
                ", pris=" + pris +
                ", virkestoff=" + virkestoff +
                ", idNummer=" + idNummer +
                '}';
    }

    public String hentNavn() {
        return navn;
    }
}