package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PlanesConsumo")
public class PlanConsumo{

    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    //Atributos
    private String descripcion;
    private Float descuento;
    private Integer precio_fijo;

    //Constructor
    public PlanConsumo(){;}

    public PlanConsumo(String descripcion, Float descuento, Integer precio_fijo)
    {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.precio_fijo = precio_fijo;
    }
    //Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Integer getPrecio_fijo() {
        return precio_fijo;
    }

    public void setPrecio_fijo(Integer precio_fijo) {
        this.precio_fijo = precio_fijo;
    }
}

