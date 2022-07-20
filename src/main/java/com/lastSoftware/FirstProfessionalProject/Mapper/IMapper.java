package com.lastSoftware.FirstProfessionalProject.Mapper;

import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import com.lastSoftware.FirstProfessionalProject.Entity.Sofor;
import com.lastSoftware.FirstProfessionalProject.FileUpload.Entity.FileDB;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
import org.springframework.web.multipart.MultipartFile;

public interface IMapper {
    public Minibus MinibusEntity(MinibusBilgi minibusBilgi);
    public Sofor SoforEntitiy(SoforBilgi soforBilgi);
    public Reklam ReklamEntity(MultipartFile reklamBilgi, FileDB fileDB);
}
