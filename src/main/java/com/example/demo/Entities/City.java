package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "cities",indexes = @Index(name = "idx_cities_name",columnList = "name",unique = true))
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city")
//    private List<UniCity> uniCities;

}
