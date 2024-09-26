package com.example.minor.project.models.request;

import com.example.minor.project.models.entity.UserInfo;
import com.example.minor.project.models.entity.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank
    String name;
    @Positive
    Long phoneNumber;
    @Email
    String emailId;
    @NotNull
    UserType userType;


    public UserInfo toUserInfo(){
        return UserInfo.builder()
                .emailId(emailId)
                .name(name)
                .phoneNumber(phoneNumber)
                .userType(userType)
                        .build();
    }
}
