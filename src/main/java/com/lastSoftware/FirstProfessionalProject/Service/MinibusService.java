package com.lastSoftware.FirstProfessionalProject.Service;

import com.lastSoftware.FirstProfessionalProject.Constants.ConstantMessage;
import com.lastSoftware.FirstProfessionalProject.Constants.Hat;
import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import com.lastSoftware.FirstProfessionalProject.Mapper.IMapper;
import com.lastSoftware.FirstProfessionalProject.Repository.MinibusRepository;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IMinibus;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.ReklamGuncelle;
import com.lastSoftware.FirstProfessionalProject.Web.Response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MinibusService implements IMinibus {

    @Autowired
    IMapper iMapper;

    @Autowired
    MinibusRepository minibusRepository;
    @Autowired
    HatService hatService;

    @Override
    public Minibus minibusAdd(MinibusBilgi minibusBilgi) throws Exception {
        try {
            return  minibusRepository.save(iMapper.MinibusEntity(minibusBilgi));
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
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
    public Object findById(Long id) throws Exception {
        try {
            return minibusRepository.findById(id);
        }catch (Exception e){
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public List<Minibus> minibusUpdate(MinibusBilgi minibusBilgi) throws Exception {
        try {
            minibusRepository.deleteByMinibusIdForReklam(minibusBilgi.getId());
            minibusRepository.deleteByMinibusIdForSofor(minibusBilgi.getId());
            minibusRepository.minibusInsertForSofor(minibusBilgi.getId(), minibusBilgi.getSofor());
            for (Long reklam : minibusBilgi.getReklam()) {
                minibusRepository.minibusInsertForReklam(minibusBilgi.getId(), reklam);
            }
            minibusRepository.minibusUpdateForCarAndHat(
                    minibusBilgi.getId(), minibusBilgi.getHat(),minibusBilgi.getIl(), minibusBilgi.getMarka(), minibusBilgi.getModel(), minibusBilgi.getPlaka(),true);
            minibusRepository.findByNumberPlate(minibusBilgi.getPlaka());
            return minibusRepository.findByNumberPlate(minibusBilgi.getPlaka());
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public Boolean minibusReklamGuncelle(ReklamGuncelle reklamGuncelle) throws Exception {
        try {
            minibusRepository.minibusReklamGuncelle(reklamGuncelle.getPlaka(), reklamGuncelle.getChecked());
            return reklamGuncelle.getChecked();
        }catch (Exception e){
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public MessageResponse deleteById(Long id) throws Exception {
        MessageResponse response=new MessageResponse();
        try {
            minibusRepository.deleteByMinibusIdForSofor(id);
            minibusRepository.deleteByMinibusIdForReklam(id);
            minibusRepository.deleteByIdForMinibus(id);
            response.setMessage(ConstantMessage.SUCCESS);
            return response;
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR);
        }
    }

    @Override
    public List<ReklamResponseNumberPlate> findByNumberPlate(String number) {
        List<Minibus> minibus = minibusRepository.findByNumberPlate(number);
        List<ReklamResponseNumberPlate> reklamResponse = new ArrayList<>();
        if(Objects.nonNull(minibus)) {
            for (Reklam reklam : minibus.get(0).getReklam()) {
                ReklamResponseNumberPlate response = new ReklamResponseNumberPlate();
                response.setFirmaAd(reklam.getFirma().getFirmaAd());
                response.setReklamId(reklam.getReklamId());
                response.setReklamLink(reklam.getLink());
                response.setChecked(minibus.get(0).getGuncel());
                reklamResponse.add(response);
            }
        }
        return reklamResponse;
    }

    @Override
    public List<ResponseMinibus>  minibusList() throws Exception {
        try {
            List<ResponseMinibus> listMinibus= new ArrayList<>();
            for (Minibus minibus:minibusRepository.findAll()){
                ResponseMinibus responseMinibus = new ResponseMinibus();
                SoforResponse soforResponse = new SoforResponse();
                HatResponse hatResponse = new HatResponse();
                if (Objects.nonNull(minibus.getId())) {
                    responseMinibus.setId(minibus.getId());
                }
                responseMinibus.setMarka(minibus.getMarka());
                responseMinibus.setModel(minibus.getModel());
                responseMinibus.setIl(minibus.getIl());
                soforResponse.setId(minibus.getSofor().get(0).getId());
                soforResponse.setAd(minibus.getSofor().get(0).getAd());
                soforResponse.setSoyad(minibus.getSofor().get(0).getSoyad());
                soforResponse.setTckn(minibus.getSofor().get(0).getTckn());
                soforResponse.setTel(minibus.getSofor().get(0).getTel());
                responseMinibus.setSofor(soforResponse);
                responseMinibus.setReklam(minibus.getReklam());
                responseMinibus.setPlaka(minibus.getPlaka());
                responseMinibus.setGuncel(minibus.getGuncel());
                if (Objects.nonNull(minibus.getHat())) {
                    Optional<com.lastSoftware.FirstProfessionalProject.Entity.Hat> hatServiceResponse = hatService.findById(Long.parseLong(minibus.getHat()));
                    if (hatServiceResponse.isPresent()) {
                        hatResponse.setId(hatServiceResponse.get().getId());
                        hatResponse.setHatAdi(hatServiceResponse.get().getHatAdi());
                        hatResponse.setPlakaKod(hatServiceResponse.get().getPlakaKod());
                        responseMinibus.setHat(hatResponse);
                    }
                }
                listMinibus.add(responseMinibus);
            }
            return listMinibus;
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
}
