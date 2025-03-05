package com.example.demo.User.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "roles")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private List<User> users;
}
