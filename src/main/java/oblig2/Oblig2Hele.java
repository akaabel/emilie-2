package oblig2;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.*;
import java.io.*;

public class Oblig2Hele {

    public static void main(String[] args) {
        try {
            File minFil = new File(args[0]+"/metadata.csv");
            Scanner minScanner = new Scanner(minFil);

            File katalog = new File(args[0]);
            File[] innhold = katalog.listFiles();

            int antallTraader = 8;

            Monitor2 positivMonitor = new Monitor2();
            Monitor2 negativMonitor = new Monitor2();
            CountDownLatch barriere = new CountDownLatch(innhold.length-1);
            System.out.println("Venter paa aa legge til traader...");

            while(minScanner.hasNext()) {
                var linje = minScanner.nextLine();
                System.out.println("Linje er: " + linje);

                String[] linjer = linje.trim().split(",");

                if(Boolean.valueOf(linjer[1].toLowerCase())){
                    Thread t = new Thread(new LeseTrad(args[0] + "/" + linjer[0], positivMonitor, barriere));
                    t.run();
                } else {
                    Thread t = new Thread(new LeseTrad(args[0] + "/" + linjer[0], negativMonitor, barriere));
                    t.run();
                }
            }
            System.out.println("Alle linjer er ferdig lest");
            try {
                barriere.await();
                System.out.println("Lagt til traader.");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            CountDownLatch slaaSammenBarriere = new CountDownLatch(16);
            System.out.println("Venter paa aa flette sammen traader...");
            for(int i = 0; i < antallTraader; i++) {
                Thread t = new Thread(new FletteTrad(positivMonitor, slaaSammenBarriere));
                t.start();
            }
            for(int i = 0; i < antallTraader; i++) {
                Thread t = new Thread(new FletteTrad(negativMonitor, slaaSammenBarriere));
                t.start();
            }
            try {
                slaaSammenBarriere.await();
                System.out.println("Ferdig med aa vente");

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());

            }
            HashMap<String,Subsekvens> endeligHashMapPositiv = positivMonitor.taUt();
            HashMap<String,Subsekvens> endeligHashMapNegativ = negativMonitor.taUt();
            HashMap<String,Subsekvens> flestForekomsterPositiv = new HashMap<String,Subsekvens>();

            for(String subsekvensPositiv : endeligHashMapPositiv.keySet()) {
                if(endeligHashMapNegativ.containsKey(subsekvensPositiv)) {
                    if(endeligHashMapPositiv.get(subsekvensPositiv).hentAntall() > endeligHashMapNegativ.get(subsekvensPositiv).hentAntall() + 7) {
                        flestForekomsterPositiv.put(subsekvensPositiv,endeligHashMapPositiv.get(subsekvensPositiv));
                    }
                }
            }
            System.out.println("Disse sekvensene finnes hos positive minst syv ganger mer enn hos negative: ");
            for(String subsekvens : flestForekomsterPositiv.keySet()) {
                System.out.println(subsekvens + ": " + flestForekomsterPositiv.get(subsekvens).hentAntall());
            }
            minScanner.close();

        } catch (FileNotFoundException error) {
            System.out.println("Finner ikke filen.");
            error.printStackTrace();
        }
    }
}
