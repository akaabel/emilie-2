package oblig2;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SubsekvensRegister {

    ArrayList<HashMap<String, Subsekvens>> hashMapListe = new ArrayList<HashMap<String, Subsekvens>>();

    public void settInn(HashMap<String, Subsekvens> nyHashMap){
        hashMapListe.add(nyHashMap);
    }
    
    public HashMap<String, Subsekvens> taUt(){
        return hashMapListe.remove(0);
    }

    public int antallHashMaps(){
        return hashMapListe.size();
    }

    public static HashMap<String, Subsekvens> lagHashMap(String filnavn){
        System.out.println("I SubsekvensRegister.lagHashMap(): begin: " + Thread.currentThread().getId());
        HashMap<String, Subsekvens> nyHashMap = new HashMap<String, Subsekvens>();
        File nyFil = new File(filnavn);
        try {
            Scanner scanner = new Scanner(nyFil);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
//                System.out.println("I SubsekvensRegister.lagHashMap(): while: " + Thread.currentThread().getName());
                String linje = scanner.nextLine();
                String[] splittetLinje = linje.split("");
                for (int i = 0; i < splittetLinje.length - 2; i++){
                    String subsekvensNavn = splittetLinje[i] + splittetLinje[i + 1] + splittetLinje[i + 2];
                    if (!nyHashMap.containsKey(subsekvensNavn)) {
                        Subsekvens subsekvens = new Subsekvens(subsekvensNavn, 1);
                        nyHashMap.put(subsekvensNavn, subsekvens);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Filen finnes ikke.");
            error.printStackTrace();
        }
        System.out.println("I SubsekvensRegister.lagHashMap(): end: " + Thread.currentThread().getId());
        return nyHashMap;
    }

    public static HashMap<String, Subsekvens> slaaSammen(HashMap<String, Subsekvens> hashMap1, HashMap<String, Subsekvens> hashMap2){
        HashMap<String, Subsekvens> sammenslaatt = hashMap1;
        Set<String> subsekvenserHashMap = hashMap2.keySet();
        for (String subsekvensNavn : subsekvenserHashMap) {
            if (!sammenslaatt.containsKey(subsekvensNavn)) {
                Subsekvens hentetSubsekvens1 = hashMap2.get(subsekvensNavn);
                sammenslaatt.put(subsekvensNavn, hentetSubsekvens1);

            } else {
                Subsekvens hentetSubsekvens2 = hashMap2.get(subsekvensNavn);
                Subsekvens hentetSubsekvensSammenslaatt = sammenslaatt.get(subsekvensNavn);
                int antallHashMap2 = hentetSubsekvens2.hentAntall();
                hentetSubsekvensSammenslaatt.endre(antallHashMap2);
            }
        }
        return sammenslaatt;
    }

}

