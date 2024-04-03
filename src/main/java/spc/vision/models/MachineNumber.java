package spc.vision.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MachineNumber {

    M1("M1"),
    M2("M2"),
    M3("M3"),
    M4("M4"),
    M5("M5"),
    M6("M6");

    private final String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }

}