package com.digital.Odontologia.Controller;

import com.digital.Odontologia.Dto.*;
import com.digital.Odontologia.Service.TurnoServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/turnos")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TurnoController {

    private final TurnoServiceInterface turnoService;

    //crea un Turno en la base de datos responde con un status 200
    @PostMapping
    public ResponseEntity<TurnoDto> crearTurno(@RequestBody CrearTurnoDto request) throws Exception {
        log.info("Me llego: " +request);
        return ResponseEntity.ok().body(turnoService.crear(request));

    }

    //Trae una lista de todos los turnos en la base de datos responde con un status 200
    @GetMapping
    public ResponseEntity<List<TurnoDto>> listarTurnos() throws Exception {
        return ResponseEntity.ok().body(turnoService.listar());
    }

    //Elimina un turno de acuerdo a su id y responde con un status 200
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws Exception {
        log.info("Me llego: " + id);
        return ResponseEntity.ok().body(turnoService.eliminar(id));
    }

    //Modifica/actualiza un turno de acuerdo a la información ingresada
    @PutMapping
    public void modificarTurno(@RequestBody ActualizarTurnoDto request) throws Exception {
        log.info("Me llego: " +request);
        turnoService.modificar(request);
    }

    //busca un turno y responde un status 200
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDto> buscarTurno(@PathVariable Long id) throws Exception {
        log.info("Me llego: " + id);
        return ResponseEntity.ok().body(turnoService.buscar(id));
    }


}
