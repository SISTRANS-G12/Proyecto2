package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TiposHabitacion")
public class TipoHabitacion{

    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    //Atributos
    private String nombre;
    private Integer capacidad;
    private Integer precio_noche;

    //Constructor
    public TipoHabitacion(){;}

    public TipoHabitacion(String nombre, Integer capacidad, Integer precio_noche)
    {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio_noche = precio_noche;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(Integer precio_noche) {
        this.precio_noche = precio_noche;
    }
}
