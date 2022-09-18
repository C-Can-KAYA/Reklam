package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Firma;

import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;

import java.util.List;
import java.util.Optional;

public interface IFirma {
    String firmaAdd(FirmaBilgi firmaBilgi);
    String deleteById(Long id);
    Optional<Firma> findById(Long number);
    String updateFirma(FirmaBilgi firmaBilgi);
    List<Firma> list();
}
