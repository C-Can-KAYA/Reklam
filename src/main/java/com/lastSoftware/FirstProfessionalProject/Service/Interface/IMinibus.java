package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Constants.Hat;
import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.ReklamGuncelle;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.ReklamResponseNumberPlate;
import com.lastSoftware.FirstProfessionalProject.Web.Response.ResponseMinibus;

import java.util.List;

public interface IMinibus {
    Minibus minibusAdd(MinibusBilgi minibusBilgi) throws Exception;
    MessageResponse deleteById(Long id) throws Exception;
    List<ReklamResponseNumberPlate> findByNumberPlate(String number);
    List<ResponseMinibus>  minibusList() throws Exception;
    Enum<Hat>[] ilList();
    List<String> hatList(String il);
    Object findById(Long id) throws Exception;
    List<Minibus> minibusUpdate(MinibusBilgi minibusBilgi) throws Exception;
    Boolean minibusReklamGuncelle(ReklamGuncelle reklamGuncelle) throws Exception;
}
