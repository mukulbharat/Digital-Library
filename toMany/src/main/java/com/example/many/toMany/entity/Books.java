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
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String isbn;

    @OneToMany(mappedBy = "books")
    List<BookRating> bookRatings;


    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
}
