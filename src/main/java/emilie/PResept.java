package emilie;

import innlevering4.Pasient;

public class PResept extends HvitResept {

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public int prisAaBetale() {
        if (hentLegemiddel().pris > 108) {
            return hentLegemiddel().pris - 108;
        } else {
            return 0;
        }
    }
}
