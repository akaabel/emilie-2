package oblig2;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.io.*;

public class Oblig2Del2B {

    public static void main(String[] args) throws InterruptedException{

        try {
            File minFil = new File(args[0]+"/metadata.csv");
            Scanner minScanner = new Scanner(minFil);

            File katalog = new File(args[0]);
            File[] innhold = katalog.listFiles();
            
            int antallTrader = 8;

            Monitor2 monitor = new Monitor2();
            CountDownLatch barriere = new CountDownLatch(innhold.length -1);

            int teller = 0;
            while(minScanner.hasNext()) {
                teller++;
                Thread t = new Thread(new LeseTrad(args[0] + "/" + minScanner.nextLine(), monitor, barriere));
                System.out.println("Starter traad nummer: " + teller);
                t.run();
                System.out.println("Avslutter traad nummer: " + teller);
            }
            try {
                System.out.println("Avventer aa legge til");
                barriere.await();
                System.out.println("Ferdig");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            CountDownLatch slaaSammenBarriere = new CountDownLatch(8);

            for (int i = 0; i < antallTrader; i++) {
                Thread t = new Thread(new FletteTrad(monitor, slaaSammenBarriere));
                System.out.println("Starter traad nummer: " + i);
                t.start();
                System.out.println("Avslutter traad nummer: " + i);
            }
            try {
                System.out.println("Avventer aa slaa sammen");
                slaaSammenBarriere.await();
                System.out.println("Ferdig");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            HashMap<String, Subsekvens> endeligHashMap = monitor.taUt();
            Subsekvens flestForekomster = null;

            for(String subsekvens : endeligHashMap.keySet()) {
                if(flestForekomster==null || endeligHashMap.get(subsekvens).hentAntall()> flestForekomster.hentAntall()) {
                    flestForekomster = endeligHashMap.get(subsekvens);
                }
            }
            System.out.println(flestForekomster);
            minScanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Finner ikke filen.");
            error.printStackTrace();
        }

    }
    
}
