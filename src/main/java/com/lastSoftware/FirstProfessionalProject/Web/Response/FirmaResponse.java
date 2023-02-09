package com.lastSoftware.FirstProfessionalProject.Web.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.lastSoftware.FirstProfessionalProject.Entity.Adres;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmaResponse {
    private Long id;
    private String firmaAd;
    private String sicilNo;
    private Adres Adres;
}
