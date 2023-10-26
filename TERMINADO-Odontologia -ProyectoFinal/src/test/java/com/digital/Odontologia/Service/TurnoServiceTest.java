package com.digital.Odontologia.Service;

import com.digital.Odontologia.Dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TurnoServiceTest {

    @Autowired
    public TurnoService turnoService;
    @Autowired
    public OdontologoService odontologoService;
    @Autowired
    public PacienteServiceInterface pacienteService;
    @Test
    void crearTurno() throws Exception {
        CrearOdontologoDto odontologo = new CrearOdontologoDto();
        odontologo.setIdOdontologo(1L);
        odontologo.setNombre("Marlon");
        odontologo.setApellido("Villa");
        odontologo.setMatricula(141512);
        odontologoService.crear(odontologo);

        CrearPacienteDto paciente = new CrearPacienteDto();
        paciente.setNombre("Monica");
        paciente.setApellido("Lopez");
        paciente.setDni(12345600);
        paciente.setIdPaciente(1L);
        pacienteService.crear(paciente);

        LocalDateTime fechaActual = LocalDateTime.now();
        CrearTurnoDto turno = new CrearTurnoDto(fechaActual, odontologo, paciente);
        turnoService.crear(turno);

        TurnoDto turnoTest = turnoService.buscar(1L);

        assertTrue(turnoTest != null);
    }

    @Test
    void listarTurnos() throws Exception {
        CrearOdontologoDto odontologo = new CrearOdontologoDto();
        odontologo.setIdOdontologo(1L);
        odontologo.setNombre("Marlon");
        odontologo.setApellido("Villa");
        odontologo.setMatricula(141512);
        odontologoService.crear(odontologo);

        CrearPacienteDto paciente = new CrearPacienteDto();
        paciente.setNombre("Monica");
        paciente.setApellido("Lopez");
        paciente.setDni(12345600);
        paciente.setIdPaciente(1L);
        pacienteService.crear(paciente);

        LocalDateTime fechaActual = LocalDateTime.now();
        CrearTurnoDto turno = new CrearTurnoDto(fechaActual, odontologo, paciente);
        turnoService.crear(turno);

        List<TurnoDto> lista = turnoService.listar();
        assertTrue(lista != null);

    }

    @Test
    void modificarTurno() throws Exception {
        CrearOdontologoDto odontologo = new CrearOdontologoDto();
        odontologo.setIdOdontologo(1L);
        odontologo.setNombre("Marlon");
        odontologo.setApellido("Villa");
        odontologo.setMatricula(141512);
        odontologoService.crear(odontologo);

        CrearPacienteDto paciente = new CrearPacienteDto();
        paciente.setNombre("Monica");
        paciente.setApellido("Lopez");
        paciente.setDni(12345600);
        paciente.setIdPaciente(1L);
        pacienteService.crear(paciente);

        LocalDateTime fechaActual = LocalDateTime.now();
        CrearTurnoDto turno = new CrearTurnoDto(fechaActual, odontologo, paciente);
        turnoService.crear(turno);

        ActualizarOdontologoDto odontologoModificar = new ActualizarOdontologoDto();
        odontologoModificar.setIdOdontologo(1L);
        odontologoModificar.setNombre("Lorena");
        odontologoModificar.setApellido("Villa");
        odontologoModificar.setMatricula(3333);

        ActualizarTurnoDto turnoActualizado = new ActualizarTurnoDto(1L, fechaActual, odontologoModificar, paciente );

        TurnoDto turnoModificado = turnoService.modificar(turnoActualizado);

        assertEquals(turnoModificado.odontologo().nombre(), "Lorena");

    }

    @Test
    void eliminarTurno() throws Exception {
        CrearOdontologoDto odontologo = new CrearOdontologoDto();
        odontologo.setIdOdontologo(1L);
        odontologo.setNombre("Marlon");
        odontologo.setApellido("Villa");
        odontologo.setMatricula(141512);
        odontologoService.crear(odontologo);

        CrearPacienteDto paciente = new CrearPacienteDto();
        paciente.setNombre("Monica");
        paciente.setApellido("Lopez");
        paciente.setDni(12345600);
        paciente.setIdPaciente(1L);
        pacienteService.crear(paciente);

        LocalDateTime fechaActual = LocalDateTime.now();
        CrearTurnoDto turno = new CrearTurnoDto(fechaActual, odontologo, paciente);
        turnoService.crear(turno);

        assertEquals("Eliminado", turnoService.eliminar(1L));

    }

    @Test
    void buscarTurno() throws Exception {
        CrearOdontologoDto odontologo = new CrearOdontologoDto();
        odontologo.setIdOdontologo(1L);
        odontologo.setNombre("Marlon");
        odontologo.setApellido("Villa");
        odontologo.setMatricula(141512);
        odontologoService.crear(odontologo);

        CrearPacienteDto paciente = new CrearPacienteDto();
        paciente.setNombre("Monica");
        paciente.setApellido("Lopez");
        paciente.setDni(12345600);
        paciente.setIdPaciente(1L);
        pacienteService.crear(paciente);

        LocalDateTime fechaActual = LocalDateTime.now();
        CrearTurnoDto turno = new CrearTurnoDto(fechaActual, odontologo, paciente);
        turnoService.crear(turno);

        TurnoDto turnoTest = turnoService.buscar(1L);

        assertEquals(turnoTest.odontologo().nombre(), "Marlon");

    }
}