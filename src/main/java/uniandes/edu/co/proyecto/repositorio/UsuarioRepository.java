package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuarios (id, tipo_documento, numero_documento, nombre, correo, TiposUsuario_id) VALUES ( proyectoHotels1_sequence.nextval , :tipo_documento, :numero_documento, :nombre, :correo, :TiposUsuario_id)", nativeQuery = true)
    void insertarUsuario(@Param("tipo_documento") String tipo_documento,
                         @Param("numero_documento") Integer numero_documento,
                         @Param("nombre") String nombre,
                         @Param("correo") String correo,
                         @Param("TiposUsuario_id") Integer TiposUsuario_id);

    //READ
    @Query(value = "SELECT * FROM Usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();
    @Query(value = "SELECT * FROM Usuarios WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuarios SET tipo_documento = :tipo_documento, numero_documento = :numero_documento, nombre = :nombre, correo = :correo, TiposUsuario_id = :TiposUsuario_id WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") long id,
                          @Param("tipo_documento") String tipo_documento,
                          @Param("numero_documento") Integer numero_documento,
                          @Param("nombre") String nombre,
                          @Param("correo") String correo,
                          @Param("TiposUsuario_id") Integer TiposUsuario_id);
 
    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") long id);
}
