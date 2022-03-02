package uz.pdp.apprailwayapi.wagons.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.prices.entity.PricesEntity;
import uz.pdp.apprailwayapi.seats.entity.SeatsEntity;
import uz.pdp.apprailwayapi.trains.entity.TrainsEntity;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "wagons")
public class WagonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int order_number;

    @Column(nullable = false)
    private int total_seats;

//    @Column(nullable = false)
//    private int free_seats;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    private TrainsEntity trains;

    @OneToMany(mappedBy = "wagons",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<SeatsEntity> seats ;

    @OneToOne(mappedBy = "wagon",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private PricesEntity price ;
}
