package uz.pdp.apprailwayapi.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.user.enums.Doc_type;
import uz.pdp.apprailwayapi.user.enums.Role;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "patronymic", nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private Doc_type documentType;

    @Column(name = "document_series_number", nullable = false, unique = true)
    private String documentNumber;

//    @ManyToOne
//    private Country countries;

    @Column(name = "doc_given_district_name")
    private String districtName;

    @Column(nullable = false)
    private boolean gender;

    @Column(nullable = false)
    private Date birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryEntity country;
}