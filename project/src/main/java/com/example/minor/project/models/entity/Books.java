package com.example.minor.project.models.entity;

import com.example.minor.project.models.entity.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


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

    Integer securityDeposit;

    @Enumerated(value = EnumType.STRING)
    BookStatus bookStatus;



    @ManyToOne // w.r.t books
    @JoinColumn
    @JsonIgnoreProperties(value = "associatedBooks")
            @ToString.Exclude
    Author associatedAuthor;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = "loanedBook")
    @ToString.Exclude
    UserInfo loanedToUser;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = "books")
    @ToString.Exclude
    Orders mappedWithOrder;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.bookStatus=BookStatus.AVAILABLE;

        /*
        * dynamic securityDeposit--> expose it via api
        * */
        this.securityDeposit=250;
    }
}
