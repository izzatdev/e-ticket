package uz.pdp.apprailwayapi.statuses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.tickets.entity.TicketsEntity;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "statuses")
public class StatusesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // status name unique bolishi keremi yoqmi?
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "status",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BookingsEntity> bookings ;

    @OneToMany(mappedBy = "status",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<TicketsEntity> tickets ;
}
