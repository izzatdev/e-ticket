package uz.pdp.apprailwayapi.stations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.prices.entity.PricesEntity;
import uz.pdp.apprailwayapi.schedule.entity.ScheduleEntity;
import uz.pdp.apprailwayapi.travelLine.entity.TravelLineEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    //Albatta unique
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String district;

    @OneToMany(mappedBy = "toStation",//It is a link between booking_from_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BookingsEntity> bookings ;

    @OneToMany(mappedBy = "fromStation",//It is a link between prices_from_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<PricesEntity> prices ;

    @OneToMany(mappedBy = "fromStation",//It is a link between schedule_from_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ScheduleEntity> schedules ;

    @OneToMany(mappedBy = "toStation",//It is a link between schedule_to_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ScheduleEntity> scheduleEntities ;
//

    @OneToMany(mappedBy = "station")
    private Set<TravelLineEntity> travelLineEntity ;

    //Can we create OneTo statuses any connection two times with 2 tables
    //from_station_id -> id
    //to_station_id -> id

    @OneToMany(mappedBy = "toStation",//It is a link between prices_to_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<PricesEntity> pricesEntities ;

    @OneToMany(mappedBy = "fromStation",  //It is a link between booking_to_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BookingsEntity> bookingsEntities ;
}
