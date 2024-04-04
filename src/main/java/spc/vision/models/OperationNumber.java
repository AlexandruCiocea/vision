package spc.vision.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperationNumber {

    OP8010("OP8010"),
    OP8050("OP8050"),
    OP8100("OP8100"),
    OP8400("OP8400"),
    OP8500("OP8500"),
    OP8950("OP8950"),
    OP9000("OP9000"),
    OP9100("OP9100"),
    OP9200("OP9200");

    private final String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }

}