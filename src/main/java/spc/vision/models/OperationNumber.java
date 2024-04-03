package spc.vision.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperationNumber {

    OP8010("OP 8010"),
    OP8050("OP 8050"),
    OP8100("OP 8100"),
    OP8400("OP 8400"),
    OP8500("OP 8500"),
    OP8950("OP 8950"),
    OP9000("OP 9000"),
    OP9100("OP 9100"),
    OP9200("OP 9200");

    private final String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }

}