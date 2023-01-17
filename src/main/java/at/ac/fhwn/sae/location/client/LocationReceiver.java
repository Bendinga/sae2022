package at.ac.fhwn.sae.location.client;

import at.ac.fhwn.sae.lesson3.Animal;
import at.ac.fhwn.sae.lesson4.NmeaReaderApplication;
import at.ac.fhwn.sae.lesson4.SaePoint;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class LocationReceiver {
    public static void main(String[] args) throws JsonProcessingException {
        LocationClientService locationClientService = new LocationClientService();
        int selection = 0;
        Scanner select = new Scanner(System.in);
        System.out.println("----- Location Receiver -----");
        System.out.println(" ");
        while (selection != 4){
            System.out.println("Was möchten Sie tun:");
            System.out.println(" ");
            System.out.println("1. Letzte Position mit id");
            System.out.println("2. Positionen mit id");
            System.out.println("3. Alle Positionen");
            System.out.println("4. Receiver beenden");

            selection = Integer.parseInt(select.next());

            if (selection == 1){
                System.out.println("Geben Sie die gewünschte id ein: ");
                int id = Integer.parseInt(select.next());
                SaePoint saePoint = locationClientService.getLocation(id);
                List<SaePoint> saePointList = new ArrayList<>();
                saePointList.add(saePoint);
                NmeaReaderApplication.printData(saePointList);
            }else if(selection == 2){
                System.out.println("Geben Sie die gewünschte id ein: ");
                int id = Integer.parseInt(select.next());
                List<SaePoint> saePointList = locationClientService.getLocations(id);
                NmeaReaderApplication.printData(saePointList);
            }else if(selection == 3){
                Hashtable<Integer, List<SaePoint>> saePointHashtable = locationClientService.getAllLocations();
                NmeaReaderApplication.printDataWithId(saePointHashtable);
            }else if(selection == 4){
                System.out.println("Programm wurde beendet!");
            }else{
                System.out.println("Falsche Eingabe: Versuche es erneut!");
            }

        }

    }

}
