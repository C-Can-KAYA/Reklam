package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IReklam {
    String add(MultipartFile reklamBilgi, Long firma);
    String deleteById(String id);
    List<Reklam> list();
    Object findById(Long id);
}
