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

    @OneToMany(mappedBy = "stations",//It is a link between booking_from_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BookingsEntity> bookings ;

    @OneToMany(mappedBy = "stations",//It is a link between prices_from_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<PricesEntity> prices ;

    @OneToMany(mappedBy = "stations",//It is a link between schedule_from_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ScheduleEntity> schedules ;

    @OneToMany(mappedBy = "stations",//It is a link between travel_station and station_id
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<TravelLineEntity> travelLines ;

    //Can we create OneToMany connection two times with 2 tables
    //from_station_id -> id
    //to_station_id -> id

//    @OneToMany(mappedBy = "stations",//It is a link between schedule_to_station and station_id
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<ScheduleEntity> schedules ;

//    @OneToMany(mappedBy = "stations",//It is a link between prices_to_station and station_id
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<PricesEntity> prices ;


//    @OneToMany(mappedBy = "stations",  //It is a link between booking_to_station and station_id
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<BookingsEntity> bookings ;
}
