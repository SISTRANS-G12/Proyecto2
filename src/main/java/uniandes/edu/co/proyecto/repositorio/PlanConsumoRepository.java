package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer>{

    //CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PlanesConsumo (id, descripcion, descuento, precio_fijo) VALUES ( proyectoHotels1_sequence.nextval , :descripcion, :descuento, :precio_fijo)", nativeQuery = true)
    void insertarPlanConsumo(@Param("descripcion") String descripcion,
                         @Param("descuento") Double descuento,
                         @Param("precio_fijo") Integer precio_fijo);

    //READ
    @Query(value = "SELECT * FROM PlanesConsumo", nativeQuery = true)
    Collection<PlanConsumo> darPlanesConsumo();
    @Query(value = "SELECT * FROM PlanesConsumo WHERE id = :id", nativeQuery = true)
    PlanConsumo darPlanConsumo(@Param("id") long id);

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE PlanesConsumo SET descripcion = :descripcion, descuento = :descuento, precio_fijo = :precio_fijo WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo(@Param("id") long id,
                          @Param("descripcion") String descripcion,
                          @Param("descuento") Double descuento,
                          @Param("precio_fijo") Integer precio_fijo);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PlanesConsumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumo(@Param("id") long id);
}
