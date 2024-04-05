package spc.vision.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "register")
@NoArgsConstructor
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeOfPart typeOfPart;

    @Enumerated(EnumType.STRING)
    private TypeOfMeasure typeOfMeasure;

    @Enumerated(EnumType.STRING)
    private OperationNumber operationNumber;

    @Enumerated(EnumType.STRING)
    private MachineNumber machineNumber;

    @Enumerated(EnumType.STRING)
    private UnitOfMachine unitOfMachine;

    @Enumerated(EnumType.STRING)
    private StatusOfMeasurements statusOfMeasurements;

    private Boolean isComplete;

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp finishedAt;

    private String duration;


    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", typeOfPart=" + typeOfPart +
                ", typeOfMeasure=" + typeOfMeasure +
                ", machineNumber=" + machineNumber +
                ", operationNumber=" + operationNumber +
                ", unitOfMachine=" + unitOfMachine +
                ", statusOfMeasurements=" + statusOfMeasurements +
                ", isComplete=" + isComplete +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", finishedAt=" + finishedAt +
                ", duration='" + duration + '\'' +
                '}';
    }
}
