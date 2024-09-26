package com.example.minor.project.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    String errorCode;
    String errorMessage;
}
