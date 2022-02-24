package uz.pdp.apprailwayapi.travelLine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.schedule.entity.ScheduleEntity;
import uz.pdp.apprailwayapi.stations.entity.StationsEntity;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "travel_line")
public class TravelLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,name = "station_order")
    private int order;

    @Column(nullable = false)
    private double stayTime;

    @ManyToOne()
    private StationsEntity station;


    @ManyToOne()
    private ScheduleEntity schedule;
}