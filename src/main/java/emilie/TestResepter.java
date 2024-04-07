package emilie;

import innlevering4.Pasient;

public class TestResepter {
    public static void main(String[] args) {
        Narkotisk narkotisk = new Narkotisk("Morfin", 400, 3.5, 10);
        Vanedannende vanedannende = new Vanedannende("Zopiklon", 300, 3.75, 99);
        Vanlig vanlig = new Vanlig("Paracet", 100, 2.5);

        Lege legeEmilie = new Lege("emilie");
        Spesialist spesialistEmilie = new Spesialist("emilie", "eko");

        int testPasientId = 100;
        int testReit = 10;
        Pasient emiliePasient = new Pasient("Emilie", "12345678901");

        BlaaResept blaaResept = new BlaaResept(narkotisk, legeEmilie, emiliePasient, testReit);
        HvitResept hvitResept = new HvitResept(narkotisk, legeEmilie, emiliePasient, testReit);
        MilResept milResept = new MilResept(narkotisk, legeEmilie, emiliePasient);
        PResept pResept = new PResept(narkotisk, legeEmilie, emiliePasient, testReit);

        System.out.println("\n\nTester farge()");
        testFarge(blaaResept, "blå");
        testFarge(pResept, "hvit");
        testFarge(hvitResept, "hvit");
        testFarge(milResept, "hvit");


        System.out.println("\n\nTester bruk()");
        testBruk(blaaResept, testReit - 1);
        testBruk(hvitResept, testReit - 1);
        testBruk(milResept, 2);
        testBruk(pResept, testReit - 1);


        System.out.println("\n\nTester prisAaBetale()");
        testPrisAaBetale(blaaResept, 100);
        testPrisAaBetale(hvitResept, 400);
        testPrisAaBetale(milResept, 0);
        testPrisAaBetale(pResept, 400 - 108);


        System.out.println("\n\nIntegrasjonstest()");
        System.out.println("Narkotisk: " + narkotisk);
        System.out.println("Vanedannende: " + vanedannende);
        System.out.println("Vanlig: " + vanlig);

        System.out.println("Lege: " + legeEmilie);
        System.out.println("Spesialist: " + spesialistEmilie);

        System.out.println("Blåresept: " + blaaResept);
        System.out.println("Hvitresept: " + hvitResept);
        System.out.println("Militær resept: " + milResept);
        System.out.println("P resept: " + pResept);
    }

    private static void testPrisAaBetale(Resept resept, int forventetPris) {
        if (resept.prisAaBetale() == forventetPris) {
            System.out.println("\u2713 Forventet pris for resepten " + resept.getClass() + " er korrekt.");
        } else {
            System.out.println("\u23F9 Forventet pris for resepten " + resept.getClass() + " er feil.");
        }

    }

    public static void testFarge(Resept resept, String farge) {
        // Tester farge
        if (resept.farge().equals(farge)) {
            System.out.println("\u2713 Forventet farge for resepten " + resept.getClass() + " er korrekt.");
        } else {
            System.out.println("\u23F9 Forventet farge for resepten " + resept.getClass() + " er feil.");
        }
    }

    public static void testBruk(Resept resept, int forventetReitEtterBruk) {
        resept.bruk();
        if (resept.hentReit() == forventetReitEtterBruk) {
            System.out.println("\u2713 Forventet reit for resepten " + resept.getClass() + " er korrekt.");
        } else {
            System.out.println("\u23F9 Forventet farge for resepten " + resept.getClass() + " er feil.");
        }
    }
}