package com.lastSoftware.FirstProfessionalProject.Web.Request;

import com.lastSoftware.FirstProfessionalProject.Entity.Adres;
import lombok.Data;

@Data
public class FirmaBilgi {
    private Long id;
    private String firmaAd;
    private String sicilNo;
    private Adres Adres;
}
