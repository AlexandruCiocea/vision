package spc.vision.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UnitOfMachine {

    ALFA("ALFA"),
    TWINNER("TWINNER"),
    UNIT1("UNIT1"),
    UNIT2("UNIT2"),
    FULL("FULL"),
    SPINDLE1("SPINDLE1"),
    SPINDLE2("SPINDLE2"),
    SPINDLE3("SPINDLE3"),
    SPINDLE4("SPINDLE4");

    private final String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }

}