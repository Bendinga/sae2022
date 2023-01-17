package at.ac.fhwn.sae.location.client;

import at.ac.fhwn.sae.lesson4.SaePoint;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class LocationClientService {

    private static final String REQUEST_METHOD_SET_LOCATION = "/setLocation";
    private static final String REQUEST_METHOD_GET_LOCATION = "/location";
    private static final String REQUEST_METHOD_GET_LOCATIONS = "/locations";
    private static final String REQUEST_METHOD_GET_ALL_LOCATIONS = "/allLocations";
    private static final String BASE_URL = "https://location-server-bendinger-location-app-api.azuremicroservices.io";

    public void sendLocation(SaePoint pointToSend, int id) {
        String url = BASE_URL + REQUEST_METHOD_SET_LOCATION + "?id=" + id + "&lat=" + pointToSend.getLatitude() + "&lon=" + pointToSend.getLongitude() + "&time=" + pointToSend.getTime() + "&satNr=" + pointToSend.getNumberOfSatelites() + "&fixQ=" + pointToSend.getFix();
        System.out.println(url);
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            System.out.println(scanner.nextLine());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SaePoint getLocation(int id) throws JsonProcessingException {
        String url = BASE_URL + REQUEST_METHOD_GET_LOCATION + "?id=" + id;
        String json = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            json = getResponseString(connection.getInputStream());
            //System.out.println(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ObjectMapper().readValue(json, SaePoint.class);
    }

    public List<SaePoint> getLocations(int id) throws JsonProcessingException {

        String url = BASE_URL + REQUEST_METHOD_GET_LOCATIONS + "?id=" + id;
        String json;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            json = getResponseString(connection.getInputStream());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ObjectMapper().readValue(json, new TypeReference<List<SaePoint>>() {
        });

    }

    public Hashtable<Integer, List<SaePoint>> getAllLocations() throws JsonProcessingException {


        String url = BASE_URL + REQUEST_METHOD_GET_ALL_LOCATIONS;
        String json;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            json = getResponseString(connection.getInputStream());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ObjectMapper().readValue(json, new TypeReference<Hashtable<Integer, List<SaePoint>>>() {
        });

    }

    private String getResponseString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        StringBuffer stringBuffer = new StringBuffer();
        while (scanner.hasNextLine()) {
            stringBuffer.append(scanner.nextLine());
        }
        return stringBuffer.toString();
    }


}

