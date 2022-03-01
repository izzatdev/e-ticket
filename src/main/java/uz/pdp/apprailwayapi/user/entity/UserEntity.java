package uz.pdp.apprailwayapi.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.district.entity.DistrictEntity;
import uz.pdp.apprailwayapi.user.enums.DocType;
import uz.pdp.apprailwayapi.user.enums.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Column(nullable = false)
    private String password;

    @Column(nullable = true, unique = true)
    private String phoneNumber;

//    @Column(nullable = true)
    private String firstName;

//    @Column(nullable = false)
    private String lastName;

    @Column(name = "patronymic")
    private String fatherName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private DocType documentType;

    @Column(name = "document_series_number", nullable = true, unique = true)
    private String documentNumber;

//    @Column(name = "doc_given_district_name")
//    private String districtName;

    @Column(nullable = false)
    private boolean gender;

    @Column(nullable = true)
    private Date birthDate;

    private boolean isActive;

    @JsonIgnore
    @JsonProperty("country_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryEntity country;
    @JsonIgnore
    @JsonProperty("district_id")

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private DistrictEntity district;


    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingsEntity> bookings;
}