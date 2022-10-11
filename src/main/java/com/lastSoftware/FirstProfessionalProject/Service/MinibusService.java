package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Constants.Hat;
import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.MinibusRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IMinibus;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.ReklamResponse;
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
            System.out.println(e);
            return ConstantMessage.ERROR;
        }
        return ConstantMessage.SUCCESS;
    }

    @Override
    public Enum<Hat>[] ilList() {
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
    public Object findById(Long id) {
        return minibusRepository.findById(id);
    }

    @Override
    public Object minibusUpdate(MinibusBilgi minibusBilgi) {
        try {
            minibusRepository.deleteByMinibusIdForReklam(minibusBilgi.getId());
            minibusRepository.deleteByMinibusIdForSofor(minibusBilgi.getId());
            minibusRepository.minibusInsertForSofor(minibusBilgi.getId(), minibusBilgi.getSofor());
            for (Long reklam : minibusBilgi.getReklam()) {
                minibusRepository.minibusInsertForReklam(minibusBilgi.getId(), reklam);
            }
            minibusRepository.minibusUpdateForCarAndHat(
                    minibusBilgi.getId(), minibusBilgi.getHat(),minibusBilgi.getIl(), minibusBilgi.getMarka(), minibusBilgi.getModel(), minibusBilgi.getPlaka());
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
        return ConstantMessage.SUCCESS;
    }

    @Override
    public String deleteById(Long id) {
        try {
            minibusRepository.deleteByMinibusIdForSofor(id);
            minibusRepository.deleteByMinibusIdForReklam(id);
            minibusRepository.deleteByIdForMinibus(id);
            return ConstantMessage.SUCCESS;
        } catch (Exception e) {
            return ConstantMessage.ERROR;
        }
    }

    @Override
    public List<ReklamResponse> findByNumberPlate(String number) {
        List<Minibus> minibus = minibusRepository.findByNumberPlate(number);
        List<ReklamResponse> reklamResponse = new ArrayList<>();
        for (Reklam reklam : minibus.get(0).getReklam()) {
            ReklamResponse response = new ReklamResponse();
            response.setFirmaAd(reklam.getFirma().getFirmaAd());
            response.setReklamId(reklam.getReklamId());
            response.setReklamLink(reklam.getLink());
            reklamResponse.add(response);
        }
        return reklamResponse;
    }

    @Override
    public List<Minibus> minibusList() {
        return minibusRepository.findAll();
    }
}
