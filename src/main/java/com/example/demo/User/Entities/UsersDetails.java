package com.example.demo.User.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_details")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDetails {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surName")
    private String surName;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "image")
    private String image;

//    @OneToOne(fetch = FetchType.EAGER,mappedBy = "usersDetails")
//    private User userid;
}
