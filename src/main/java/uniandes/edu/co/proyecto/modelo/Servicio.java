package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Servicios")
public class Servicio {
    
    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer id;

    //Atributos
    private Integer precio;
    private String nombre;
    private String descripcion;
    private Integer incluido;
    private String caracteristica;
    
    
    //FK
    @ManyToOne
    @JoinColumn(name = "TiposServicio_id", referencedColumnName = "id")
    private TipoServicio TiposServicio_id;
 
    @OneToOne
    @JoinColumn(name = "Locales_id", referencedColumnName = "id")
    private Local Locales_id;


    //Constructor
    public Servicio()
    {;}

    public Servicio(Integer precio, String nombre, String descripcion, Integer incluido, String caracteristica, TipoServicio TiposServicio_id, Local Locales_id)
    {
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.incluido = incluido;
        this.caracteristica = caracteristica;
        this.TiposServicio_id = TiposServicio_id;
        this.Locales_id = Locales_id;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIncluido() {
        return incluido;
    }

    public void setIncluido(Integer incluido) {
        this.incluido = incluido;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public TipoServicio getTiposServicio_id() {
        return TiposServicio_id;
    }

    public void setTiposServicio_id(TipoServicio tiposServicio_id) {
        TiposServicio_id = tiposServicio_id;
    }

    public Local getLocales_id() {
        return Locales_id;
    }

    public void setLocales_id(Local locales_id) {
        Locales_id = locales_id;
    } 
}
