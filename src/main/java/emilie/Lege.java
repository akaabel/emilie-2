package emilie;

import innlevering4.Pasient;
import innlevering4.UlovligUtskrift;

import java.util.ArrayList;
import java.util.List;

public class Lege implements Comparable<Lege> {
    private String navn;
    private List<Resept> utskrevneResepter = new ArrayList<>();

    public Lege(String navn) {
        this.navn = navn;
    }

    public List<Resept> getUtskrevneResepter() {
        return utskrevneResepter;
    }

    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        sjekkOmLegeHarLovTilAaForskriveNarkotiskResept(legemiddel);
        HvitResept hvitResept = new HvitResept(legemiddel, this, pasient, reit);
        utskrevneResepter.add(hvitResept);
        return hvitResept;
    }

    private void sjekkOmLegeHarLovTilAaForskriveNarkotiskResept(Legemiddel legemiddel) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            if (!(this instanceof Spesialist)) {
                throw new UlovligUtskrift(this, legemiddel);
            }
        }
    }

    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        sjekkOmLegeHarLovTilAaForskriveNarkotiskResept(legemiddel);
        BlaaResept resept = new BlaaResept(legemiddel, this, pasient, reit);
        utskrevneResepter.add(resept);
        return resept;
    }

    public MilResept skrivMilResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        sjekkOmLegeHarLovTilAaForskriveNarkotiskResept(legemiddel);
        MilResept resept = new MilResept(legemiddel, this, pasient);
        utskrevneResepter.add(resept);
        return resept;
    }

    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        sjekkOmLegeHarLovTilAaForskriveNarkotiskResept(legemiddel);
        PResept resept = new PResept(legemiddel, this, pasient, reit);
        utskrevneResepter.add(resept);
        return resept;
    }


    @Override
    public String toString() {
        return "Lege{" +
                "navn='" + navn + '\'' +
                '}';
    }

    @Override
    public int compareTo(Lege other) {
        return this.navn.compareTo(other.navn);
    }

    public String hentNavn() {
        return navn;
    }
}