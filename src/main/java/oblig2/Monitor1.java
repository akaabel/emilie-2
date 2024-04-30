package oblig2;

import java.util.HashMap;
import java.util.concurrent.locks.*;

public class Monitor1 {

    SubsekvensRegister subsekvensRegister = new SubsekvensRegister();
    Lock laas = new ReentrantLock();

    public void settInn(HashMap<String,Subsekvens> nyHashMap){
        laas.lock();
        try {
            subsekvensRegister.settInn(nyHashMap);
        } finally {
            laas.unlock();
        }
    }

    public HashMap<String,Subsekvens> taUt() throws InterruptedException {
        laas.lock();
        try {
            HashMap<String,Subsekvens> hentetHashMap = subsekvensRegister.taUt();
            return hentetHashMap;
        } finally {
            laas.unlock();
        }

    }
    public int antallHashMaps() {
        return subsekvensRegister.antallHashMaps();
    }
    
    public HashMap<String,Subsekvens> lagHashMap(String filnavn) {
        return SubsekvensRegister.lagHashMap(filnavn);
    }

    public HashMap<String, Subsekvens> slaaSammen(HashMap<String,Subsekvens> hashMap1, HashMap<String,Subsekvens> hashMap2) {
        return SubsekvensRegister.slaaSammen(hashMap1, hashMap2);
    }
}
