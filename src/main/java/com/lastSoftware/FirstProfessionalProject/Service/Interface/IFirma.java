package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Firma;

import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.FirmaBilgileri;

import java.util.List;
import java.util.Optional;

public interface IFirma {
    public String firmaAdd(FirmaBilgi firmaBilgi);
    public String deleteById(Long id);
    public Optional<Firma> findById(Long number);
    public List<FirmaBilgileri> list();
}
