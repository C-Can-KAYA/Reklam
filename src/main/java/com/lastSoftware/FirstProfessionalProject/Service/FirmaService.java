package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Firma;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.FirmaRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IFirma;
import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirmaService implements IFirma {
    @Autowired
    IMapper iMapper;
    @Autowired
    FirmaRepository firmaRepository;
    @Override
    public MessageResponse firmaAdd(FirmaBilgi firmaBilgi) {
        MessageResponse response=new MessageResponse();
        try {
            firmaRepository.save(iMapper.firmaEntitiy(firmaBilgi));
            response.setMessage(ConstantMessage.SUCCESS);
            return response;
        } catch (Exception e) {
            response.setMessage(ConstantMessage.ERROR);
            return response;
        }
    }

    @Override
    public MessageResponse deleteById(Long id) {
        MessageResponse response=new MessageResponse();
        try {
            firmaRepository.deleteById(id);
            response.setMessage(ConstantMessage.ERROR);
            return response;
        }catch (Exception e){
            response.setMessage(ConstantMessage.ERROR);
            return response;
        }
    }

    @Override
    public Optional<Firma> findById(Long number) {
        return firmaRepository.findById(number);
    }

    @Override
    public MessageResponse updateFirma(FirmaBilgi firmaBilgi) {
        MessageResponse response=new MessageResponse();
        try {
            firmaRepository.save(iMapper.firmaEntitiy(firmaBilgi));
            response.setMessage(ConstantMessage.SUCCESS);
            return response;
        } catch (Exception e) {
            response.setMessage(ConstantMessage.ERROR);
            return response;
        }

    }

    @Override
    public List<Firma> list() {
            return firmaRepository.findAll();
    }
}
