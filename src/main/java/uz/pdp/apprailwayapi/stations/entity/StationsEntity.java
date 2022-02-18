package uz.pdp.apprailwayapi.stations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "stations")
public class StationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // station name unique bolishi keremi yoqmi?
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String district;
}
