package com.lastSoftware.FirstProfessionalProject.Web.Request;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import com.lastSoftware.FirstProfessionalProject.Entity.Sofor;
import lombok.Data;

import java.util.List;

@Data
public class MinibusBilgi {
    private Long id;
    private String marka;
    private String model;
    private String hat;
    private String plaka;
    private List<Sofor> sofor;
    private List<Reklam> reklam;
}
