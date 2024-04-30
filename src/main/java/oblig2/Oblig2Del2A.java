package oblig2;

import java.util.*;
import java.io.*;
import java.util.concurrent.CountDownLatch;

public class Oblig2Del2A {
    public static void main(String[] args) throws InterruptedException {
        try {
            File minFil = new File(args[0] + "/metadata.csv");
            Scanner minScanner = new Scanner(minFil);

            Monitor2 monitor = new Monitor2();

            while (minScanner.hasNext()) {
                var linje = minScanner.nextLine();
                System.out.println("Linje er: " + linje);
                Thread t = new Thread(new LeseTrad((args[0] + "/" + linje), monitor, new CountDownLatch(10)));

                t.run();
            }
            minScanner.close();

            while (monitor.antallHashMaps() > 1){
                HashMap<String, Subsekvens> hashMap1 = monitor.taUt();
                HashMap<String, Subsekvens> hashMap2 = monitor.taUt();
                HashMap<String, Subsekvens> nyHashMap = SubsekvensRegister.slaaSammen(hashMap1, hashMap2);
                monitor.settInn(nyHashMap);
            }
            HashMap<String, Subsekvens> endeligHashMap = monitor.taUt();
            Subsekvens flestForekomster = null;

            for(String subsekvens : endeligHashMap.keySet()) {
                if(flestForekomster == null || endeligHashMap.get(subsekvens).hentAntall() > flestForekomster.hentAntall()) {
                    flestForekomster = endeligHashMap.get(subsekvens);
                }
            }
    
            System.out.println(flestForekomster);

        } catch (FileNotFoundException error){
            System.out.println("Filen finnes ikke.");
            error.printStackTrace();
        }

    }
    
}
