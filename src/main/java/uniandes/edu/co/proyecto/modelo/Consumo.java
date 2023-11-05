package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Consumos")
public class Consumo {

    @EmbeddedId
    private ConsumoPK pk;

    public Consumo()
    {;}

    public Consumo(Habitacion Habitaciones_id, Servicio Servicios_id, String fecha_consumo, String fecha_reservacion, String empleado_registro)
    {
        this.pk = new ConsumoPK(Habitaciones_id, Servicios_id, fecha_consumo, fecha_reservacion, empleado_registro);
    }

    public ConsumoPK getPk() {
        return pk;
    }

    public void setPk(ConsumoPK pk) {
        this.pk = pk;
    }

}