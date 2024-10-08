package web.roberto.prueba.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.roberto.prueba.dtos.PruebaEstudianteDto;
import web.roberto.prueba.services.PruebaEstudianteService;

import java.util.List;

@RestController
@RequestMapping(PruebaEstudianteController.API)
@CrossOrigin(origins = "*")
@Slf4j
//@CrossOrigin(origins = "${cross.origins}")
public class PruebaEstudianteController {

  public static final String API = "/api";
  public static final String ESTUDIANTES = "/estudiantes";
  public static final String UPDATE = "/update-estudiante";
  public static final String DELETE = "/delete-estudiante";
  public static final String ID_ID = "/{id}";
  private final PruebaEstudianteService pruebaEstudianteService;

  public PruebaEstudianteController(PruebaEstudianteService pruebaEstudianteService) {
    this.pruebaEstudianteService = pruebaEstudianteService;
  }

  @GetMapping(ESTUDIANTES)
  public ResponseEntity<?> findAllUsers() {
    List<PruebaEstudianteDto> estudiantes = pruebaEstudianteService.findAllPruebaEstudiantes();
    return ResponseEntity.status(HttpStatus.OK).body(estudiantes);
  }

}
