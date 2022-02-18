package uz.pdp.apprailwayapi.statuses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

}
