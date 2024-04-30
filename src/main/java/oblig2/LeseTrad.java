package oblig2;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class LeseTrad implements Runnable {

    String filnavn;
    Monitor2 monitor = null;
    CountDownLatch barriere = null;

    LeseTrad(String filnavn, Monitor2 monitor, CountDownLatch barriere) {
        this.filnavn = filnavn;
        this.monitor = monitor;
        this.barriere = barriere;
    }

    public void run() {
        HashMap<String, Subsekvens> nyHashMap = monitor.lagHashMap(filnavn);
        System.out.println("I LeseTrad.run(): " + Thread.currentThread().getId());
        monitor.settInn(nyHashMap);
        barriere.countDown();
    }
    
}
