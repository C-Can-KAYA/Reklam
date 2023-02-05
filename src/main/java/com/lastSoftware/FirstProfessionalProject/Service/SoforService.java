package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Sofor;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.SoforRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.ISofor;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.ProjectMapper;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.SoforResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoforService implements ISofor {
    @Autowired
    SoforRepository soforRepository;
    @Autowired
    IMapper iMapper;

        @Autowired
    private ProjectMapper mapper;

    @Override
    public SoforResponse soforAdd(SoforBilgi sofor) throws Exception {
        try {
            soforRepository.save(iMapper.SoforEntitiy(sofor));
            return mapper.soforBilgiToSoforResponse(sofor);
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public List<Sofor> soforList() {
        return soforRepository.findAll();
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
    public String deleteById(Long id) throws Exception {
        try {
            soforRepository.deleteById(id);
            return ConstantMessage.SUCCESS;
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public SoforResponse updateSofor(SoforBilgi soforBilgi) throws Exception {
        try {
            soforRepository.save(iMapper.SoforEntitiy(soforBilgi));
            return mapper.soforBilgiToSoforResponse(soforBilgi);
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public String deleteByTckn(Long id) throws Exception {
        try {
            soforRepository.findIdWithTckn(id);
            soforRepository.deleteByTckn(id);
            return ConstantMessage.SUCCESS;
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }
}
