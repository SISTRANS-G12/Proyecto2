package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Reservas (id, fecha_entrada, fecha_salida, numero_personas, check_in, check_out, PlanesConsumo_id, Habitaciones_id, Usuarios_id) VALUES ( proyectoHotels1_sequence.nextval , :fecha_entrada, :fecha_salida, :numero_personas, :check_in, :check_out, :PlanesConsumo_id, :Habitaciones_id, :Usuarios_id)", nativeQuery = true)
    void insertarReserva(@Param("fecha_entrada") String fecha_entrada,
                         @Param("fecha_salida") String fecha_salida,
                         @Param("numero_personas") Integer numero_personas,
                         @Param("check_in") Integer check_in,
                         @Param("check_out") Integer check_out,
                         @Param("PlanesConsumo_id") Integer PlanesConsumo_id,
                         @Param("Habitaciones_id") Integer Habitaciones_id,
                         @Param("Usuarios_id") Integer Usuarios_id);

    //READ
    @Query(value = "SELECT * FROM Reservas", nativeQuery = true)
    Collection<Reserva> darReservas();
    @Query(value = "SELECT * FROM Reservas WHERE id = :id", nativeQuery = true)
    Reserva darReserva(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Reservas SET fecha_entrada = :fecha_entrada, fecha_salida = :fecha_salida, numero_personas = :numero_personas, check_in = :check_in, check_out = :check_out, PlanesConsumo_id = :PlanesConsumo_id, Habitaciones_id = :Habitaciones_id, Usuarios_id = :Usuarios_id WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param("id") long id,
                          @Param("fecha_entrada") String fecha_entrada,
                          @Param("fecha_salida") String fecha_salida,
                          @Param("numero_personas") Integer numero_personas,
                          @Param("check_in") Integer check_in,
                          @Param("check_out") Integer check_out,
                          @Param("PlanesConsumo_id") Integer PlanesConsumo_id,
                          @Param("Habitaciones_id") Integer Habitaciones_id,
                          @Param("Usuarios_id") Integer Usuarios_id);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Reservas WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") long id);
}
