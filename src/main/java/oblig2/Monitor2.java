package oblig2;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class Monitor2 {

    SubsekvensRegister subsekvensRegister = new SubsekvensRegister();
    Lock laas = new ReentrantLock(true);
    int aktiveTrader = 0;
    Condition ikkeTom = laas.newCondition();

    public void settInn(HashMap<String, Subsekvens> nyHashMap) {
        System.out.println("I Monitor2.settInn(): begin: " + Thread.currentThread().getId());
        laas.lock();
        try {
            subsekvensRegister.settInn(nyHashMap);
            ikkeTom.signalAll();
        } finally {
            System.out.println("I Monitor2.settInn(): unlock: " + Thread.currentThread().getId());
            laas.unlock();
        }
        System.out.println("I Monitor2.settInn(): end: " + Thread.currentThread().getId());
    }

    public HashMap<String, Subsekvens> taUt() {
        laas.lock();
        try {
            while(subsekvensRegister.antallHashMaps() < 1) {
                ikkeTom.await();
            }
            HashMap<String, Subsekvens> hentetHashMap = subsekvensRegister.taUt();
            return hentetHashMap;
        } catch(InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            laas.unlock();
        }
    }

    public int antallHashMaps() {
        return subsekvensRegister.antallHashMaps();
    }

    public HashMap<String, Subsekvens> lagHashMap(String filnavn) {
        return SubsekvensRegister.lagHashMap(filnavn);
    }

    public HashMap<String, Subsekvens> slaaSammen(HashMap<String, Subsekvens> hashMap1, HashMap<String, Subsekvens> hashMap2) {
        laas.lock();
        HashMap<String, Subsekvens> nyHashMap = SubsekvensRegister.slaaSammen(hashMap1, hashMap2);
        laas.unlock();
        return nyHashMap;
    }

    public ArrayList<HashMap<String, Subsekvens>> hentToHasher() {
        ArrayList<HashMap<String, Subsekvens>> toHasher = new ArrayList<HashMap<String, Subsekvens>>();
        laas.lock();
        try {
            while (subsekvensRegister.antallHashMaps() < 2) {
                if (subsekvensRegister.antallHashMaps() == 1 && aktiveTrader == 0) {
                    Thread.currentThread().interrupt();
                    return null;
                } ikkeTom.await();
            }
            toHasher.add(subsekvensRegister.taUt());
            toHasher.add(subsekvensRegister.taUt());
            aktiveTrader++;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            laas.unlock();
        }
        return toHasher;
    }

    public void settInnFlette(HashMap<String, Subsekvens> nyHashMap) {
        laas.lock();
        try {
            subsekvensRegister.settInn(nyHashMap);
            aktiveTrader--;
            ikkeTom.signalAll();
        } finally {
            laas.unlock();
        }
    }
}
