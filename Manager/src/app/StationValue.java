package app;

public class StationValue {
    private double frequency;
    private StationType type;

    public StationValue(double frequency, StationType type) {
        this.frequency = frequency;
        this.type = type;
    }

    public double getFrequency() {
        return frequency;
    }

    public StationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " " + frequency;
    }
}