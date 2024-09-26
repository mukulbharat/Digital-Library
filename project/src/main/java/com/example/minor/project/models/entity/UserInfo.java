package com.example.minor.project.models.entity;

import com.example.minor.project.models.entity.enums.UserStatus;
import com.example.minor.project.models.entity.enums.UserType;
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
@Table(indexes = {@Index(name = "UNIQUE_EMAIL", columnList = "emailId", unique = true)})
//@Index(name = "UNIQUE_PHONE_NUMBER", columnList = "phoneNumber", unique = true)
@Audited
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    @Column(length = 15, unique = true)
    Long phoneNumber;
    String emailId;

    @Enumerated(value = EnumType.STRING)
    UserType userType;

    @Enumerated(value = EnumType.STRING)
    UserStatus userStatus;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    @NotAudited
    List<Orders> orderList;

    @OneToMany(mappedBy = "loanedToUser", fetch = FetchType.LAZY)
    @NotAudited
    List<Books> loanedBook;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.userStatus=UserStatus.ACTIVE;
    }
}
