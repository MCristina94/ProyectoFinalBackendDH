package com.digital.Odontologia.Service;

import com.digital.Odontologia.Dto.ActualizarOdontologoDto;
import com.digital.Odontologia.Dto.CrearOdontologoDto;
import com.digital.Odontologia.Dto.OdontologoDto;
import com.digital.Odontologia.Entity.Odontologo;
import com.digital.Odontologia.Repository.OdontologoRepository;
import com.digital.Odontologia.Util.ResourceNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OdontologoService implements OdontologoServiceInterface {

    private final OdontologoRepository odontologoRepository;
    private final ObjectMapper mapper;

    @Override
    public OdontologoDto crear(CrearOdontologoDto crearOdontologoDto)throws Exception {
        Odontologo odontologo = null;
        try {
            odontologo = mapper.convertValue(crearOdontologoDto, Odontologo.class);
            odontologoRepository.save(odontologo);
            log.info("Se creo un odontologo");
        } catch (Exception e) {
            log.error("No fue posible crear el odontologo" + e);
            throw new Exception(e);
        }
        return mapper.convertValue(odontologo, OdontologoDto.class);
    }

    @Override
    public List<OdontologoDto> listar()throws Exception {
        List<Odontologo> odontologos = null;
        try {
            odontologos = odontologoRepository.findAll();
        } catch (Exception e) {
            log.error("No fue posible listar los odontologos", e);
            throw new Exception(e);
        }
        return mapper.convertValue(odontologos, new TypeReference<>() {
        });
    }

    @Override
    public OdontologoDto modificar(ActualizarOdontologoDto actualizarOdontologoDto) throws Exception {
        Odontologo odontologo = null;
        try {
            odontologo = mapper.convertValue(actualizarOdontologoDto, Odontologo.class);
            odontologoRepository.save(odontologo);
            log.info("Se moficaron los datos del odontologo");
        } catch (Exception e) {
            log.error("Se presentó error al modificar los datos del odontologo ", e);
            throw new Exception(e);

        }
        return mapper.convertValue(odontologo, OdontologoDto.class);
    }

    @Override
    public String eliminar(Long id)throws Exception {
        try{
            odontologoRepository.deleteById(id);
            log.info("Se eliminó el odontologo");
        }catch (Exception e){
            log.error("Se presentó error al eliminar el odontologo", e);
            throw new ResourceNotFoundException(id.toString(), "odontologo id: ");
        }
        return "{ \"msg\": \"Eliminado\" }";
    }

    @Override
    public OdontologoDto buscar(Long id)throws Exception {
        OdontologoDto odontologoDto = null;
        try {
            Optional<Odontologo> odontologo = odontologoRepository.findById(id);
            odontologoDto = null;
            if (odontologo.isPresent())
                odontologoDto = mapper.convertValue(odontologo, OdontologoDto.class);
        }catch (Exception e){
            log.error("No fue posible encontrar el odontologo");
            throw new ResourceNotFoundException(id.toString(), "odontologo id: ");
        }
        return odontologoDto;
    }
}
