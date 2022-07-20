package com.lastSoftware.FirstProfessionalProject.Implementation;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Implementation.Interface.IMinibus;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.MinibusRepository;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinibusImpl implements IMinibus {

    @Autowired
    IMapper iMapper;

    @Autowired
    MinibusRepository minibusRepository;

    @Override
    public String minibusAdd(MinibusBilgi minibusBilgi) {
        try {
            minibusRepository.save(iMapper.MinibusEntity(minibusBilgi));
        } catch (Exception e) {
            return ConstantMessage.error;
        }
        return ConstantMessage.basari;
    }

    @Override
    public String deleteById(Long id){
        try {
            minibusRepository.deleteById(id);
            return ConstantMessage.basari;
        }catch (Exception e){
            return ConstantMessage.error;
        }
    }

    @Override
    public List<Minibus> minibusList(){
        return minibusRepository.findAll();
    }
}
