package by.upmebel.upmecutfile.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HoleUpdateWithPatternDTO {
    private Long holeId;
    private Long furnitureId;
    private Float diameter;
    private Float depth;
    private Float entrySpeed;
    private Float exitSpeed;
    private String coordinates;

}
