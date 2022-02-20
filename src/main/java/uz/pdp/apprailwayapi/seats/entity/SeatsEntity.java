package uz.pdp.apprailwayapi.seats.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.tickets.entity.TicketsEntity;
import uz.pdp.apprailwayapi.trains.entity.TrainsEntity;
import uz.pdp.apprailwayapi.wagons.entity.WagonEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "seats")
public class SeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int order_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wagon_id", referencedColumnName = "id")
    private WagonEntity wagons;

    @OneToMany(mappedBy = "seat",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<TicketsEntity> tickets ;
}
