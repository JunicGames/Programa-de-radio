package app;

import java.util.List;
import java.util.Map;

public interface IRadio {// start on default value 102.5 FM or last saved value
    void turnOn();
    void turnOff();

    //change between AM and FM
    void toggleStationType();

    //should return null when its turned off
    StationValue getCurrentStation();

    //should do nothing when its turned off
    void goForward();

    // when it gets to the end of the list it should loop back to the beginning
    void goBackwards();
    void saveStation(StationValue station, int position);
    List<Map<Integer, StationValue>> getSavedStations();
    void selectStation(int position);
}