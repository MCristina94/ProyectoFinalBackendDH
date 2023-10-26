package com.digital.Odontologia.Service;

import com.digital.Odontologia.Controller.PacienteController;
import com.digital.Odontologia.Dto.CrearPacienteDto;
import com.digital.Odontologia.Dto.DomicilioDto;
import com.digital.Odontologia.Dto.PacienteDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    public PacienteServiceInterface pacienteService;

    @Test
    void crearPaciente() throws Exception {

        String fecha = "2023-08-23";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaTest = dateFormat.parse(fecha);

        CrearPacienteDto paciente = new CrearPacienteDto();
        paciente.setNombre("Monica");
        paciente.setApellido("Lopez");
        paciente.setDni(12345600);
        paciente.setIdPaciente(1L);
        paciente.setFechaAlta(fechaTest);

        pacienteService.crear(paciente);
        PacienteDto pacienteMonica = pacienteService.buscar(1L);

        assertTrue(pacienteMonica != null);

    }

    @Test
    void listarPacientes() throws Exception {

        CrearPacienteDto paciente1 = new CrearPacienteDto();
        paciente1.setNombre("Monica");
        paciente1.setApellido("Lopez");
        paciente1.setDni(12345600);
        paciente1.setIdPaciente(1L);
        CrearPacienteDto paciente2 = new CrearPacienteDto();
        paciente2.setNombre("Ana");
        paciente2.setApellido("Gonzalez");
        paciente2.setDni(232325656);
        paciente2.setIdPaciente(2L);

        pacienteService.crear(paciente1);
        pacienteService.crear(paciente2);

        List<PacienteDto> lista = pacienteService.listar();
        assertTrue(lista != null);

    }

    @Test
    void modificarPaciente() throws Exception {
        CrearPacienteDto paciente1 = new CrearPacienteDto();
        paciente1.setNombre("Monica");
        paciente1.setApellido("Lopez");
        paciente1.setDni(12345600);
        paciente1.setIdPaciente(1L);
        pacienteService.crear(paciente1);

        CrearPacienteDto pacienteModificar = new CrearPacienteDto();
        pacienteModificar.setNombre("Ana");
        pacienteModificar.setApellido("Gonzalez");
        pacienteModificar.setDni(232325656);
        pacienteModificar.setIdPaciente(1L);

        PacienteDto pacienteModificado = pacienteService.modificar(pacienteModificar);


        assertEquals(pacienteModificado.nombre(), "Ana");

    }

    @Test
    void eliminarPaciente() throws Exception {
        CrearPacienteDto paciente1 = new CrearPacienteDto();
        paciente1.setNombre("Monica");
        paciente1.setApellido("Lopez");
        paciente1.setDni(12345600);
        paciente1.setIdPaciente(1L);
        pacienteService.crear(paciente1);

        assertEquals("Eliminado", pacienteService.eliminar(1L));
    }

    @Test
    void buscarPaciente() throws Exception {


        CrearPacienteDto paciente = new CrearPacienteDto();
        paciente.setNombre("Monica");
        paciente.setApellido("Lopez");
        paciente.setDni(12345600);
        paciente.setIdPaciente(1L);

        pacienteService.crear(paciente);
        PacienteDto pacienteMonica = pacienteService.buscar(1L);

        assertEquals(pacienteMonica.nombre(), "Monica");
    }
}