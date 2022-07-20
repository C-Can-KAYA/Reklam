package com.lastSoftware.FirstProfessionalProject.Implementation.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IReklam {
    public String add(MultipartFile reklamBilgi);
    public String deleteById(String id);
    public List<Reklam> list();
}
