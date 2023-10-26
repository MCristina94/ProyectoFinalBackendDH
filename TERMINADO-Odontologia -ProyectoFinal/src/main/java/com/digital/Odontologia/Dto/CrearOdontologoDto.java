package com.digital.Odontologia.Dto;

import com.digital.Odontologia.Entity.Turno;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

public class CrearOdontologoDto {

    private Long idOdontologo;
    private int matricula;
    private String nombre;
    private String apellido;
    private List<Turno> turnos;

    public CrearOdontologoDto() {
    }

    public CrearOdontologoDto(Long idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public Long getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(Long idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }


}
