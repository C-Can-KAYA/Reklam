package com.lastSoftware.FirstProfessionalProject.Service.Interface;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IReklam {
    Reklam add(MultipartFile reklamBilgi, Long firma) throws Exception;
    String deleteById(String id) throws Exception;
    List<Reklam> list() throws Exception;
    Object findById(Long id);
}
