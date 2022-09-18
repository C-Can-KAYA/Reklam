package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Firma;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.FirmaRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IFirma;
import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
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
    public String firmaAdd(FirmaBilgi firmaBilgi) {
        try {
            firmaRepository.save(iMapper.firmaEntitiy(firmaBilgi));
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
        return ConstantMessage.SUCCESS;
    }

    @Override
    public String deleteById(Long id) {
        try {
            firmaRepository.deleteById(id);
            return ConstantMessage.SUCCESS;
        }catch (Exception e){
            return ConstantMessage.ERROR;
        }
    }

    @Override
    public Optional<Firma> findById(Long number) {
        return firmaRepository.findById(number);
    }

    @Override
    public String updateFirma(FirmaBilgi firmaBilgi) {
        try {

            firmaRepository.save(iMapper.firmaEntitiy(firmaBilgi));
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
        return ConstantMessage.SUCCESS;
    }

    @Override
    public List<Firma> list() {
            return firmaRepository.findAll();
    }
}
