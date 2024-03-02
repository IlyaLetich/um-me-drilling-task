package by.upmebel.upmecutfile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "holes")
public class Hole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "furniture_id")
    private Furniture furniture;

    @Column(name = "diameter")
    private Float diameter;

    @Column(name = "depth")
    private Float depth;

    @Column(name = "entry_speed")
    private Float entrySpeed;

    @Column(name = "exit_speed")
    private Float exitSpeed;

    @Column(name = "x")
    private Float x;

    @Column(name = "y")
    private Float y;

    @Column(name = "z")
    private Float z;
}