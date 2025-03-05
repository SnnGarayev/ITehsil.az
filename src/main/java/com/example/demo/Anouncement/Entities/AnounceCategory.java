package com.example.demo.Anouncement.Entities;

import com.example.demo.Anouncement.Enums.AnounceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anounce_Category",uniqueConstraints = {
		  @UniqueConstraint(columnNames = {"category_name","anounce_type"})})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnounceCategory {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "category_name")
private String categoryName;

@Enumerated(EnumType.STRING)
@Column(name = "anounce_type")
private AnounceType anounceType;

@Column(name = "isUp")
private boolean isUp;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "upCategory_id",referencedColumnName = "id")
private AnounceCategory upCategory;





}
