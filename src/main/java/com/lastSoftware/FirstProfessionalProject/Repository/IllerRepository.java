package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Iller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllerRepository extends JpaRepository<Iller, Long> {
}
