package innlevering4;

import emilie.Resept;

import java.util.ArrayList;
import java.util.List;

public class Pasient {
    private int id;
    private String navn;
    private String foedselsnummer;
    private List<Resept> reseptListe = new ArrayList<Resept>();
    private static int idTeller = 0;

    public Pasient(String navn, String foedselsnummer) {
        this.id = idTeller++;
        this.navn = navn;
        this.foedselsnummer = foedselsnummer;
    }

    public void leggTilResept(Resept resept) {
        reseptListe.add(resept);
    }

    @Override
    public String toString() {
        return "Pasient{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                ", foedselsnummer='" + foedselsnummer + '\'' +
                ", reseptListe=" + reseptListe +
                '}';
    }
}
