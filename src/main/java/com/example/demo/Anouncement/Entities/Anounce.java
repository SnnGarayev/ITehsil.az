package com.example.demo.Anouncement.Entities;
import com.example.demo.Anouncement.Enums.AnounceStatus;
import com.example.demo.Anouncement.Enums.AnounceType;
import com.example.demo.SpecialitySelection.Entities.City;
import com.example.demo.User.Entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "anounce")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anounce {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
@JoinColumn(name = "user_id",referencedColumnName = "id")
private User user;

@ManyToOne
@JoinColumn(name = "city_id")
private City city;

@Column(name = "subAnounceId")
private Long subAnounceId;

@Enumerated(EnumType.STRING)
@Column(name = "anounce_status")
private AnounceStatus status;

@Enumerated(EnumType.STRING)
@Column(name = "anounce_type")
private AnounceType anounceType;

@Column(name = "price")
private Long price;

@Column(name = "sharing_Date")
private LocalDateTime sharingDate;

@Column(name = "companyName")
private String companyName;

@Column(name = "eMail")
private String eMail;

@Column(name = "managerName")
private String managerName;

@ElementCollection
@Column(name = "phoneList")
private List<String> phoneList;

@Column(name = "title")
private String title;


}
