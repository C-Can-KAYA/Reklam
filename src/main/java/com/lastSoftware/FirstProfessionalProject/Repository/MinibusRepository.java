package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MinibusRepository extends JpaRepository<Minibus,Long> {
    @Query(value = "SELECT * FROM reklamcilik.minibus m where m.plaka=:plaka",nativeQuery = true)
    Minibus findByNumberPlate(@Param("plaka") String plaka);
}
