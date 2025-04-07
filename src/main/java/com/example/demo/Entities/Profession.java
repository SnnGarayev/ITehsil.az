package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professions", indexes = {
        @Index(name = "idx_professions_name",columnList = "name",unique = true),
        @Index(name = "idx_professions_group",columnList = "group_id")})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profession {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private Group group;

}

