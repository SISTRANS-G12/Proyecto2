package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TiposServicio")
public class TipoServicio {

    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    //Atributos
    private String nombre;

    //Constructor
    public TipoServicio(){;}

    public TipoServicio(String nombre)
    {
        this.nombre = nombre;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
