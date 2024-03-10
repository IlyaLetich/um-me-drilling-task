package by.upmebel.upmecutfile.dto;

import by.upmebel.upmecutfile.model.Furniture;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HoleCreateDTO {
    private Long furnitureId;
    private Float diameter;
    private Float depth;
    private Float entrySpeed;
    private Float exitSpeed;
    private Float x;
    private Float y;
    private Float z;
}