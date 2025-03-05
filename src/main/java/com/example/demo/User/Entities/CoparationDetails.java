package com.example.demo.User.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coparation_details")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoparationDetails {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "about")
    private Long about;

    @Column(name = "image")
    private String image;

//    @OneToOne(fetch = FetchType.EAGER,mappedBy = "coparationDetails")
//    private User userid;

}
