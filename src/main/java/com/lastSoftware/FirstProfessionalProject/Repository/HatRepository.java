package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Hat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HatRepository extends JpaRepository<Hat, Long> {
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM Hat where plakaKod=:plakaKod", nativeQuery = true)
    List<Hat> findByNumberPlate(@Param("plakaKod") Integer plaka);
}
