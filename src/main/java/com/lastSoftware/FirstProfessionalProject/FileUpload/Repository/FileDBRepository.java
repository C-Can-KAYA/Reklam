package com.lastSoftware.FirstProfessionalProject.FileUpload.Repository;

import com.lastSoftware.FirstProfessionalProject.FileUpload.Entity.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB,String> {
}
