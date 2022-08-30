package com.lastSoftware.FirstProfessionalProject.Mapper;

import com.lastSoftware.FirstProfessionalProject.Entity.*;
import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
import org.springframework.web.multipart.MultipartFile;

public interface IMapper {
    Minibus MinibusEntity(MinibusBilgi minibusBilgi);
    Sofor SoforEntitiy(SoforBilgi soforBilgi);
    Firma firmaEntitiy(FirmaBilgi firmaBilgi);
    Reklam ReklamEntity(MultipartFile reklamBilgi, FileDB fileDB);
}
