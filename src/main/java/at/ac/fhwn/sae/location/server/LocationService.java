package at.ac.fhwn.sae.location.server;

import at.ac.fhwn.sae.lesson4.SaePoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

@Service
public class LocationService {
    Hashtable<Integer, List<SaePoint>> locations = new Hashtable<>();

    public void addLocation(int id, SaePoint saePoint) {
        List<SaePoint> newLocations;
        if (locations.containsKey(id)) {
            newLocations = locations.get(id);
        } else {
            newLocations = new ArrayList<>();
        }
        newLocations.add(saePoint);
        locations.put(id, newLocations);

    }

    public SaePoint getLocation(int id, Integer index) {
        return locations.get(id).get(Objects.requireNonNullElseGet(index, () -> locations.get(id).size() - 1));
    }

    public List<SaePoint> getLocations(int id) {
        return locations.get(id);
    }

    public Hashtable<Integer, List<SaePoint>> getAllLocations() {
        return locations;
    }

}

