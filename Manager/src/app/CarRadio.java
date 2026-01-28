package app;

import java.util.*;

public class CarRadio implements IRadio {

    private boolean isOn;
    private StationType currentType;
    private StationValue currentStation;
    private List<Map<Integer, StationValue>> savedStations;

    public CarRadio() {
        isOn = false;
        currentType = StationType.FM;
        currentStation = null;
        savedStations = new ArrayList<>();
        savedStations.add(new HashMap<>());
    }

    @Override
    public void turnOn() {
        isOn = true;
        if (currentStation == null) {
            currentType = StationType.FM;
            currentStation = new StationValue(102.5, StationType.FM);
        }
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public void toggleStationType() {
        if (!isOn) return;

        if (currentType == StationType.FM) {
            currentType = StationType.AM;
            currentStation = new StationValue(530, StationType.AM);
        } else {
            currentType = StationType.FM;
            currentStation = new StationValue(87.9, StationType.FM);
        }
    }

    @Override
    public StationValue getCurrentStation() {
        if (!isOn) return null;
        return currentStation;
    }

    @Override
    public void goForward() {
        if (!isOn) return;

        if (currentType == StationType.FM) {
            double next = currentStation.getFrequency() + 0.2;
            if (next > 107.9) next = 87.9;
            currentStation = new StationValue(next, StationType.FM);
        } else {
            double next = currentStation.getFrequency() + 10;
            if (next > 1610) next = 530;
            currentStation = new StationValue(next, StationType.AM);
        }
    }

    @Override
    public void goBackwards() {
        if (!isOn) return;

        if (currentType == StationType.FM) {
            double prev = currentStation.getFrequency() - 0.2;
            if (prev < 87.9) prev = 107.9;
            currentStation = new StationValue(prev, StationType.FM);
        } else {
            double prev = currentStation.getFrequency() - 10;
            if (prev < 530) prev = 1610;
            currentStation = new StationValue(prev, StationType.AM);
        }
    }

    @Override
    public void saveStation(StationValue station, int position) {
        if (position < 1 || position > 12) return;
        savedStations.get(0).put(position, station);
    }

    @Override
    public List<Map<Integer, StationValue>> getSavedStations() {
        return savedStations;
    }

    @Override
    public void selectStation(int position) {
        if (!isOn) return;

        StationValue station = savedStations.get(0).get(position);
        if (station != null) {
            currentStation = station;
            currentType = station.getType();
        }
    }
}