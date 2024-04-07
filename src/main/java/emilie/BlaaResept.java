package emilie;

import innlevering4.Pasient;

public class BlaaResept extends Resept {
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
        this.farge = "blå";
    }

    @Override
    public String farge() {
        return farge;
    }

    @Override
    public int prisAaBetale() {
        return (int)Math.round(hentLegemiddel().pris * 0.25);
    }
}
