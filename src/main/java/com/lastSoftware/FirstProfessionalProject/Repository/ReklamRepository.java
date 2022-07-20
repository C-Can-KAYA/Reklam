package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ReklamRepository extends JpaRepository<Reklam,Long> {

    @Modifying
    @Transactional
    @Query(value = "delete FROM reklamcilik.reklam p where p.reklam_id=:id",nativeQuery = true)
    Integer deleteById(@Param("id") String id);
}
