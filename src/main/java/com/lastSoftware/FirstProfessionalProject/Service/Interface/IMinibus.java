package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Constants.Hat;
import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.ReklamGuncelle;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.ReklamResponseNumberPlate;

import java.util.List;

public interface IMinibus {
    MessageResponse minibusAdd(MinibusBilgi minibusBilgi);
    MessageResponse deleteById(Long id);
    List<ReklamResponseNumberPlate> findByNumberPlate(String number);
    List<Minibus> minibusList();
    Enum<Hat>[] ilList();
    List<String> hatList(String il);
    Object findById(Long id);
    MessageResponse minibusUpdate(MinibusBilgi minibusBilgi);
    MessageResponse minibusReklamGuncelle(ReklamGuncelle reklamGuncelle);
}
