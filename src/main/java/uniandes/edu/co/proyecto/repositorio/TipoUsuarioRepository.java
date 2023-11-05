package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
 
    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TiposUsuario (id, nombre) VALUES (proyectoHotels1_sequence.nextval , :nombre)", nativeQuery = true)
    void insertarTipoUsuario(@Param("nombre") String nombre);

    //READ
    @Query(value = "SELECT * FROM TiposUsuario", nativeQuery = true)
    Collection<TipoUsuario> darTiposUsuario();
    @Query(value = "SELECT * FROM TiposUsuario WHERE id = :id", nativeQuery = true)
    TipoUsuario darTipoUsuario(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE TiposUsuario SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarTipoUsuario(@Param("id") long id, @Param("nombre") String nombre);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TiposUsuario WHERE id = :id", nativeQuery = true)
    void eliminarTipoUsuario(@Param("id") long id);
}
