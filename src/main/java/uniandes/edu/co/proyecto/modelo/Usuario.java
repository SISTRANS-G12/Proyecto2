package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuario {
    
    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer id;

    //Atributos
    private String tipo_documento;
    private Integer numero_documento;
    private String nombre;
    private String correo_electronico;

    //FK
    @ManyToOne
    @JoinColumn(name = "TiposUsuario_id", referencedColumnName = "id")
    private TipoUsuario TiposUsuario_id;

    //Constructor
    public Usuario()
    {;}

    public Usuario(String tipo_documento, Integer numero_documento, String nombre, String correo_electronico, TipoUsuario TiposUsuario_id)
    {
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.TiposUsuario_id = TiposUsuario_id;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Integer getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(Integer numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public TipoUsuario getTiposUsuario_id() {
        return TiposUsuario_id;
    }

    public void setTiposUsuario_id(TipoUsuario tiposUsuario_id) {
        TiposUsuario_id = tiposUsuario_id;
    }
}
