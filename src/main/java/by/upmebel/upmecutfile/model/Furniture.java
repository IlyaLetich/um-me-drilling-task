package by.upmebel.upmecutfile.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "furniture")
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "length")
    private Float length;

    @Column(name = "width")
    private Float width;

    @Column(name = "height")
    private Float height;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "furniture", cascade = CascadeType.ALL)
    private List<Hole> holes;
}