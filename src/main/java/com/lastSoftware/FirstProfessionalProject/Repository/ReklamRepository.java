package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReklamRepository extends JpaRepository<Reklam,Long> {

    @Query(value = "SELECT * FROM reklamcilik.reklam r where r.id=:reklamId",nativeQuery = true)
    Reklam findByIdForReklam(@Param("reklamId") Long reklamId);
}
