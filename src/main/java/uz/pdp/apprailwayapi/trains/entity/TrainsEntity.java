package uz.pdp.apprailwayapi.trains.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import uz.pdp.apprailwayapi.schedule.entity.ScheduleEntity;
import uz.pdp.apprailwayapi.wagons.entity.WagonEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "trains")
public class TrainsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    private boolean isActive=true;
   // @Column(nullable = false)

    private int count_wagon;

  //  @Column(nullable = false)
    private int free_seats;

    @Column(nullable = false)
    private double speed;
@JsonIgnore
    @OneToMany(mappedBy = "trains",
//            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private List<WagonEntity> wagons ;



    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            joinColumns = { @JoinColumn(name = "train_id") },
            inverseJoinColumns = { @JoinColumn(name = "schedule_id") }
    )
    Set<ScheduleEntity> schedules = new HashSet<>();
}
