package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Iller;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.IllerRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IIller;
import com.lastSoftware.FirstProfessionalProject.Web.Request.IlRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IlService implements IIller {
    @Autowired
    IllerRepository illerRepository;
    @Autowired
    IMapper iMapper;

    @Override
    public MessageResponse addIl(IlRequest ilRequest) {
        MessageResponse response = new MessageResponse();
        try {
            response.setMessage(ConstantMessage.SUCCESS);
            illerRepository.save(iMapper.IllerEntity(ilRequest));
            return response;
        } catch (Exception e) {
            response.setMessage(ConstantMessage.ERROR);
            return response;
        }
    }

    @Override
    public MessageResponse deleteById(Long id) {
        MessageResponse response = new MessageResponse();
        try {
            illerRepository.deleteById(id);
            response.setMessage(ConstantMessage.SUCCESS);
        }catch (Exception e){
            response.setMessage(ConstantMessage.ERROR);
            return response;
        }
        return null;
    }

    @Override
    public MessageResponse ilUpdate(IlRequest ilRequest) {
        MessageResponse response = new MessageResponse();
        try {
            response.setMessage(ConstantMessage.SUCCESS);
            illerRepository.save(iMapper.IllerEntity(ilRequest));
            return response;
        } catch (Exception e) {
            response.setMessage(ConstantMessage.ERROR);
            return response;
        }
    }

    @Override
    public List<Iller> findAll() {
        return illerRepository.findAll();
    }
}
