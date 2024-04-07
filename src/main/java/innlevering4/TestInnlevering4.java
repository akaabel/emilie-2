package innlevering4;

import emilie.*;

import java.util.*;

public class TestInnlevering4 {
    public static void main(String[] args) {
        Narkotisk narkotisk = new Narkotisk("Morfin", 400, 3.5, 10);
        Vanedannende vanedannende = new Vanedannende("Zopiklon", 300, 3.75, 99);
        Vanlig vanlig = new Vanlig("Paracet", 100, 2.5);

        Lege legeEmilie = new Lege("emilie");
        Spesialist spesialistEmilie = new Spesialist("emilieSpesialist", "eko");

        int testReit = 10;
        Pasient emiliePasient = new Pasient("Emilie", "12345678901");
        System.out.println(emiliePasient);

        try {
            // Denne kaster
//            legeEmilie.skrivHvitResept(narkotisk,emiliePasient, 10);
//            System.out.println("Antall utskrevne resepter: " + legeEmilie.getUtskrevneResepter().size());
            spesialistEmilie.skrivHvitResept(narkotisk,emiliePasient, 10);
            System.out.println("Antall utskrevne resepter: " + legeEmilie.getUtskrevneResepter().size());


        } catch (UlovligUtskrift e) {
            throw new RuntimeException(e);
        }

//        BlaaResept blaaResept = new BlaaResept(narkotisk, legeEmilie, emiliePasient, testReit);
//        HvitResept hvitResept = new HvitResept(narkotisk, legeEmilie, testPasientId, testReit);
//        MilResept milResept = new MilResept(narkotisk, legeEmilie, 1);
//        PResept pResept = new PResept(narkotisk, legeEmilie, testPasientId, testReit);



//        List<Integer> l2 = new ArrayList<Integer>();
//
//        List<Integer> lak = List.of(1, 2, 3, 3,3,3,3,3);
//
//        Set<Integer> set1 = Set.of(1,2,3);
//        set1.
//        set1.add(3);
//
//        System.out.println(lak);



    }
}
