package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReklamRepository extends JpaRepository<Reklam,Long> {

    @Transactional
    @Query(value = "SELECT * FROM reklam r where r.id=:reklamId",nativeQuery = true)
    Reklam findByIdForReklam(@Param("reklamId") Long reklamId);
}
