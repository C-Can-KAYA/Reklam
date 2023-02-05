package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Firma;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.FirmaRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IFirma;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.ProjectMapper;
import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.FirmaResponse;
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
    @Autowired
    private ProjectMapper mapper;
    @Override
    public FirmaResponse firmaAdd(FirmaBilgi firmaBilgi) throws Exception {
        try {
            firmaRepository.save(iMapper.firmaEntitiy(firmaBilgi));
            return mapper.firmaBilgiToFirmaResponse(firmaBilgi);
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public MessageResponse deleteById(Long id) throws Exception {
        MessageResponse response=new MessageResponse();
        try {
            firmaRepository.deleteById(id);
            response.setMessage(ConstantMessage.SUCCESS);
            return response;
        }catch (Exception e){
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public Optional<Firma> findById(Long number) {
        return firmaRepository.findById(number);
    }

    @Override
    public FirmaResponse updateFirma(FirmaBilgi firmaBilgi) throws Exception {
        try {
            firmaRepository.save(iMapper.firmaEntitiy(firmaBilgi));
            return mapper.firmaBilgiToFirmaResponse(firmaBilgi);
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public List<Firma> list() {
            return firmaRepository.findAll();
    }
}
