package app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRadioTest {

    private IRadio radio;

    @BeforeEach
    void setUp() {
        radio = new CarRadio();
        radio.turnOn();
    }

    @Test
    void testTurnOnDefaultStation() {
        StationValue station = radio.getCurrentStation();
        assertNotNull(station);
        assertEquals(StationType.FM, station.getType());
        assertEquals(102.5, station.getFrequency(), 0.01);
    }

    @Test
    void testGoForwardFM() {
        radio.goForward();
        StationValue station = radio.getCurrentStation();
        assertEquals(102.7, station.getFrequency(), 0.01);
    }

    @Test
    void testGoBackwardsFM() {
        radio.goBackwards();
        StationValue station = radio.getCurrentStation();
        assertEquals(102.3, station.getFrequency(), 0.01);
    }

    @Test
    void testSaveAndSelectStation() {
        StationValue current = radio.getCurrentStation();
        radio.saveStation(current, 1);

        radio.goForward(); // moverla
        radio.selectStation(1);

        StationValue selected = radio.getCurrentStation();
        assertEquals(current.getFrequency(), selected.getFrequency(), 0.01);
        assertEquals(current.getType(), selected.getType());
    }
}