package com.example.demo.SpecialitySelection.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "uni_city", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"university_id","city_id"})})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniCity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    private City city;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id",referencedColumnName = "id")
    private University university;

}
