package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Dotacion;

public interface DotacionRepository extends JpaRepository<Dotacion, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Dotaciones (id, nombre, precio) VALUES ( proyectoHotels1_sequence.nextval , :nombre, :precio)", nativeQuery = true)
    void insertarDotacion(@Param("nombre") String nombre,
                         @Param("precio") Integer precio);

    //READ
    @Query(value = "SELECT * FROM Dotaciones", nativeQuery = true)
    Collection<Dotacion> darDotaciones();
    @Query(value = "SELECT * FROM Dotaciones WHERE id = :id", nativeQuery = true)
    Dotacion darDotacion(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Dotaciones SET nombre = :nombre, precio = :precio WHERE id = :id", nativeQuery = true)
    void actualizarDotacion(@Param("id") long id,
                          @Param("nombre") String nombre,
                          @Param("precio") Integer precio);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Dotaciones WHERE id = :id", nativeQuery = true)
    void eliminarDotacion(@Param("id") long id);
}
