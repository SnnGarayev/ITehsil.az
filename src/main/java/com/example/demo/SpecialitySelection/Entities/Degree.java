package com.example.demo.SpecialitySelection.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "degrees")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Degree {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

//    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private List<Group> gorups;


}
