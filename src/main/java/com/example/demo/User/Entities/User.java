package com.example.demo.User.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mail",unique = true)
    private String mail;

    @Column(name = "number",unique = true)
    private String number;

    @Column(name = "password")
    private String password;

    @Column(name = "coparation")
    private boolean coparation;

//    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private CoparationDetails coparationDetails;
//
//    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private UsersDetails usersDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_users",joinColumns = @JoinColumn(name = "user_Id")
            , inverseJoinColumns = @JoinColumn(name = "role_Id",referencedColumnName = "id"))
    private List<Role> roles;



//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles" ,
//            joinColumns = @JoinColumn(name = "user_id" ),
//            inverseJoinColumns = @JoinColumn(name = "role_id" ))
//    private List<Role> roles;






}
