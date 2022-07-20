package com.lastSoftware.FirstProfessionalProject.Web.Request;

import com.lastSoftware.FirstProfessionalProject.Entity.Sofor;
import lombok.Data;

import java.util.List;

@Data
public class MinibusBilgi extends DefaultDegerler{
    private Long id;
    private String marka;
    private String model;
    private Integer hat;
    private List<Sofor> sofor;
    private String plaka;
}
