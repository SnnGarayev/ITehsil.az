package com.example.demo.SpecialitySelection.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "groups",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name","degree_id"})})
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


    //Role Many to one


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "degree_id",referencedColumnName = "id")
    private Degree degree;
}
