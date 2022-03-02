package uz.pdp.apprailwayapi.bookings.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.schedule.entity.ScheduleEntity;
import uz.pdp.apprailwayapi.stations.entity.StationsEntity;
import uz.pdp.apprailwayapi.statuses.entity.StatusesEntity;
import uz.pdp.apprailwayapi.tickets.entity.TicketsEntity;
import uz.pdp.apprailwayapi.user.entity.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bookings")
public class BookingsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private StatusesEntity status;

    @Column(nullable = false)
    private double totalPrice;

    @Column(nullable = false)
    private double singlePrice;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private ScheduleEntity schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_station_id", referencedColumnName = "id")
    private StationsEntity fromStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_station_id", referencedColumnName = "id")
    private StationsEntity toStation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "bookings")
    private List<TicketsEntity> tickets;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;



}
