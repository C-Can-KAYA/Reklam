package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Hat;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.HatRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IHat;
import com.lastSoftware.FirstProfessionalProject.Web.Request.HatRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.HatResponse;
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
    public HatResponse hatAdd(HatRequest hatRequest) throws Exception {
        try {
            Hat hat = hatRepository.save(iMapper.HatEntity(hatRequest));
            return getHatRespnse(hatRequest,hat.getId());
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    public HatResponse getHatRespnse(HatRequest hatRequest,Long id){
        HatResponse hat = new HatResponse();
        hat.setHatAdi(hatRequest.getHatAdi());
        hat.setId(id);
        hat.setPlakaKod(hatRequest.getPlakaKod());
        return hat;
    }

    @Override
    public MessageResponse deleteById(Long id) throws Exception {
        MessageResponse response = new MessageResponse();
        try {
            hatRepository.deleteById(id);
            response.setMessage(ConstantMessage.SUCCESS);
            return response;
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public Optional<Hat> findById(Long id) throws Exception {
        try {
            return hatRepository.findById(id);
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public List<Hat> findByPlateNumber(Integer number) throws Exception {
        try {
            return hatRepository.findByNumberPlate(number);
        }catch (Exception e){
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public HatResponse updateHat(HatRequest hatRequest) throws Exception {
        try {
            Hat hat = hatRepository.save(iMapper.HatEntity(hatRequest));
            return getHatRespnse(hatRequest, hat.getId());
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public List<Hat> findAll() {
        return hatRepository.findAll();
    }
}
