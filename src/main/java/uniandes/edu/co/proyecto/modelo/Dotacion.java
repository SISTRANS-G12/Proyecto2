package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Dotaciones")
public class Dotacion {

    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    //Atributos
    private String nombre;
    private Integer precio;

    //Constructor
    public Dotacion(){;}

    public Dotacion(String nombre, Integer precio)
    {
        this.nombre = nombre;
        this.precio = precio;
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

    public Integer getPrecio(){
        return precio;
    }

    public void setPrecio(Integer precio){
        this.precio = precio;
    }
}
