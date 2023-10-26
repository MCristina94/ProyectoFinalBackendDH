package com.digital.Odontologia.Dto;

import com.digital.Odontologia.Entity.Domicilio;
import com.digital.Odontologia.Entity.Turno;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record PacienteDto (Long idPaciente, String nombre, String apellido, Date fechaAlta,int dni, DomicilioDto domicilio, List<Turno> turnos) {

}
