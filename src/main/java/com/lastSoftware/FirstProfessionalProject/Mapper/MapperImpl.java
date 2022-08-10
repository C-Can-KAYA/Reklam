package com.lastSoftware.FirstProfessionalProject.Mapper;

import com.lastSoftware.FirstProfessionalProject.Entity.*;
import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MapperImpl implements IMapper {


    @Override
    public Minibus MinibusEntity(MinibusBilgi minibusBilgi) {
            Minibus minibus=new Minibus();
            minibus.setId(minibusBilgi.getId());
            minibus.setMarka(minibusBilgi.getMarka());
            minibus.setModel(minibusBilgi.getModel());
            minibus.setHat(minibusBilgi.getHat());
            minibus.setSofor(minibusBilgi.getSofor());
            minibus.setPlaka(minibusBilgi.getPlaka());
            return minibus;
    }

    @Override
    public Sofor SoforEntitiy(SoforBilgi soforBilgi) {
        Sofor sofor=new Sofor();
        sofor.setSoforId(soforBilgi.getId());
        sofor.setAd(soforBilgi.getAd());
        sofor.setSoyad(soforBilgi.getSoyad());
        sofor.setTckn(soforBilgi.getTckn());
        sofor.setTel(soforBilgi.getTel());
        return sofor;
    }

    @Override
    public Firma firmaEntitiy(FirmaBilgi firmaBilgi) {
        Firma firma=new Firma();
        firma.setId(firmaBilgi.getId());
        firma.setFirmaAd(firmaBilgi.getAd());
        firma.setSicilNo(firmaBilgi.getSicilNo());
        firma.setAdres(firmaBilgi.getAdres());
        return firma;
    }

    @Override
    public Reklam ReklamEntity(MultipartFile reklamBilgi, FileDB fileDB){
        Reklam reklam=new Reklam();
        reklam.setAd(reklamBilgi.getOriginalFilename());
        String reklamLink="http://localhost:8080/files/"+fileDB.getId();
        reklam.setLink(reklamLink);
        reklam.setReklamId(fileDB.getId());
        return reklam;
    }
}
