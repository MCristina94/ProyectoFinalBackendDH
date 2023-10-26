package com.digital.Odontologia.Controller;

import com.digital.Odontologia.Dto.ActualizarPacienteDto;
import com.digital.Odontologia.Dto.CrearPacienteDto;
import com.digital.Odontologia.Dto.PacienteDto;
import com.digital.Odontologia.Service.PacienteServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PacienteController {
    private final PacienteServiceInterface pacienteService;

    //crea un paciente en la base de datos responde con un status 200
    @PostMapping
    public ResponseEntity<PacienteDto> crearPaciente(@RequestBody CrearPacienteDto request) throws Exception {
        log.info("Me llego: " +request);
        return ResponseEntity.ok().body(pacienteService.crear(request));

    }

    //Trae una lista de todos los pacientes en la base de datos responde con un status 200
    @GetMapping
    public ResponseEntity<List<PacienteDto>> listarPacientes() throws Exception {
        return ResponseEntity.ok().body(pacienteService.listar());
    }

    //Elimina un paciente de acuerdo a su id y responde con un status 200
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws Exception {
        log.info("Me llego: " + id);
        return ResponseEntity.ok().body(pacienteService.eliminar(id));
    }

    //Modifica/actualiza un paciente de acuerdo a la información ingresada
    @PutMapping
    public void modificarPaciente(@RequestBody CrearPacienteDto request) throws Exception {
        log.info("Me llego: " +request);
        pacienteService.modificar(request);
    }

    //busca un paciente y responde un status 200
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarPaciente(@PathVariable Long id) throws Exception {
        log.info("Me llego: " + id);
        return ResponseEntity.ok().body(pacienteService.buscar(id));
    }


}
