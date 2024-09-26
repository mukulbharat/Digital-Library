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
public class BooksOld {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String isbn;

    @ManyToMany(mappedBy = "booksLiked")
    Set<UserInfoOld> likedByUsers;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;


}
