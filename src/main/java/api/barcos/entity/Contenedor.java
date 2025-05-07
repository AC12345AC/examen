package api.barcos.entity;
import jakarta.persistence.*;

import java.time.LocalDate;

import lombok.*;
@Entity @Table(name = "contenedores")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class Contenedor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="vin", nullable = false)
    private String vin; 
    @Column(name = "fecha", nullable = false)
     private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_barco", nullable = false)
    private Barco barco;

}





