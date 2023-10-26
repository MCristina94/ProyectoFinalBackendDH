package com.digital.Odontologia.Service;

import com.digital.Odontologia.Dto.ActualizarPacienteDto;
import com.digital.Odontologia.Dto.CrearPacienteDto;
import com.digital.Odontologia.Dto.OdontologoDto;
import com.digital.Odontologia.Dto.PacienteDto;
import com.digital.Odontologia.Entity.Domicilio;
import com.digital.Odontologia.Entity.Odontologo;
import com.digital.Odontologia.Entity.Paciente;
import com.digital.Odontologia.Repository.DomicilioRepository;
import com.digital.Odontologia.Repository.PacienteRepository;
import com.digital.Odontologia.Util.ResourceNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PacienteService implements PacienteServiceInterface{

    private final PacienteRepository pacienteRepository;
    private final DomicilioRepository domicilioRepository;
    private final ObjectMapper mapper;



    @Override
    public PacienteDto crear(CrearPacienteDto crearPacienteDto)throws Exception {
        Paciente paciente = null;
        try {
            paciente = mapper.convertValue(crearPacienteDto, Paciente.class);
            pacienteRepository.save(paciente);
            log.info("Se creo un paciente");
        } catch (Exception e) {
            log.error("No fue posible crear el paciente" + e);
            throw new Exception(e);
        }
        return mapper.convertValue(paciente, PacienteDto.class);


    }

    @Override
    public List<PacienteDto> listar() throws Exception {
        List<Paciente> pacientes = null;
        try {
            pacientes = pacienteRepository.findAll();
            for (Paciente paciente: pacientes){
                Hibernate.initialize(paciente.getDomicilio());
            }
        } catch (Exception e) {
            log.error("No fue posible listar los pacientes", e);
            throw new Exception(e);
        }
        return mapper.convertValue(pacientes, new TypeReference<>() {
        });
    }

    @Override
    public PacienteDto modificar(CrearPacienteDto actualizarPacienteDto)throws Exception {

        Paciente paciente = null;
        try {
            paciente = mapper.convertValue(actualizarPacienteDto, Paciente.class);
            pacienteRepository.save(paciente);
            log.info("Se moficaron los datos del paciente");
        } catch (Exception e) {
            log.error("Se presentó error al modificar los datos del paciente ", e);
            throw new Exception(e);
        }
        return mapper.convertValue(paciente, PacienteDto.class);

    }

    @Override
    public String eliminar(Long id)throws Exception{
        try{
            pacienteRepository.deleteById(id);
            log.info("Se eliminó el paciente");
        }catch (Exception e){
            log.error("Se presentó error al eliminar el paciente", e);
            throw new ResourceNotFoundException(id.toString(), "paciente id: ");
        }

        return "Eliminado";
    }

    @Override
    public PacienteDto buscar(Long id)throws Exception {

        PacienteDto pacienteDto = null;
        try {
            Optional<Paciente> paciente = pacienteRepository.findById(id);
            pacienteDto = null;
            if (paciente.isPresent())
                pacienteDto = mapper.convertValue(paciente, PacienteDto.class);
        }catch (Exception e){
            log.error("No fue posible encontrar el paciente");
            throw new ResourceNotFoundException(id.toString(), "paciente id: ");
        }

        return pacienteDto;
    }

    //ESTE ES EL QUE FUNCIONA
}
