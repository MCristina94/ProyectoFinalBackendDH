package com.digital.Odontologia.Dto;

import com.digital.Odontologia.Entity.Turno;

import java.util.List;

public record OdontologoDto(Long idOdontologo, int matricula, String nombre, String apellido, List<Turno> turnos) {

}
