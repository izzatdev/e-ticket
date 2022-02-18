package uz.pdp.apprailwayapi.bookings.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.statuses.entity.StatusesEntity;
import uz.pdp.apprailwayapi.user.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private Long schedule_id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "f_station_id", referencedColumnName = "id")
    private Long f_station_id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "to_station_id", referencedColumnName = "id")
    private Long to_station_id;

    @Column(name = "start_time", nullable = false)
    private Date startTime;











}
