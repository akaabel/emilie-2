package emilie;

import innlevering4.Pasient;

public abstract class Resept {

    private int id;
    private Legemiddel legemiddel;
    private Lege lege;
    private Pasient pasient;
    private int reit;
    private static int idTeller = 0;
    protected String farge;

    public Resept(Legemiddel legemiddel, Pasient pasient, int reit) {
        this.legemiddel = legemiddel;
        this.pasient = pasient;
        this.reit = reit;
        this.id = idTeller++;
    }

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        this.legemiddel = legemiddel;
        this.lege = utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;
        this.id = idTeller++;
    }

    public int hentId() {
        return id;
    }

    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }

    public Lege hentLege() {
        return lege;
    }

    public int hentReit() {
        return reit;
    }

    public boolean bruk() {
        if (reit == 0) {
            return false;
        } else {
            reit--;
            return true;
        }
    }

    abstract public String farge();

    abstract public int prisAaBetale();

    @Override
    public String toString() {
        return "Resept{" +
                "id=" + id +
                ", legemiddel=" + legemiddel +
                ", lege=" + lege +
                ", pasient=" + pasient +
                ", reit=" + reit +
                ", farge='" + farge + '\'' +
                '}';
    }
}