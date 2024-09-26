package com.example.minor.project.models.request;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateOrderRequest {

    @NotNull
    UUID userId;
    @NotNull
    UUID bookId;
}
