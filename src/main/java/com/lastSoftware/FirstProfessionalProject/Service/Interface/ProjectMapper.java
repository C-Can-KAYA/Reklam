package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.HatRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Request.IlRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.FirmaResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.HatResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.IlResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.SoforResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    FirmaResponse firmaBilgiToFirmaResponse(FirmaBilgi firmaBilgi);
    HatResponse hatRequestToHatResponse(HatRequest hatRequest);
    IlResponse ilRequestToIlResponse(IlRequest ilRequest);
    SoforResponse soforBilgiToSoforResponse(SoforBilgi soforBilgi);
}
