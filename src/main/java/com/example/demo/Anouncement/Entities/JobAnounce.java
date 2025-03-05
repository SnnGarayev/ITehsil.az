package com.example.demo.Anouncement.Entities;

import com.example.demo.MergeInterfaces.IAnouncesSubClasses;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_anounce")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAnounce implements IAnouncesSubClasses {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
@JoinColumn(name = "category_id",referencedColumnName = "id")
private AnounceCategory category;

@Column(name = "position")
private String position; //Vezife Middle Backend ve.s

@Column(name = "experience")
private String experience;  //Tecrube

@Column(name = "jobInfo")
private String jobInfo;


}
