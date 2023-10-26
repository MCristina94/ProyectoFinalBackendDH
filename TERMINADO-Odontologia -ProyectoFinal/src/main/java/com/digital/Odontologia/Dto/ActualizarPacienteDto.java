package com.digital.Odontologia.Dto;

import com.digital.Odontologia.Entity.Domicilio;
import com.digital.Odontologia.Entity.Turno;

import java.util.Date;
import java.util.List;

public class ActualizarPacienteDto {
    private Long idPaciente;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fechaAlta;
    private ActualizarTurnoDto domicilio;
    private List<Turno> tunos;

    public ActualizarPacienteDto() {
    }

    public ActualizarPacienteDto(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public ActualizarTurnoDto getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(ActualizarTurnoDto domicilio) {
        this.domicilio = domicilio;
    }

    public List<Turno> getTunos() {
        return tunos;
    }

    public void setTunos(List<Turno> tunos) {
        this.tunos = tunos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
