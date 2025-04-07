package com.example.demo.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "uni_city",indexes = {
        @Index(name = "idx_uni_city_city_university",columnList = "city_id, university_id",unique = true),
        @Index(name = "idx_uni_city_city",columnList = "city_id"),
        @Index(name = "idx_uni_city_university",columnList = "university_id")
})
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
