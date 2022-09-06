package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Firma;
import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import com.lastSoftware.FirstProfessionalProject.Entity.FileDB;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IReklam;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.ReklamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ReklamService implements IReklam {
    @Autowired
    ReklamRepository reklamRepository;
    @Autowired
    IMapper iMapper;
    @Autowired
    FileStorageService storageService;

    @Override
    public String add(MultipartFile reklamBilgi, Long firma) {
        try {
            FileDB fileDB =storageService.store(reklamBilgi);
            reklamRepository.save(iMapper.ReklamEntity(reklamBilgi,fileDB,firma));
            return ConstantMessage.SUCCESS;
        } catch (IOException e) {
            System.out.println(e);
            return ConstantMessage.ERROR;
        }
    }

    @Override
    public String deleteById(String id) {
        try {
            reklamRepository.deleteById(Long.valueOf(id));
            storageService.deleteFileById(id);
            return ConstantMessage.SUCCESS;
        }catch (Exception e){
            return ConstantMessage.ERROR;
        }
    }

    @Override
    public List<Reklam> list() {
            List<Reklam> reklamList =
                    reklamRepository.findAll();
            return reklamList;
    }

    @Override
    public Object findById(Long id) {
        return reklamRepository.findById(id);
    }
}
