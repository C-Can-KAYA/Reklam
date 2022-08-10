package com.lastSoftware.FirstProfessionalProject.Mapper;

import com.lastSoftware.FirstProfessionalProject.Entity.*;
import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
import org.springframework.web.multipart.MultipartFile;

public interface IMapper {
    public Minibus MinibusEntity(MinibusBilgi minibusBilgi);
    public Sofor SoforEntitiy(SoforBilgi soforBilgi);
    public Firma firmaEntitiy(FirmaBilgi firmaBilgi);
    public Reklam ReklamEntity(MultipartFile reklamBilgi, FileDB fileDB);
}
