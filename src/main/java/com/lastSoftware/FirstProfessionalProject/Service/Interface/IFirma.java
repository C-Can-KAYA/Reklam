package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Firma;

import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.FirmaResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface IFirma {
    FirmaResponse firmaAdd(FirmaBilgi firmaBilgi) throws Exception;
    MessageResponse deleteById(Long id) throws Exception;
    Optional<Firma> findById(Long number);
    FirmaResponse updateFirma(FirmaBilgi firmaBilgi) throws Exception;
    List<Firma> list();
}
