package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Iller;
import com.lastSoftware.FirstProfessionalProject.Web.Request.IlRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.IlResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;

import java.util.List;

public interface IIller {
    IlResponse addIl(IlRequest ilRequest) throws Exception;
    MessageResponse deleteById(Long id) throws Exception;
    IlResponse ilUpdate(IlRequest ilRequest) throws Exception;
    List<Iller> findAll();

}
