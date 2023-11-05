package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Habitaciones")
public class Habitacion{
    
    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer id;

    //Atributos
    private Integer disponible;
    private Integer cuenta;

    //FK
    @ManyToOne
    @JoinColumn(name = "TiposHabitacion_id", referencedColumnName = "id")
    private TipoHabitacion TiposHabitacion_id;


    //Constructor
    public Habitacion()
    {;}

    public Habitacion(Integer disponible, Integer cuenta, TipoHabitacion TiposHabitacion_id)
    {
        this.disponible = disponible;
        this.cuenta = cuenta;
        this.TiposHabitacion_id = TiposHabitacion_id;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public TipoHabitacion getTiposHabitacion_id() {
        return TiposHabitacion_id;
    }

    public void setTiposHabitacion_id(TipoHabitacion tiposHabitacion_id) {
        TiposHabitacion_id = tiposHabitacion_id;
    }
}
