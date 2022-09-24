package com.lastSoftware.FirstProfessionalProject.Mapper;

import com.lastSoftware.FirstProfessionalProject.Entity.*;
import com.lastSoftware.FirstProfessionalProject.Repository.ReklamRepository;
import com.lastSoftware.FirstProfessionalProject.Repository.SoforRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IFirma;
import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MapperImpl implements IMapper {
    @Autowired
    IFirma firma;
    @Autowired
    ReklamRepository reklamRepository;
    @Autowired
    SoforRepository soforRepository;

    @Override
    public Minibus MinibusEntity(MinibusBilgi minibusBilgi) {
        Minibus minibus = new Minibus();
        minibus.setId(minibusBilgi.getId());
        minibus.setMarka(minibusBilgi.getMarka());
        minibus.setModel(minibusBilgi.getModel());
        minibus.setHat(minibusBilgi.getHat());
        List<Sofor>soforList=new ArrayList<>();
        soforList.add(soforRepository.findByIdForSofor(minibusBilgi.getSofor()));
        minibus.setSofor(soforList);
        List<Reklam> reklamList = new ArrayList<>();
        for (Long reklamId : minibusBilgi.getReklam()) {
            reklamList.add(reklamRepository.findByIdForReklam(reklamId));
        }
        minibus.setReklam(reklamList);
        minibus.setPlaka(minibusBilgi.getPlaka());
        return minibus;
    }

    @Override
    public Sofor SoforEntitiy(SoforBilgi soforBilgi) {
        Sofor sofor = new Sofor();
        sofor.setSoforId(soforBilgi.getId());
        sofor.setAd(soforBilgi.getAd());
        sofor.setSoyad(soforBilgi.getSoyad());
        sofor.setTckn(soforBilgi.getTckn());
        sofor.setTel(soforBilgi.getTel());
        return sofor;
    }

    @Override
    public Firma firmaEntitiy(FirmaBilgi firmaBilgi) {
        Firma firma = new Firma();
        firma.setId(firmaBilgi.getId());
        firma.setFirmaAd(firmaBilgi.getAd());
        firma.setSicilNo(firmaBilgi.getSicilNo());
        Adres adres = new Adres();
        adres.setIl(firmaBilgi.getAdres().getIl());
        adres.setIlce(firmaBilgi.getAdres().getIlce());
        adres.setPostaKodu(firmaBilgi.getAdres().getPostaKodu());
        firma.setAdres(adres);
        return firma;
    }

    @Override
    public Reklam ReklamEntity(MultipartFile reklamBilgi, FileDB fileDB, Long id) {
        Reklam reklam = new Reklam();
        reklam.setAd(reklamBilgi.getOriginalFilename());
        String reklamLink = "http://localhost:8080/reklam/findByIdFile/" + fileDB.getId();
        reklam.setLink(reklamLink);
        reklam.setReklamId(fileDB.getId());
        Optional<Firma> firmaEkleme = firma.findById(id);
        Firma firma = new Firma();
        firma.setId(firmaEkleme.get().getId());
        firma.setFirmaAd(firmaEkleme.get().getFirmaAd());
        firma.setSicilNo(firmaEkleme.get().getSicilNo());
        Adres adres = new Adres();
        adres.setIl(firmaEkleme.get().getAdres().getIl());
        adres.setIlce(firmaEkleme.get().getAdres().getIlce());
        adres.setPostaKodu(firmaEkleme.get().getAdres().getPostaKodu());
        firma.setAdres(adres);
        reklam.setFirma(firma);
        return reklam;
    }
}
