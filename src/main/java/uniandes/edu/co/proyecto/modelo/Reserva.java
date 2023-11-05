package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Reservas")
public class Reserva {
    
    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer id;

    //Atributos
    private String fecha_entrada;
    private String fecha_salida;
    private Integer numero_personas;
    private Integer check_in;
    private Integer check_out;

    //FK
    @ManyToOne
    @JoinColumn(name = "PlanesConsumo_id", referencedColumnName = "id")
    private PlanConsumo PlanesConsumo_id;

    @OneToOne
    @JoinColumn(name = "Habitaciones_id", referencedColumnName = "id")
    private Habitacion Habitaciones_id;

    @OneToMany
    @JoinColumn(name = "Usuarios_id", referencedColumnName = "id")
    private Usuario Usuarios_id;


    //Constructor
    public Reserva()
    {;}

    public Reserva(String fecha_entrada, String fecha_salida, Integer numero_personas, Integer check_in, Integer check_out, PlanConsumo PlanesConsumo_id, Habitacion Habitaciones_id, Usuario Usuarios_id)
    {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.numero_personas = numero_personas;
        this.check_in = check_in;
        this.check_out = check_out;
        this.PlanesConsumo_id = PlanesConsumo_id;
        this.Habitaciones_id = Habitaciones_id;
        this.Usuarios_id = Usuarios_id;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Integer getNumero_personas() {
        return numero_personas;
    }

    public void setNumero_personas(Integer numero_personas) {
        this.numero_personas = numero_personas;
    }

    public Integer getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Integer check_in) {
        this.check_in = check_in;
    }

    public Integer getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Integer check_out) {
        this.check_out = check_out;
    }

    public PlanConsumo getPlanesConsumo_id() {
        return PlanesConsumo_id;
    }

    public void setPlanesConsumo_id(PlanConsumo planesConsumo_id) {
        PlanesConsumo_id = planesConsumo_id;
    }

    public Habitacion getHabitaciones_id() {
        return Habitaciones_id;
    }

    public void setHabitaciones_id(Habitacion habitaciones_id) {
        Habitaciones_id = habitaciones_id;
    }

    public Usuario getUsuarios_id(){
        return Usuarios_id;
    }

    public void setUsuarios_id(Usuario usuarios_id){
        Usuarios_id = usuarios_id;
    }
}
