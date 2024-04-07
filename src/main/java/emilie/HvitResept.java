package emilie;

import innlevering4.Pasient;

public class HvitResept extends Resept {
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
        this.farge = "hvit";
    }

    @Override
    public String farge() {
        return farge;    }

    @Override
    public int prisAaBetale() {
        return hentLegemiddel().pris;
    }
}
