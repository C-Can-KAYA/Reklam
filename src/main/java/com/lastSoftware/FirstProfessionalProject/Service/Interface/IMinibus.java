package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Constants.Hat;
import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.ReklamResponse;

import java.util.List;

public interface IMinibus {
    public String minibusAdd(MinibusBilgi minibusBilgi);
    public String deleteById(Long id);
    public List<ReklamResponse> findByNumberPlate(String number);
    public List<Minibus> minibusList();
    public Enum<Hat>[] ilList();
    public List<String> hatList(String il);
    public Object findById(Long id);
}
