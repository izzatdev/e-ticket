package uz.pdp.apprailwayapi.trains.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.district.entity.DistrictEntity;
import uz.pdp.apprailwayapi.wagons.entity.WagonEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "trains")
public class TrainsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int count_wagon;

    @Column(nullable = false)
    private int free_seats;

    @Column(nullable = false)
    private double speed;

    @OneToMany(mappedBy = "trains",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<WagonEntity> wagons ;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id", referencedColumnName = "train_id")
//    private ScheduleEntity schedules;
}
