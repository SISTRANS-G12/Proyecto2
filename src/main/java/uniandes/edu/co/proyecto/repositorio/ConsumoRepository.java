package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Consumos (Habitaciones_id, Servicios_id, fecha_consumo, fecha_reservacion, empleado_registro) VALUES (:Habitaciones_id, :Servicios_id, :fecha_consumo, :fecha_reservacion, :empleado_registro)", nativeQuery = true)
    void insertarConsumo(@Param("Habitaciones_id") Integer Habitaciones_id,
                         @Param("Servicios_id") Integer Servicios_id,
                         @Param("fecha_consumo") String fecha_consumo,
                         @Param("fecha_reservacion") String fecha_reservacion,
                         @Param("empleado_registro") String empleado_registro);

    //READ
    @Query(value = "SELECT * FROM Consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();
    @Query(value = "SELECT * FROM Consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumo(@Param("id") Long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value="UPDATE Consumos SET Habitaciones_id = :Habitaciones_id, Servicios_id = :Servicios_id, fecha_consumo = :fecha_consumo, fecha_reservacion = :fecha_reservacion, empleado_registro = :empleado_registro WHERE id = :id", nativeQuery = true)
    void actualizarConsumo(@Param("id") long id,
                           @Param("Habitaciones_id") Integer Habitaciones_id,
                           @Param("Servicios_id") Integer Servicios_id,
                           @Param("fecha_consumo") String fecha_consumo,
                           @Param("fecha_reservacion") String fecha_reservacion,
                           @Param("empleado_registro") String empleado_registro);

    //DELETE
    @Modifying 
    @Transactional
    @Query(value="DELETE FROM Consumos WHERE id = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id") long id);
}
