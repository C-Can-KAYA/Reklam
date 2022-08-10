package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Constants.Hat;
import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IMinibus;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.MinibusRepository;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MinibusService implements IMinibus {

    @Autowired
    IMapper iMapper;

    @Autowired
    MinibusRepository minibusRepository;

    @Override
    public String minibusAdd(MinibusBilgi minibusBilgi) {
        try {
            minibusRepository.save(iMapper.MinibusEntity(minibusBilgi));
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
        return ConstantMessage.SUCCESS;
    }

    @Override
    public Enum<Hat>[] ilList(){
        return Hat.values();
    }

    @Override
    public List<String> hatList(String il) {
            List<String> hatList = new ArrayList<>();
            for (String hat : Hat.valueOf(il).getMembers()) {
                hatList.add(hat);
            }
            return hatList;
    }

    @Override
    public String deleteById(Long id) {
        try {
            minibusRepository.deleteById(id);
            return ConstantMessage.SUCCESS;
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
    }

    @Override
    public Minibus findByNumberPlate(String number) {
        return minibusRepository.findByNumberPlate(number);
    }

    @Override
    public List<Minibus> minibusList() {
        return minibusRepository.findAll();
    }
}
