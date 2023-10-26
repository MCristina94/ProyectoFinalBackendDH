package com.digital.Odontologia.Service;

import com.digital.Odontologia.Dto.*;

import java.util.List;

public interface OdontologoServiceInterface {
    OdontologoDto crear(CrearOdontologoDto crearOdontologoDto)throws Exception;
    List<OdontologoDto> listar()throws Exception;
    OdontologoDto modificar(ActualizarOdontologoDto actualizarOdontologoDto)throws Exception;
    String eliminar(Long id)throws Exception;
    OdontologoDto buscar(Long id)throws Exception;
}
