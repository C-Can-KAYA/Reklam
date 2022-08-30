package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IReklam {
    String add(MultipartFile reklamBilgi);
    String deleteById(String id);
    List<Reklam> list();
}
