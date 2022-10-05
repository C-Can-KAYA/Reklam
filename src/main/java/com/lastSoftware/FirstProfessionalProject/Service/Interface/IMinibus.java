package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Constants.Hat;
import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.ReklamResponse;

import java.util.List;

public interface IMinibus {
    String minibusAdd(MinibusBilgi minibusBilgi);
    String deleteById(Long id);
    List<ReklamResponse> findByNumberPlate(String number);
    List<Minibus> minibusList();
    Enum<Hat>[] ilList();
    List<String> hatList(String il);
    Object findById(Long id);
    Object minibusUpdate(MinibusBilgi minibusBilgi);
}
