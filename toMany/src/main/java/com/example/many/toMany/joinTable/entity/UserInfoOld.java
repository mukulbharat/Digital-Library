package com.example.many.toMany.joinTable.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(indexes = {@Index(name = "UNIQUE_EMAIL", columnList = "emailId", unique = true)})
public class UserInfoOld {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;
    @Column(length = 15, unique = true)
    Long phoneNumber;
    String emailId;

    @ManyToMany
    @JoinTable(name = "wish_list",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    Set<BooksOld> booksLiked;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

}
