package com.example.demo.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "groups",uniqueConstraints = {@UniqueConstraint(columnNames = {"name","upGroup_id"})},indexes = {
        @Index(name = "idx_groups_name_degree",columnList = "name, degree_id",unique = true),
        @Index(name = "idx_groups_degree",columnList = "degree_id"),
        @Index(name = "idx_groups_upGroup",columnList = "upGroup_id")})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subGroup")
    private boolean subGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upGroup_id",referencedColumnName = "id")
    private Group upGroup;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "degree_id",referencedColumnName = "id")
    private Degree degree;
}
