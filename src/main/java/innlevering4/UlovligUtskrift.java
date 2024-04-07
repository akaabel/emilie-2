package innlevering4;

import emilie.Lege;
import emilie.Legemiddel;

public class UlovligUtskrift extends Exception {
    public UlovligUtskrift(Lege l, Legemiddel lm) {
        super("Legen " + l.hentNavn() + " har ikke lov til aa skrive ut " + lm.hentNavn());
    }
}
