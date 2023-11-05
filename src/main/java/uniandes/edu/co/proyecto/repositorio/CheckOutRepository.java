package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CheckOut;

public interface CheckOutRepository extends JpaRepository<CheckOut, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CheckOuts(id, Reservas_id) VALUES ( proyectoHotels1_sequence.nextval , :Reservas_id)", nativeQuery = true)
    void insertarCheckOut(@Param("Reservas_id") Integer Reservas_id);

    //READ
    @Query(value = "SELECT * FROM CheckOuts", nativeQuery = true)
    Collection<CheckOut> darCheckOuts();
    @Query(value = "SELECT * FROM CheckOuts WHERE id = :id", nativeQuery = true)
    CheckOut darCheckOut(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE CheckOuts SET Reservas_id = :Reservas_id WHERE id = :id", nativeQuery = true)
    void actualizarCheckOut(@Param("id") long id,
                          @Param("Reservas_id") Integer Reservas_id);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CheckOuts WHERE id = :id", nativeQuery = true)
    void eliminarCheckOut(@Param("id") long id);
}
