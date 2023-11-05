package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Local;

public interface LocalRepository extends JpaRepository<Local, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Locales (id, capacidad, ocupado, horario_servicio) VALUES ( proyectoHotels1_sequence.nextval , :capacidad, :ocupado, :horario_servicio)", nativeQuery = true)
    void insertarLocal(@Param("capacidad") Integer capacidad,
                         @Param("ocupado") Integer ocupado,
                         @Param("horario_servicio") String horario_servicio);

    //READ
    @Query(value = "SELECT * FROM Locales", nativeQuery = true)
    Collection<Local> darLocales();
    @Query(value = "SELECT * FROM Locales WHERE id = :id", nativeQuery = true)
    Local darLocal(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Locales SET capacidad = :capacidad, ocupado = :ocupado, horario_servicio = :horario_servicio WHERE id = :id", nativeQuery = true)
    void actualizarLocal(@Param("id") long id,
                          @Param("capacidad") Integer capacidad,
                          @Param("ocupado") Integer ocupado,
                          @Param("horario_servicio") String horario_servicio);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Locales WHERE id = :id", nativeQuery = true)
    void eliminarLocal(@Param("id") long id);
}
