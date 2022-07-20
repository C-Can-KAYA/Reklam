package com.lastSoftware.FirstProfessionalProject.Implementation;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import com.lastSoftware.FirstProfessionalProject.FileUpload.Entity.FileDB;
import com.lastSoftware.FirstProfessionalProject.FileUpload.Service.FileStorageService;
import com.lastSoftware.FirstProfessionalProject.Implementation.Interface.IReklam;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.ReklamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReklamImpl implements IReklam {
    @Autowired
    ReklamRepository reklamRepository;
    @Autowired
    IMapper iMapper;
    @Autowired
    FileStorageService storageService;

    @Override
    public String add(MultipartFile reklamBilgi) {
        try {
            FileDB fileDB =storageService.store(reklamBilgi);
            reklamRepository.save(iMapper.ReklamEntity(reklamBilgi,fileDB));
            return ConstantMessage.basari;
        } catch (IOException e) {
            System.out.println(e);
            return ConstantMessage.error;
        }
    }

    @Override
    public String deleteById(String id) {
        try {
            reklamRepository.deleteById(id);
            storageService.deleteFileById(id);
            return ConstantMessage.basari;
        }catch (Exception e){
            return ConstantMessage.error;
        }
    }

    @Override
    public List<Reklam> list() {
            List<Reklam> reklamList =
                    reklamRepository.findAll();
            return reklamList;
    }
}
