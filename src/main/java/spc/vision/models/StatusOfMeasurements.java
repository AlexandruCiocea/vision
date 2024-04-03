package spc.vision.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusOfMeasurements {

    MEASUREMENTS_NOT_STARTED("MEASUREMENTS NOT STARTED"),
    MEASUREMENTS_IN_PROGRESS("MEASUREMENTS IN PROGRESS"),
    MEASUREMENTS_FINISHED("MEASUREMENTS FINISHED");

    private final String stringValue;


    @Override
    public String toString() {
        return stringValue;
    }

}