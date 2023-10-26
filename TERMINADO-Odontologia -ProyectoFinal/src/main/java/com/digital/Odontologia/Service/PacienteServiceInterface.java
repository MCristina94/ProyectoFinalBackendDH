package com.digital.Odontologia.Service;

import com.digital.Odontologia.Dto.ActualizarPacienteDto;
import com.digital.Odontologia.Dto.CrearPacienteDto;
import com.digital.Odontologia.Dto.PacienteDto;

import java.util.List;

public interface PacienteServiceInterface {
    PacienteDto crear(CrearPacienteDto crearPacienteDto)throws Exception;
    List<PacienteDto> listar()throws Exception;
    PacienteDto modificar(CrearPacienteDto actualizarPacienteDto)throws Exception;
    String eliminar(Long id)throws Exception;
    PacienteDto buscar(Long id)throws Exception;
}
