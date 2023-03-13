package com.lastSoftware.FirstProfessionalProject.Web.Response;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMinibus {
    private Long id;
    private String marka;
    private String model;
    private HatResponse hat;
    private String il;
    private SoforResponse sofor;
    private List<Reklam> reklam;
    private String plaka;
    private Boolean guncel;
}
