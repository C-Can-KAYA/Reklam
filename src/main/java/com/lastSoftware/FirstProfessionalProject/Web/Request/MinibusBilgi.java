package com.lastSoftware.FirstProfessionalProject.Web.Request;
import lombok.Data;

import java.util.List;

@Data
public class MinibusBilgi {
    private Long id;
    private String marka;
    private String model;
    private String hat;
    private String plaka;
    private Long sofor;
    private List<Long> reklam;
}
