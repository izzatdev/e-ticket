package uz.pdp.apprailwayapi.prices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.stations.entity.StationsEntity;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "prices")
public class PricesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double distance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_station_id", referencedColumnName = "id")
    private StationsEntity fromStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_station_id", referencedColumnName = "id")
    private StationsEntity toStation;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "wagon_id", referencedColumnName = "id")
    private Long wagon;



}
