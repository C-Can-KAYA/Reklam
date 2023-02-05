package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Hat;
import com.lastSoftware.FirstProfessionalProject.Web.Request.HatRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.HatResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface IHat {
    HatResponse hatAdd(HatRequest hatRequest) throws Exception;
    MessageResponse deleteById(Long id) throws Exception;
    Optional<Hat> findById(Long id) throws Exception;
    List<Hat> findByPlateNumber(Integer number) throws Exception;
    HatResponse updateHat(HatRequest hatRequest) throws Exception;
    List<Hat> findAll();
}
