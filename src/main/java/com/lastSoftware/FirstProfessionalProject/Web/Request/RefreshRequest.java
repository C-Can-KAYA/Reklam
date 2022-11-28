package com.lastSoftware.FirstProfessionalProject.Web.Request;

import lombok.Data;

@Data
public class RefreshRequest {

    Long userId;
    String refreshToken;
}