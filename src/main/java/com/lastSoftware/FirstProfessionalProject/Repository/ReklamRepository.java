package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Reklam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ReklamRepository extends JpaRepository<Reklam,Long> {

    @Query(value = "SELECT * FROM reklam r where r.id=:id", nativeQuery = true)
    Optional<Reklam> findByIdReklam(@Param("id") Long id);

}
