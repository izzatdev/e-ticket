package uz.pdp.apprailwayapi.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.stations.entity.StationsEntity;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "schedule")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fromTime;

    private double travelTime;

    private Date toTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_station_id", referencedColumnName = "id")
    private StationsEntity fromStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_station_id", referencedColumnName = "id")
    private StationsEntity toStation;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "train_id", referencedColumnName = "id")
    private Long train;


}
