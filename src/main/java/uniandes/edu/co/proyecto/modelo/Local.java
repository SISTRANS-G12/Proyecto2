package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Locales")
public class Local {
    
    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer id;

    //Atributos
    private Integer capacidad;
    private Integer ocupado;
    private String horario_servicio;

    //Constructor
    public Local()
    {;}

    public Local(Integer capacidad, Integer ocupado, String horario_servicio)
    {
        this.capacidad = capacidad;
        this.ocupado = ocupado;
        this.horario_servicio = horario_servicio;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getOcupado() {
        return ocupado;
    }

    public void setOcupado(Integer ocupado) {
        this.ocupado = ocupado;
    }

    public String getHorario_servicio() {
        return horario_servicio;
    }

    public void setHorario_servicio(String horario_servicio) {
        this.horario_servicio = horario_servicio;
    }
}
