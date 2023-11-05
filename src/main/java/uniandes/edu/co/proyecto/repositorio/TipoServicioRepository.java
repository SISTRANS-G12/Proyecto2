package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoServicio;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer>{
 
    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TiposServicio (id, nombre) VALUES (proyectoHotels1_sequence.nextval , :nombre)", nativeQuery = true)
    void insertarTipoServicio(@Param("nombre") String nombre);

    //READ
    @Query(value = "SELECT * FROM TiposServicio", nativeQuery = true)
    Collection<TipoServicio> darTiposServicio();
    @Query(value = "SELECT * FROM TiposServicio WHERE id = :id", nativeQuery = true)
    TipoServicio darTipoServicio(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE TipoServicio SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarTipoServicio(@Param("id") long id, @Param("nombre") String nombre);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TiposServicio WHERE id = :id", nativeQuery = true)
    void eliminarTipoServicio(@Param("id") long id);
}
