package uz.pdp.apprailwayapi.passengers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.tickets.entity.TicketsEntity;
import uz.pdp.apprailwayapi.passengers.enums.DocumentType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "passengers")
public class PassengersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "patronymic", nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private DocumentType documentType;

    @Column(name = "document_series_number", nullable = false, unique = true)
    private String documentNumber;

    @Column(name = "doc_given_district_name")
    private String districtName;

    @Column(nullable = false)
    private boolean gender;

    @Column(nullable = false)
    private Date birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryEntity country;

    @OneToMany(mappedBy = "passenger",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<TicketsEntity> tickets ;
}
