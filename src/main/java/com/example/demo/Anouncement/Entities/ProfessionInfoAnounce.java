package com.example.demo.Anouncement.Entities;

import com.example.demo.SpecialitySelection.Entities.Profession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "professionInfoAnounce")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionInfoAnounce {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "anounceHtml")
private String anounceHtml;

@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "anounce")
private List<Profession> professions;

}
