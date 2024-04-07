package emilie;

public class Spesialist extends Lege implements Godkjenningsfritak {
    private String kontrollkode;
    public Spesialist(String navn, String kontrollkode) {
        super(navn);
        this.kontrollkode = kontrollkode;
    }

    @Override
    public String hentKontrollkode() {
        return kontrollkode;
    }


    @Override
    public String toString() {
        return "Spesialist{" +
                "kontrollkode='" + kontrollkode + '\'' +
                '}'
                + " " + super.toString();
    }
}
