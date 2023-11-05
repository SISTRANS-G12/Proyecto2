package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Servicios (id, precio, nombre, descripcion, incluido, caracteristica, TiposServicio_id, Locales_id) VALUES ( proyectoHotels1_sequence.nextval , :precio, :nombre, :descripcion, :incluido, :caracteristica, :TiposServicio_id, :Locales_id)", nativeQuery = true)
    void insertarServicio(@Param("precio") Integer precio,
                         @Param("nombre") String nombre,
                         @Param("descripcion") String descripcion,
                         @Param("incluido") Integer incluido,
                         @Param("caracteristica") String caracteristica,
                         @Param("TiposServicio_id") Integer TiposServicio_id,
                         @Param("Locales_id") Integer Locales_id);

    //READ
    @Query(value = "SELECT * FROM Servicios", nativeQuery = true)
    Collection<Servicio> darServicios();
    @Query(value = "SELECT * FROM Servicios WHERE id = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Servicios SET precio = :precio, nombre = :nombre, descripcion = :descripcion, incluido = :incluido, caracteristica = :caracteristica, TiposServicio_id = :TiposServicio_id, Locales_id = :Locales_id WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") long id,
                          @Param("precio") Integer precio,
                          @Param("nombre") String nombre,
                          @Param("descripcion") String descripcion,
                          @Param("incluido") Integer incluido,
                          @Param("caracteristica") String caracteristica,
                          @Param("TiposServicio_id") Integer TiposServicio_id,
                          @Param("Locales_id") Integer Locales_id);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") long id);
}
