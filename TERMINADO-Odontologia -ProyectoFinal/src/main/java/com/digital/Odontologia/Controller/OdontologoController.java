package com.digital.Odontologia.Controller;

import com.digital.Odontologia.Dto.*;
import com.digital.Odontologia.Service.OdontologoServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/odontologos")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OdontologoController {

    private final OdontologoServiceInterface odontologoService;

    //crea un odontologo en la base de datos responde con un status 200
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdontologoDto> crearOdontologo(@RequestBody CrearOdontologoDto request) throws Exception {
        log.info("Me llego: " +request);
        return ResponseEntity.ok().body(odontologoService.crear(request));
    }

    //Trae una lista de todos los odontologos en la base de datos responde con un status 200
    @GetMapping
    public ResponseEntity<List<OdontologoDto>> listarOdontologo() throws Exception {
        return ResponseEntity.ok().body(odontologoService.listar());
    }

    //Elimina un odontologo de acuerdo a su id y responde con un status 200
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws Exception {
        log.info("Me llego: " + id);
        return ResponseEntity.ok().body(odontologoService.eliminar(id));
    }

    //Modifica/actualiza un odontologo de acuerdo a la información ingresada
    @PutMapping
    public void modificarOdontologo(@RequestBody ActualizarOdontologoDto request) throws Exception {
        log.info("Me llego: " +request);
        odontologoService.modificar(request);
    }

    //busca un odontologo y responde un status 200
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDto> buscarOdontologo(@PathVariable Long id) throws Exception {
        log.info("Me llego: " + id);
        return ResponseEntity.ok().body(odontologoService.buscar(id));
    }

}
