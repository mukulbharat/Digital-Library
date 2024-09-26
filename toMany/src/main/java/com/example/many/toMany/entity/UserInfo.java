package com.example.many.toMany.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(indexes = {@Index(name = "UNIQUE_EMAIL", columnList = "emailId", unique = true)})
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;
    @Column(length = 15, unique = true)
    Long phoneNumber;
    String emailId;

    @OneToMany(mappedBy = "userInfo")
    List<BookRating> bookRating;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

}
