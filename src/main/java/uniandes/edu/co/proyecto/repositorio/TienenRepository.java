package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Tienen;

public interface TienenRepository extends JpaRepository<Tienen, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Tienen (Dotaciones_id, TiposHabitacion_id) VALUES (:Dotaciones_id, :TiposHabitacion_id)", nativeQuery = true)
    void insertarTienen(@Param("Dotaciones_id") Integer Dotaciones_id,
                         @Param("TiposHabitacion_id") Integer TiposHabitacion_id);

    //READ
    @Query(value = "SELECT * FROM Tienen", nativeQuery = true)
    Collection<Tienen> darTienenTodos();
    @Query(value = "SELECT * FROM Tienen WHERE Dotaciones_id = :Dotaciones_id AND TiposHabitacion_id = :TiposHabitacion_id", nativeQuery = true)
    Tienen darTienen(@Param("Dotaciones_id") Integer Dotaciones_id,
                     @Param("TiposHabitacion_id") Integer TiposHabitacion_id);
    
    //No incluimos update porque no se puede, todos los atributos forman parte de la PK, por lo que no puede haber duplicados,
    //La unica forma de "Actualizar" una reservacion de servicio es borrandola y creando otra.

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Tienen WHERE Dotaciones_id = :Dotaciones_id AND TiposHabitacion_id = :TiposHabitacion_id", nativeQuery = true)
    void eliminarTienen(@Param("Dotaciones_id") Integer Dotaciones_id,
                        @Param("TiposHabitacion_id") Integer TiposHabitacion_id);
}
