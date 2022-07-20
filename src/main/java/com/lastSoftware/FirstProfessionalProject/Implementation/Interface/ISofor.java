package com.lastSoftware.FirstProfessionalProject.Implementation.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Sofor;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;

import java.util.List;

public interface ISofor {
    String soforAdd(SoforBilgi sofor);
    List<Sofor> soforList();
    Object findById(Long id);
    Object findByTckn(Long tckn);
    String deleteByTckn(Long id);
    String deleteById(Long id);
}
