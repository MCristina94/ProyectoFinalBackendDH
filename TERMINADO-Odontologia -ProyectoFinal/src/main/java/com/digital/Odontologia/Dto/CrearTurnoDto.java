package com.digital.Odontologia.Dto;

import com.digital.Odontologia.Entity.Odontologo;
import com.digital.Odontologia.Entity.Paciente;

import java.time.LocalDateTime;

public record CrearTurnoDto(LocalDateTime fechaTurno, CrearOdontologoDto odontologo, CrearPacienteDto paciente) {
}
