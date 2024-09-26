package com.example.many.toMany.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookRating {

    @EmbeddedId
    BookRatingId bookRatingId;

    Integer rating;

    @ManyToOne
    @MapsId(value = "userId")
    UserInfo userInfo;

    @ManyToOne
    @MapsId(value = "bookId")
    Books books;
}
