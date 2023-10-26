package com.digital.Odontologia.Service;

import com.digital.Odontologia.Dto.ActualizarOdontologoDto;
import com.digital.Odontologia.Dto.CrearOdontologoDto;
import com.digital.Odontologia.Dto.OdontologoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    public OdontologoService odontologoService;
    @Test
    void crearOdontologo() throws Exception {
        CrearOdontologoDto odontologo = new CrearOdontologoDto();
        odontologo.setIdOdontologo(1L);
        odontologo.setNombre("Marlon");
        odontologo.setApellido("Villa");
        odontologo.setMatricula(141512);

        odontologoService.crear(odontologo);
        OdontologoDto odontologoMarlon = odontologoService.buscar(1L);

        assertTrue(odontologoMarlon != null);

    }

    @Test
    void listarOdontologos() throws Exception {
        CrearOdontologoDto odontologo1 = new CrearOdontologoDto();
        odontologo1.setIdOdontologo(1L);
        odontologo1.setNombre("Marlon");
        odontologo1.setApellido("Villa");
        odontologo1.setMatricula(141512);
        CrearOdontologoDto odontologo2 = new CrearOdontologoDto();
        odontologo2.setIdOdontologo(1L);
        odontologo2.setNombre("Lorena");
        odontologo2.setApellido("Villa");
        odontologo2.setMatricula(3333);

        odontologoService.crear(odontologo1);
        odontologoService.crear(odontologo2);

        List<OdontologoDto> lista = odontologoService.listar();
        assertTrue(lista != null);
    }

    @Test
    void modificarOdontologo() throws Exception {
        CrearOdontologoDto odontologo1 = new CrearOdontologoDto();
        odontologo1.setIdOdontologo(1L);
        odontologo1.setNombre("Marlon");
        odontologo1.setApellido("Villa");
        odontologo1.setMatricula(141512);
        odontologoService.crear(odontologo1);

        ActualizarOdontologoDto odontologoModificar = new ActualizarOdontologoDto();
        odontologoModificar.setIdOdontologo(1L);
        odontologoModificar.setNombre("Lorena");
        odontologoModificar.setApellido("Villa");
        odontologoModificar.setMatricula(3333);

        OdontologoDto odontologoModificado = odontologoService.modificar(odontologoModificar);

        assertEquals(odontologoModificado.nombre(), "Lorena");
    }

    @Test
    void eliminarOdontologo() throws Exception {
        CrearOdontologoDto odontologo1 = new CrearOdontologoDto();
        odontologo1.setIdOdontologo(1L);
        odontologo1.setNombre("Marlon");
        odontologo1.setApellido("Villa");
        odontologo1.setMatricula(141512);
        odontologoService.crear(odontologo1);

        assertEquals("Eliminado", odontologoService.eliminar(1L));
    }

    @Test
    void buscarOdontologo() throws Exception {
        CrearOdontologoDto odontologo1 = new CrearOdontologoDto();
        odontologo1.setIdOdontologo(1L);
        odontologo1.setNombre("Marlon");
        odontologo1.setApellido("Villa");
        odontologo1.setMatricula(141512);

        odontologoService.crear(odontologo1);
        OdontologoDto odontologoMarlon = odontologoService.buscar(1L);

        assertEquals(odontologoMarlon.nombre(), "Marlon");
    }
}