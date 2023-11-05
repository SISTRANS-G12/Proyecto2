package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CheckOuts")
public class CheckOut{
    
    //PK
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer id;

    //FK 
    @OneToOne
    @JoinColumn(name = "Reservas_id", referencedColumnName = "id")
    private Reserva Reservas_id;

    //Constructor
    public CheckOut()
    {;}

    public CheckOut(Reserva Reservas_id)
    {
        this.Reservas_id = Reservas_id;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reserva getReservas_id() {
        return Reservas_id;
    }

    public void setReservas_id(Reserva reservas_id) {
        Reservas_id = reservas_id;
    }
}
