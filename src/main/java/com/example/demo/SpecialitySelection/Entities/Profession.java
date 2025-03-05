package com.example.demo.SpecialitySelection.Entities;

import com.example.demo.Anouncement.Entities.ProfessionInfoAnounce;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professions", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"profession_name","grup_id"})} )
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profession {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="profession_name")
    private String professionName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "grup_id",referencedColumnName = "id")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anounce_id",referencedColumnName = "id",nullable = true)
    private ProfessionInfoAnounce anounce;

}

