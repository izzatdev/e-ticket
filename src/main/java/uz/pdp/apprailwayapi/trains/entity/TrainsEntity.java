package uz.pdp.apprailwayapi.trains.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.schedule.entity.ScheduleEntity;
import uz.pdp.apprailwayapi.wagons.entity.WagonEntity;

import javax.persistence.*;
import java.util.HashSet;
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

    @Column(nullable = false,unique = true)
    private String name;

   // @Column(nullable = false)

    private int count_wagon;

  //  @Column(nullable = false)
    private int free_seats;

    @Column(nullable = false)
    private double speed;

    @OneToMany(mappedBy = "trains",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private Set<WagonEntity> wagons ;



    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            joinColumns = { @JoinColumn(name = "train_id") },
            inverseJoinColumns = { @JoinColumn(name = "schedule_id") }
    )
    Set<ScheduleEntity> schedules = new HashSet<>();
}
