package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Sofor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SoforRepository extends JpaRepository<Sofor, Long> {

    @Query(value = "select * from reklamcilik.sofor p where p.tckn = :id", nativeQuery = true)
    Object findByTckn(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from reklamcilik.sofor p where p.tckn = :id", nativeQuery = true)
    Integer deleteByTckn(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from reklamcilik.minibus_sofor p where p.sofor_id=:id", nativeQuery = true)
    Integer deleteByRelationShip(@Param("id") Long id);

    @Query(value = "select * from reklamcilik.sofor p where p.tckn=:id", nativeQuery = true)
    Sofor findIdWithTckn(@Param("id") Long id);

    @Transactional
    @Query(value = "select * from reklamcilik.sofor s where s.id=:sofor_id", nativeQuery = true)
    Sofor findByIdForSofor(@Param("sofor_id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update reklamcilik.sofor s SET s.ad=:ad,s.soyad=:soyad,s.tckn=:tckn,s.tel=:tel where s.id=:sofor_id", nativeQuery = true)
    Integer findByIdAndUpdate(@Param("ad") String ad, @Param("soyad") String soyad, @Param("tckn") Long tckn, @Param("tel") Long tel, @Param("sofor_id") Long soforId);
}
