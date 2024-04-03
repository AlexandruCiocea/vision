package spc.vision.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeOfMeasure {

    FIRST_OFF("FO"),
    SPC("SPC"),
    CORRECTION("CORRECTION"),
    SETTINGS("SETTINGS");

    private final String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }

}