package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Hat;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.HatRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IHat;
import com.lastSoftware.FirstProfessionalProject.Web.Request.HatRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HatService implements IHat {
    @Autowired
    HatRepository hatRepository;
    @Autowired
    IMapper iMapper;

    @Override
    public MessageResponse hatAdd(HatRequest hatRequest) {
        MessageResponse response = new MessageResponse();
        try {
            response.setMessage(ConstantMessage.SUCCESS);
            hatRepository.save(iMapper.HatEntity(hatRequest));
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
            hatRepository.deleteById(id);
            response.setMessage(ConstantMessage.SUCCESS);
        } catch (Exception e) {
            response.setMessage(ConstantMessage.ERROR);
            return response;
        }
        return null;
    }

    @Override
    public Optional<Hat> findById(Long id) {
        try {
            Optional<Hat> hat = hatRepository.findById(id);
            return hat;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Hat> findByPlateNumber(Integer number) {
        List<Hat> hat = null;
        try {
            hat = hatRepository.findByNumberPlate(number);
            return hat;
        }catch (Exception e){
            return hat;
        }
    }

    @Override
    public MessageResponse updateHat(HatRequest hatRequest) {
        MessageResponse response = new MessageResponse();
        try {
            response.setMessage(ConstantMessage.SUCCESS);
            hatRepository.save(iMapper.HatEntity(hatRequest));
            return response;
        } catch (Exception e) {
            response.setMessage(ConstantMessage.ERROR);
            return response;
        }
    }

    @Override
    public List<Hat> findAll() {
        return hatRepository.findAll();
    }
}
