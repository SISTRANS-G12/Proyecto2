package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {
    
    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TiposHabitacion (id, nombre, capacidad, precio_noche) VALUES ( proyectoHotels1_sequence.nextval , :nombre, :capacidad, :precio_noche)", nativeQuery = true)
    void insertarTipo_bebida(@Param("nombre") String nombre,
                             @Param("capacidad") Integer capacidad,
                             @Param("precio_noche") Integer precio_noche);

    //READ
    @Query(value = "SELECT * FROM TiposHabitacion", nativeQuery = true)
    Collection<TipoHabitacion> darTiposHabitacion();
    @Query(value = "SELECT * FROM TiposHabitacion WHERE id = :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE TiposHabitacion SET nombre = :nombre, capacidad = :capacidad, precio_noche = :precio_noche WHERE id = :id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id") long id,
                                  @Param("nombre") String nombre,
                                  @Param("capacidad") Integer capacidad,
                                  @Param("precio_noche") Integer precio_noche);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TiposHabitacion WHERE id = :id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") long id);

    
}
