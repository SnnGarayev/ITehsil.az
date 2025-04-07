package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// , uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"unicity_id","profession_id","study_Type","study_language"})} bunu 'elave et'
@Entity
@Table(name = "uni_professions",indexes = {
        @Index(name = "idx_uni_professions_profession_uni_city_study_language_in_person_class",
                columnList = "profession_id, unicity_id, in_person_class, study_language", unique = true)
})
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

    @Column(name = "in_person_class")
    private Boolean inPersonClass;


    @Column(name = "error_paid_max")
    private String errorPaidMax;

    @Column(name = "error_paid_min")
    private String errorPaidMin;

    @Column(name = "point_paid")
    private String pointPaid;

    @Column(name = "error_free_max")
    private String errorFreeMax;

    @Column(name = "error_free_min")
    private String errorFreeMin;

    @Column(name = "point_free")
    private String pointFree;

    @Column(name = "comment")
    private int comment;
}

