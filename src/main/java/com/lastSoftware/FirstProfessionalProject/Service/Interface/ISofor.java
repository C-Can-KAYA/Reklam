package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Sofor;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.SoforResponse;

import java.util.List;

public interface ISofor {
    SoforResponse soforAdd(SoforBilgi sofor) throws Exception;
    List<Sofor> soforList();
    Object findById(Long id);
    Object findByTckn(Long tckn);
    String deleteByTckn(Long id) throws Exception;
    String deleteById(Long id) throws Exception;
    SoforResponse updateSofor(SoforBilgi soforBilgi) throws Exception;
}
