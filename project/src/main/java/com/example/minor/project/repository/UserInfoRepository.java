package com.example.minor.project.repository;

import com.example.minor.project.models.entity.UserInfo;
import com.example.minor.project.models.entity.enums.UserStatus;
import com.example.minor.project.models.entity.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    //check if user already exists
    Optional<UserInfo> findByEmailIdOrPhoneNumber(String emailId, Long phoneNumber);

    Optional<UserInfo> findByIdAndUserTypeAndUserStatus(String userId, UserType userType, UserStatus userStatus);
}
