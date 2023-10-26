package com.digital.Odontologia.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="ODONTOLOGOS")
public class Odontologo {
    @Id
    @GeneratedValue(generator = "idOdontologo", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ODONTOLOGO")
    private Long idOdontologo;
    @Column(name = "MATRICULA")
    private int matricula;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;


    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL) //En caso de eliminar un odontologo que este enlazado a un turno, se eliminará el turno
    @JsonIgnore
    private List<Turno> turnos;//un odontologo tiene muchos turnos

    public Odontologo(){

    }

}
