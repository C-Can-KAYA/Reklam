package com.lastSoftware.FirstProfessionalProject.Repository;

import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MinibusRepository extends JpaRepository<Minibus, Long> {
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM minibus m where m.plaka=:plaka", nativeQuery = true)
    List<Minibus> findByNumberPlate(@Param("plaka") String plaka);

    @Modifying
    @Transactional
    @Query(value = "delete from minibus_reklam where minibus_id=:id", nativeQuery = true)
    Integer deleteByMinibusIdForReklam(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from minibus_sofor where minibus_id=:id", nativeQuery = true)
    Integer deleteByMinibusIdForSofor(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO minibus_reklam (minibus_id, reklam_id)VALUES(:minibusId,:reklamId)", nativeQuery = true)
    Integer minibusInsertForReklam(@Param("minibusId") Long minibusId, @Param("reklamId") Long reklamId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO minibus_sofor (minibus_id, sofor_id)VALUES (:minibusId,:soforId)", nativeQuery = true)
    Integer minibusInsertForSofor(@Param("minibusId") Long minibusId, @Param("soforId") Long soforId);

    @Modifying
    @Transactional
    @Query(value = "update minibus set hat=:hat,il=:il,marka=:marka,model=:model,plaka=:plaka,guncel=:guncel where id=:minibusId", nativeQuery = true)
    Integer minibusUpdateForCarAndHat(
            @Param("minibusId") Long minibusId, @Param("hat") String hat,@Param("il") String il, @Param("marka") String marka, @Param("model") String model, @Param("plaka") String plaka,@Param("guncel") Boolean guncel);

    @Modifying
    @Transactional
    @Query(value = "update minibus set guncel=:guncel where plaka=:plaka", nativeQuery = true)
    Integer minibusReklamGuncelle(
            @Param("plaka") String plaka, @Param("guncel") Boolean guncelle);

    @Modifying
    @Transactional
    @Query(value = "delete from minibus where id=:minibusId", nativeQuery = true)
    void deleteByIdForMinibus(@Param("minibusId") Long minibusId);
}
