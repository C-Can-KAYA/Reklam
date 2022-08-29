package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Firma;
import com.lastSoftware.FirstProfessionalProject.Web.Response.FirmaBilgileri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FirmaRepository extends JpaRepository<Firma,Long> {
    @Transactional
    @Query(value = "SELECT f.id,f.firma_ad,f.sicil_no,a.il,a.ilce ,a.posta_kodu FROM reklamcilik.firma f inner join reklamcilik.adres a on f.adres_id=a.id", nativeQuery = true)
    List<FirmaBilgileri> firmaList();
}
