package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name="Consumos")
public class Consumo {

    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    //Atributos
    private String fecha_consumo;
    private String fecha_reservacion;
    private String empleado_registro;

    //FK
    @ManyToOne
    @JoinColumn(name = "Habitaciones_id", referencedColumnName = "id")
    private Habitacion Habitaciones_id;

    @ManyToOne
    @JoinColumn(name = "Servicios_id", referencedColumnName = "id")
    private Servicio Servicios_id;

    //Constructor
    public Consumo()
    {;}

    public Consumo(Habitacion Habitaciones_id, Servicio Servicios_id, String fecha_consumo, String fecha_reservacion, String empleado_registro){
        this.Habitaciones_id = Habitaciones_id;
        this.Servicios_id = Servicios_id;
        this.fecha_consumo = fecha_consumo;
        this.fecha_reservacion = fecha_reservacion;
        this.empleado_registro = empleado_registro;
    } 

    //Getters y Setters
    public Habitacion getHabitaciones_id() {
        return Habitaciones_id;
    }

    public void setHabitaciones_id(Habitacion habitaciones_id) {
        Habitaciones_id = habitaciones_id;
    }

    public Servicio getServicios_id() {
        return Servicios_id;
    }

    public void setServicios_id(Servicio servicios_id) {
        Servicios_id = servicios_id;
    }

    public String getFecha_consumo() {
        return fecha_consumo;
    }

    public void setFecha_consumo(String fecha_consumo) {
        this.fecha_consumo = fecha_consumo;
    }

    public String getFecha_reservacion(){
        return fecha_reservacion;
    }

    public void setFecha_reservacion(String fecha_reservacion){
        this.fecha_reservacion = fecha_reservacion;
    }

    public String getEmpleado_registro(){
        return this.empleado_registro;
    }

    public void setEmpleado_registro(String empleado_registro){
        this.empleado_registro = empleado_registro;
    }



}