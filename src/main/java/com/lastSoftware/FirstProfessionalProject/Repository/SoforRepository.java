package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Sofor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface SoforRepository extends JpaRepository<Sofor,Long> {

    @Query(value = "select * from reklamcilik.sofor p where p.tckn = :id",nativeQuery = true)
    Object findByTckn(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from reklamcilik.sofor p where p.tckn = :id",nativeQuery = true)
    Integer deleteByTckn(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from reklamcilik.minibus_sofor p where p.sofor_sofor_id=:id",nativeQuery = true)
    Integer deleteByRelationShip(@Param("id") Long id);

    @Query(value = "select * from reklamcilik.sofor p where p.tckn=:id",nativeQuery = true)
    Sofor findIdWithTckn(@Param("id") Long id);
}
