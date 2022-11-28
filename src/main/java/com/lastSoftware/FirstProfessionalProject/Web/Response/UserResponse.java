package com.lastSoftware.FirstProfessionalProject.Web.Response;

import com.lastSoftware.FirstProfessionalProject.Entity.User;
import lombok.Data;

@Data
public class UserResponse {

    Long id;
    String userName;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.userName = entity.getUserName();
    }
}