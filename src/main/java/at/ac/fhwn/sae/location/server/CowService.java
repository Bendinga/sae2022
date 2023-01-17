package at.ac.fhwn.sae.location.server;

import at.ac.fhwn.sae.lesson3.Cow;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class CowService extends LocationService {

    Hashtable<Integer, Cow> cows = new Hashtable<>();


    public void helloWorld(Cow cow, int index){
        System.out.println("Hello World!");

        cows.put(index,cow);

    }

    public Hashtable<Integer, Cow> getCows() {
        return cows;
    }

}
