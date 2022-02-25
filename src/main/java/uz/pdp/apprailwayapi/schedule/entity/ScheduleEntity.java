package uz.pdp.apprailwayapi.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.seats.entity.SeatsEntity;
import uz.pdp.apprailwayapi.stations.entity.StationsEntity;
import uz.pdp.apprailwayapi.trains.entity.TrainsEntity;
import uz.pdp.apprailwayapi.travelLine.entity.TravelLineEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "schedule")
public class ScheduleEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fromTime;

    private double travelTime;

    private LocalDateTime arrivalTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_station_id", referencedColumnName = "id")
    private StationsEntity fromStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_station_id", referencedColumnName = "id")
    private StationsEntity toStation;

    @OneToMany(mappedBy = "schedule")


    private Set<TravelLineEntity> travelLineEntity ;

    @OneToMany(mappedBy = "schedule",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<BookingsEntity> bookings ;

    @ManyToMany(mappedBy = "schedules")
    private Set<TrainsEntity> trains = new HashSet<>();
}