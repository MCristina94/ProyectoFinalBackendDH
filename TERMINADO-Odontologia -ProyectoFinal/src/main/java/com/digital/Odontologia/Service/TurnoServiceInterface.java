package com.digital.Odontologia.Service;

import com.digital.Odontologia.Dto.*;

import java.util.List;

public interface TurnoServiceInterface {
    TurnoDto crear(CrearTurnoDto crearTurnoDto)throws Exception;
    List<TurnoDto> listar()throws Exception;
    TurnoDto modificar(ActualizarTurnoDto actualizarTurnoDto)throws Exception;
    String eliminar(Long id)throws Exception;
    TurnoDto buscar(Long id)throws Exception;
}
