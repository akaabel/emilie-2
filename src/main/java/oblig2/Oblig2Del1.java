package oblig2;

import java.util.*;
import java.io.*;

public class Oblig2Del1 {

    public static void main(String[] args) {
        try {
            File minFil = new File(args[0] + "metadata.csv");
            Scanner minScanner = new Scanner(minFil);

            SubsekvensRegister subReg = new SubsekvensRegister();
            while (minScanner.hasNext()) {
                HashMap<String, Subsekvens> nyHashMap = SubsekvensRegister.lagHashMap(args[0] + "/" + minScanner.nextLine());
                subReg.settInn(nyHashMap);
            }
            minScanner.close();

            while (subReg.antallHashMaps() > 1){
                HashMap<String, Subsekvens> hashMap1 = subReg.taUt();
                HashMap<String, Subsekvens> hashMap2 = subReg.taUt();
                HashMap<String, Subsekvens> nyHashMap = SubsekvensRegister.slaaSammen(hashMap1, hashMap2);
                subReg.settInn(nyHashMap);
            }
            HashMap<String, Subsekvens> endeligHashMap = subReg.taUt();
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
