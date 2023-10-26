package com.digital.Odontologia.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name="TURNOS")
public class Turno {
    @Id
    @GeneratedValue(generator = "idTurno",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long idTurno;

    @Column(name = "FECHA_HORA_TURNO")
    private LocalDateTime fechaTurno;

    @ManyToOne
    @JoinColumn(name = "ID_ODONTOLOGO")
    private Odontologo odontologo;


    @ManyToOne
    @JoinColumn(name = "ID_PACIENTE")
    private Paciente paciente;
}
