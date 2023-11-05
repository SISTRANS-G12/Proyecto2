package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TienenPK implements Serializable{
 
    //PK y FK  
    @ManyToOne
    @JoinColumn(name = "Dotaciones_id", referencedColumnName = "id")
    private Dotacion Dotaciones_id;

    @ManyToOne
    @JoinColumn(name = "TiposHabitacion_id", referencedColumnName = "id")
    private TipoHabitacion TiposHabitacion_id;

    public TienenPK()
    {
        super();
    }

    public TienenPK(Dotacion Dotaciones_id, TipoHabitacion TiposHabitacion_id)
    {
        super();
        this.Dotaciones_id = Dotaciones_id;
        this.TiposHabitacion_id = TiposHabitacion_id;
    }

    //Getters y Setters
    public Dotacion getDotaciones_id() {
        return Dotaciones_id;
    }

    public void setDotaciones_id(Dotacion dotaciones_id) {
        Dotaciones_id = dotaciones_id;
    }

    public TipoHabitacion getTiposHabitacion_id() {
        return TiposHabitacion_id;
    }

    public void setTiposHabitacion_id(TipoHabitacion tiposHabitacion_id) {
        TiposHabitacion_id = tiposHabitacion_id;
    }



    




}

