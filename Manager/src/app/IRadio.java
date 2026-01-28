package app;

import java.util.List;
import java.util.Map;

public interface IRadio {

    void turnOn();
    void turnOff();
    void toggleStationType();

    StationValue getCurrentStation();

    void goForward();
    void goBackwards();
    void saveStation(StationValue station, int position);
    List<Map<Integer, StationValue>> getSavedStations();
    void selectStation(int position);
}