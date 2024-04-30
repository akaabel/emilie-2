package oblig2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class FletteTrad implements Runnable {
    Monitor2 monitor = null;
    CountDownLatch barriere = null;

    FletteTrad(Monitor2 monitor, CountDownLatch barriere) {
        this.monitor = monitor;
        this.barriere = barriere;
    }

    public void run() {
        System.out.println("I FletteTrad.settInn(): run(): " + Thread.currentThread().getId());

        while (!Thread.interrupted()) {

            ArrayList<HashMap<String, Subsekvens>> toHasher = monitor.hentToHasher();
            if (Thread.interrupted()) {
                barriere.countDown();
                return;
            }

            HashMap<String, Subsekvens> hashMap1 = toHasher.get(0);
            HashMap<String, Subsekvens> hashMap2 = toHasher.get(1);
            HashMap<String, Subsekvens> nyHashMap = monitor.slaaSammen(hashMap1, hashMap2);
            monitor.settInnFlette(nyHashMap);
 
        }
    } 
}
