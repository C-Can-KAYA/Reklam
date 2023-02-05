package com.lastSoftware.FirstProfessionalProject.Web.Response;

import lombok.Data;

@Data
public class SoforResponse {
    public Long id;
    public String ad;
    public String soyad;
    public Long tckn;
    private Long tel;
}
