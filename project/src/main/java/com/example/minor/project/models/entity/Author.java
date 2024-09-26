package com.example.minor.project.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    String id;
    String name;
    @Column(nullable = false)
    String emailId;

    //OneToMany
    @OneToMany(mappedBy = "associatedAuthor")
    @JsonIgnoreProperties(value = "associatedAuthor")
    @ToString.Exclude
    List<Books> associatedBooks;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
}


