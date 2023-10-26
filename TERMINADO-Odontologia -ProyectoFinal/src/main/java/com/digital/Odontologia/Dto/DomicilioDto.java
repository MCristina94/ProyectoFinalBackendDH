package com.digital.Odontologia.Dto;

import com.digital.Odontologia.Entity.Paciente;

public record DomicilioDto(Long idDomicilio, String calle, int numero, String ciudad, String departamento) {
}
