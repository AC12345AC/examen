package api.barcos.entity;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "barcos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class Barco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="origen", nullable = false)
    private String origen; 
    @Column(name="destino", nullable = false)
    private String destino;
    @Column(name="capacidad", nullable = false)
    private int capacidad; 

    
}

