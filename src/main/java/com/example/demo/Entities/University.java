package com.example.demo.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "universities",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class University {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "cities_univercities",
//            joinColumns = @JoinColumn(name = "univercity_id"),
//            inverseJoinColumns = @JoinColumn(name = "city_id"))
//    private List<City> city;

}
