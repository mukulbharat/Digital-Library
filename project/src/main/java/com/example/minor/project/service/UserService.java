package com.example.minor.project.service;

import com.example.minor.project.exception.ExceptionCode;
import com.example.minor.project.exception.UserException;
import com.example.minor.project.models.entity.UserInfo;
import com.example.minor.project.models.entity.enums.UserStatus;
import com.example.minor.project.models.entity.enums.UserType;
import com.example.minor.project.models.request.CreateUserRequest;
import com.example.minor.project.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

   @Autowired
    UserInfoRepository repository;


    public UserInfo saveOrUpdate(UserInfo userInfo)
    {
        return repository.save(userInfo);
    }

    public UserInfo findActiveStudentById(UUID userId){
        return repository.findByIdAndUserTypeAndUserStatus(userId.toString(), UserType.STUDENT, UserStatus.ACTIVE)
                .orElseThrow(() -> new UserException(ExceptionCode.INVALID_USER));
    }

    public UserInfo createNewUser(CreateUserRequest userRequest){
        var newUser= userRequest.toUserInfo();
        log.info(" trying to create new user {} from request {}",newUser,userRequest);
        //find existing user if exists
        var existingUser= repository.findByEmailIdOrPhoneNumber(newUser.getEmailId(), newUser.getPhoneNumber());
        log.info(" existing user {}");
        //if it does throw exception
        if(existingUser.isPresent()){
            log.error(" user found {} throwing exception",existingUser);
            throw new UserException(ExceptionCode.USER_ALREADY_EXISTS);
        }
        //create new user
        var userInfo=saveOrUpdate(newUser);
        log.info(" created new user {}",userInfo);
        return userInfo;
    }
}
