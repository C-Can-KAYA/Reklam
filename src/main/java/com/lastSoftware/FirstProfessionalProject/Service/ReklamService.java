package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
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
    public Reklam add(MultipartFile reklamBilgi, Long firma) throws Exception {
        try {
            FileDB fileDB = storageService.store(reklamBilgi);
            return reklamRepository.save(iMapper.ReklamEntity(reklamBilgi,fileDB,firma));
        } catch (IOException e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public String deleteById(String id) throws Exception {
        try {
            reklamRepository.deleteById(Long.valueOf(id));
            storageService.deleteFileById(id);
            return ConstantMessage.SUCCESS;
        }catch (Exception e){
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public List<Reklam> list() throws Exception {
        try {
            return reklamRepository.findAll();
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public Object findById(Long id) {
        return reklamRepository.findById(id);
    }
}
