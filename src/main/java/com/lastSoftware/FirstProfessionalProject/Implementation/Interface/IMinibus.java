package com.lastSoftware.FirstProfessionalProject.Implementation.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;

import java.util.List;

public interface IMinibus {
    public String minibusAdd(MinibusBilgi minibusBilgi);
    public String deleteById(Long id);
    public List<Minibus> minibusList();
}
