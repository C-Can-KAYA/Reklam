package com.lastSoftware.FirstProfessionalProject.Web.Request;

import lombok.*;

@Data
public class SoforBilgi {
    public Long id;
    public String ad;
    public String soyad;
    public Long tckn;
    private Long tel;
}
