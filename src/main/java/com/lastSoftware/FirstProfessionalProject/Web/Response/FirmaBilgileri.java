package com.lastSoftware.FirstProfessionalProject.Web.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmaBilgileri {
    public Long Id;
    public String ad;
    public String il;
    public String ilce;
    public Integer postaKodu;
    public String sicilNo;
}
