package com.example.demo.Anouncement.Entities;
import com.example.demo.MergeInterfaces.IAnouncesSubClasses;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course_anounce")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseAnounce implements IAnouncesSubClasses {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
@JoinColumn(name = "category_id",referencedColumnName = "id")
private AnounceCategory category;

@Column(name = "about")
private String about; //Melumat


}
