package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CheckIn;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CheckIns (id, Reservas_id) VALUES ( proyectoHotels1_sequence.nextval , :Reservas_id)", nativeQuery = true)
    void insertarCheckIn(@Param("Reservas_id") Integer Reservas_id);

    //READ
    @Query(value = "SELECT * FROM CheckIns", nativeQuery = true)
    Collection<CheckIn> darCheckIns();
    @Query(value = "SELECT * FROM CheckIns WHERE id = :id", nativeQuery = true)
    CheckIn darCheckIn(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE CheckIns SET Reservas_id = :Reservas_id WHERE id = :id", nativeQuery = true)
    void actualizarCheckIn(@Param("Reservas_id") Integer Reservas_id);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CheckIns WHERE id = :id", nativeQuery = true)
    void eliminarCheckIn(@Param("id") long id);
}
