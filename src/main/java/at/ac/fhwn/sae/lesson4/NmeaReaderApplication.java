package at.ac.fhwn.sae.lesson4;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class NmeaReaderApplication {

    private final File file;
    private Scanner scanner;

    public NmeaReaderApplication(File nmeaFile) {

        try {
            file = nmeaFile;
            assert nmeaFile.exists();
            FileInputStream fis = new FileInputStream(nmeaFile);
            scanner = new Scanner(fis);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {


        List<SaePoint> GnggaData = new ArrayList<>();

        extracted(GnggaData);
        printData(GnggaData);


    }

    private static void extracted(List<SaePoint> GnggaData) throws FileNotFoundException {
        File file = new File(NmeaReaderApplication.class.getClassLoader().getResource("nmea.txt").getFile());
        System.out.println("Exists: " + file.exists());
        System.out.println("Can read: " + file.canRead());

        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNext()) {
            String[] components = scanner.nextLine().split(",");

            if (components[0].equals("$GNGGA")) {
                GnggaData.add(new SaePoint(components));
            }
        }
    }


    public static void printData(List<SaePoint> data) {
        System.out.println(String.format("%-10s| %-10s| %-10s| %-7s | %-4s", "time", "latitude", "longitude", "sat Nr.", "fix"));
        for (SaePoint saePoint : data) {
            System.out.println(String.format("%-10s| %-10f| %-10f| %-7d | %-4d", saePoint.getTime(), saePoint.getLatitude(), saePoint.getLongitude(), saePoint.getNumberOfSatelites(), saePoint.getFix()));
        }

    }

    public static void printDataWithId(Hashtable<Integer, List<SaePoint>> data) {
        System.out.println(String.format("%-4s| %-10s| %-10s| %-10s| %-7s | %-4s", "ID ","time", "latitude", "longitude", "sat Nr.", "fix"));
        //BiConsumer<? super Integer, ? super List<SaePoint>> key;
        //SaePoint[] value;
        List<Integer> keys = new ArrayList<>();
        data.forEach((key, value)
                -> keys.add(key));
        for (Integer key : keys) {
            for (SaePoint saePoint : data.get(key)) {
                System.out.println(String.format("%-4d| %-10s| %-10f| %-10f| %-7d | %-4d", key, saePoint.getTime(), saePoint.getLatitude(), saePoint.getLongitude(), saePoint.getNumberOfSatelites(), saePoint.getFix()));
            }
        }
            for(Map.Entry<Integer,List<SaePoint>> entry :data.entrySet()){
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());

            }

        }


    public SaePoint readPoint() {


        Boolean next = true;
        while (scanner.hasNext()) {
            String[] components = scanner.nextLine().split(",");

            if (components[0].equals("$GNGGA")) {
                return (new SaePoint(components));

            }
        }
        if (!scanner.hasNext()) {
            try {
                assert file.exists();
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(fis);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return this.readPoint();
        }


        return null;
    }
}
