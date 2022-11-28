package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Sofor;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.ISofor;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.SoforRepository;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoforService implements ISofor {
    @Autowired
    SoforRepository soforRepository;
    @Autowired
    IMapper iMapper;

    @Override
    public String soforAdd(SoforBilgi sofor) {
        try {
            soforRepository.save(iMapper.SoforEntitiy(sofor));
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
        return ConstantMessage.SUCCESS;
    }

    @Override
    public List<Sofor> soforList() {
        List<Sofor> soforList =
                soforRepository.findAll();
        return soforList;
    }

    @Override
    public Object findById(Long id) {
        return soforRepository.findById(id);
    }

    @Override
    public Object findByTckn(Long tckn) {
        return soforRepository.findByTckn(tckn);
    }

    @Override
    public String deleteById(Long id) {
        try {
            soforRepository.deleteById(id);
            return ConstantMessage.SUCCESS;
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
    }

    @Override
    public String updateSofor(SoforBilgi soforBilgi) {
        try {
            soforRepository.save(iMapper.SoforEntitiy(soforBilgi));
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
        return ConstantMessage.SUCCESS;
    }

    @Override
    public String deleteByTckn(Long id) {
        try {
            soforRepository.findIdWithTckn(id);
            soforRepository.deleteByTckn(id);
            return ConstantMessage.SUCCESS;
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
    }
}
