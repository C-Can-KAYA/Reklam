package com.lastSoftware.FirstProfessionalProject.Web.Response;

import lombok.Data;

@Data
public class AuthResponse {

    String message;
    Long userId;
    String accessToken;
    String refreshToken;
}