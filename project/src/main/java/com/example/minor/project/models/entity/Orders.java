package com.example.minor.project.models.entity;

import com.example.minor.project.models.entity.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Audited

//orderby is keyword in mysql so Order name of class causes error
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    String id;

    @Enumerated(value = EnumType.STRING)
    OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties(value = "orderList")
    @ToString.Exclude

    UserInfo createdBy;

    Long amountPaidByUser;  // Need to create the API for the amount returned to user from the money owed by library

    @OneToMany(mappedBy = "mappedWithOrder")
    @NotAudited
    List<Books> books;

    /*
    * after 20days the fine and other things would be computed
    * */

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
}
