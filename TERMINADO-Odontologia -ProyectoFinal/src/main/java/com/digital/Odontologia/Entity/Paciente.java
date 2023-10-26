package com.digital.Odontologia.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="PACIENTES")
public class Paciente {
    @Id
    @GeneratedValue(generator = "idPaciente",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PACIENTE")
    private Long idPaciente;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "DNI")
    private int dni;

    @Column(name = "FECHA_ALTA")
    private Date fechaAlta;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DOMICILIO_ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL) //En caso de eliminar un paciente que este enlazado a un turno, se eliminará el turno
    @JsonIgnore
    private List<Turno> turnos;//un paciente tiene muchos turnos


    public Paciente(){

    }
}
