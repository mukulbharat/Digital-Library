package com.example.minor.project.repository;

import com.example.minor.project.models.entity.Author;
import com.example.minor.project.models.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, String> {


    Optional<Author> findByEmailId(String emailId);

    //write query in native sql as well as in SPEL
    @Query("select userinfo from UserInfo  userinfo where userinfo.id= :userId")
    Optional<UserInfo> getTheInformationInJPQLById(@Param("userId") String userId);
}
