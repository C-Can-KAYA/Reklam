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
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(source = "sicilNo", target = "sicilNo")
    FirmaResponse firmaBilgiToFirmaResponse(FirmaBilgi firmaBilgi);
    @Mapping(source = "plakaKod", target = "plakaKod")
    HatResponse hatRequestToHatResponse(HatRequest hatRequest);
    @Mapping(source = "plakaKod", target = "plakaKod")
    IlResponse ilRequestToIlResponse(IlRequest ilRequest);
    @Mapping(source = "tckn", target = "tckn")
    SoforResponse soforBilgiToSoforResponse(SoforBilgi soforBilgi);
}
