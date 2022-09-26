package com.lastSoftware.FirstProfessionalProject.Web.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReklamResponse {
    public String firmaAd;
    public String reklamId;
    public String reklamLink;
}
