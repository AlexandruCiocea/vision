package spc.vision.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeOfPart {

    MY21_Pack1("MY21 Pack1"),
    MY21_Pack2("MY21 Pack2"),
    MY26("MY26");

    private final String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }

}
