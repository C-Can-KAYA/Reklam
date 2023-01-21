package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Hat;
import com.lastSoftware.FirstProfessionalProject.Web.Request.HatRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface IHat {
    MessageResponse hatAdd(HatRequest hatRequest);
    MessageResponse deleteById(Long id);
    Optional<Hat> findById(Long id);
    List<Hat> findByPlateNumber(Integer number);
    MessageResponse updateHat(HatRequest hatRequest);
    List<Hat> findAll();
}
