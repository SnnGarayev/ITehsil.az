package com.example.demo.SpecialitySelection.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// , uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"unicity_id","profession_id","study_Type","study_language"})} bunu 'elave et'
@Entity
@Table(name = "uni_professions")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniProffession {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "profession_id",referencedColumnName = "id")
    private Profession profession;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "unicity_id",referencedColumnName = "id")
    private UniCity uniCity;

    @Column(name = "study_language")
    private String studyLanguage;

    @Column(name = "study_Type")
    private String studyType;

    @Column(name = "point_paid")
    private String pointPaid;

    @Column(name = "point_free")
    private String pointFree;

    @Column(name = "possibility")
    private int possibility;

    @Column(name = "comment")
    private int comment;
}

