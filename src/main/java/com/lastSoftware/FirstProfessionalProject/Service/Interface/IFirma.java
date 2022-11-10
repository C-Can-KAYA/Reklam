package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Firma;

import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface IFirma {
    MessageResponse firmaAdd(FirmaBilgi firmaBilgi);
    MessageResponse deleteById(Long id);
    Optional<Firma> findById(Long number);
    MessageResponse updateFirma(FirmaBilgi firmaBilgi);
    List<Firma> list();
}
