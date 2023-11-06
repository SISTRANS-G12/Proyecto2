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
    private boolean ocupado;

    //Constructor
    public Local()
    {;}

    public Local(Integer capacidad, boolean ocupado)
    {
        this.capacidad = capacidad;
        this.ocupado = ocupado;
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

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
