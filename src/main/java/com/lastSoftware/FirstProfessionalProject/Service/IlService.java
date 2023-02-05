package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Iller;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.IllerRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IIller;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.ProjectMapper;
import com.lastSoftware.FirstProfessionalProject.Web.Request.IlRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.IlResponse;
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

        @Autowired
    private ProjectMapper mapper;

    @Override
    public IlResponse addIl(IlRequest ilRequest) throws Exception {
        try {
            illerRepository.save(iMapper.IllerEntity(ilRequest));
            return mapper.ilRequestToIlResponse(ilRequest);
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public MessageResponse deleteById(Long id) throws Exception {
        MessageResponse response = new MessageResponse();
        try {
            illerRepository.deleteById(id);
            response.setMessage(ConstantMessage.SUCCESS);
            return response;
        }catch (Exception e){
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public IlResponse ilUpdate(IlRequest ilRequest) throws Exception {
        try {
            illerRepository.save(iMapper.IllerEntity(ilRequest));
            return mapper.ilRequestToIlResponse(ilRequest);
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public List<Iller> findAll() {
        return illerRepository.findAll();
    }
}
