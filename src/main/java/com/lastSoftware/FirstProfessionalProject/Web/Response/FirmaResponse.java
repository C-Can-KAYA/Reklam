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
    private String ad;
    private String sicilNo;
    private Adres Adres;
}
