package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Tienen")
public class Tienen {

    @EmbeddedId
    private TienenPK pk;

    public Tienen()
    {;}

    public Tienen(Dotacion Dotaciones_id, TipoHabitacion TiposHabitacion_id)
    {
        this.pk = new TienenPK(Dotaciones_id, TiposHabitacion_id);
    }

    public TienenPK getPk() {
        return pk;
    }

    public void setPk(TienenPK pk) {
        this.pk = pk;
    }

}