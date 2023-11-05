package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    
    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Habitaciones (id, disponible, cuenta, TiposHabitacion_id) VALUES ( proyectoHotels1_sequence.nextval , :disponible, :cuenta, :TiposHabitacion_id)", nativeQuery = true)
    void insertarHabitacion(@Param("disponible") Integer disponible, 
                        @Param("cuenta") Integer cuenta,
                        @Param("TiposHabitacion_id") Integer TiposHabitacion_id);

    //READ
    @Query(value = "SELECT * FROM Habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();
    @Query(value = "SELECT * FROM Habitaciones WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") long id);
    
    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Habitaciones SET disponible = :disponible, cuenta = :cuenta, TiposHabitacion_id = :TiposHabitacion_id WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") long id,
                          @Param("disponible") Integer disponible,
                          @Param("cuenta") Integer cuenta,
                          @Param("TiposHabitacion_id") Integer TiposHabitacion_id);
                        
    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") long id);
    
}
