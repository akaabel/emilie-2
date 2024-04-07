package emilie;

public class TestLegemiddel {

    public static void main(String[] args) {

        Narkotisk narkotisk = new Narkotisk("Morfin", 400, 3.5, 10);
        Vanedannende vanedannende = new Vanedannende("Zopiklon", 300, 3.75, 99);
        Vanlig vanlig = new Vanlig("Paracet", 100, 2.5);

        testIdNummer(narkotisk, 0);
        testIdNummer(vanedannende, 1);
        testIdNummer(vanlig, 2);
        testVirkestoff(narkotisk, 3.5);
        testVirkestoff(vanedannende, 3.75);
        testVirkestoff(vanlig, 2.5);
    }

    public static void testIdNummer(Legemiddel legemiddel, int forventetId) {
        if (legemiddel.idNummer == forventetId) {
            System.out.println("Forventet ID er riktig for legemiddel: " + legemiddel + " med ID nummer: " + legemiddel.idNummer);
        } else {
            System.out.println("Forventet ID er ikke riktig for legemiddel: " + legemiddel + " med ID nummer: " + legemiddel.idNummer);
        }
    }

    public static void testVirkestoff(Legemiddel legemiddel, double forventetVirkestoff) {
        if (legemiddel.virkestoff == forventetVirkestoff) {
            System.out.println("Forventet virkestoff er riktig for legemiddel: " + legemiddel + " med virkestoff: " + legemiddel.virkestoff);
        } else {
            System.out.println("Forventet virkestoff er ikke riktig for legemiddel: " + legemiddel + " med virkestoff: " + legemiddel.virkestoff);
        }
    }

}
