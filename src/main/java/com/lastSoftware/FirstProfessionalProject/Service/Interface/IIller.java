package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Iller;
import com.lastSoftware.FirstProfessionalProject.Web.Request.IlRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;

import java.util.List;

public interface IIller {
    MessageResponse addIl(IlRequest ilRequest);
    MessageResponse deleteById(Long id);
    MessageResponse ilUpdate(IlRequest ilRequest);
    List<Iller> findAll();

}
