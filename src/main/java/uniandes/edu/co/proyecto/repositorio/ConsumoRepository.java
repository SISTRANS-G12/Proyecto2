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
    @Query(value = "INSERT INTO Consumos (Habitaciones_id, Servicios_id, fecha_consumo) VALUES (:Habitaciones_id, :Servicios_id, :fecha_consumo)", nativeQuery = true)
    void insertarConsumo(@Param("Habitaciones_id") Integer Habitaciones_id,
                         @Param("Servicios_id") Integer Servicios_id,
                         @Param("fecha_consumo") String fecha_consumo);

    //READ
    @Query(value = "SELECT * FROM Consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();
    @Query(value = "SELECT * FROM Consumos WHERE Habitaciones_id = :Habitaciones_id AND Servicios_id = :Servicios_id", nativeQuery = true)
    Collection<Consumo> darConsumosPorId(@Param("Habitaciones_id") Integer Habitaciones_id,
                             @Param("Servicios_id") Integer Servicios_id);
    @Query(value = "SELECT * FROM Consumos WHERE Habitaciones_id = :Habitaciones_id AND Servicios_id = :Servicios_id AND fecha_consumo = :fecha_consumo", nativeQuery = true)
    Consumo darConsumo(@Param("Habitaciones_id") Integer Habitaciones_id,
                       @Param("Servicios_id") Integer Servicios_id,
                       @Param("fecha_consumo") String fecha_consumo);

    //No incluimos update porque no se puede, todos los atributos forman parte de la PK, por lo que no puede haber duplicados,
    //La unica forma de "Actualizar" una reservacion de servicio es borrandola y creando otra.

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Consumos WHERE Habitaciones_id = :Habitaciones_id AND Servicios_id = :Servicios_id AND fecha_consumo = :fecha_consumo", nativeQuery = true)
    void eliminarConsumo(@Param("Habitaciones_id") Integer Habitaciones_id,
                         @Param("Servicios_id") Integer Servicios_id,
                         @Param("fecha_consumo") String fecha_consumo);
}
