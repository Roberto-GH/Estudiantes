package web.roberto.prueba.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.roberto.prueba.dtos.PruebaEstudianteAllDto;
import web.roberto.prueba.dtos.PruebaEstudianteDto;
import web.roberto.prueba.services.PruebaEstudianteService;
import web.roberto.prueba.util.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PruebaEstudianteController.API)
@CrossOrigin(origins = "*")
@Slf4j
public class PruebaEstudianteController {

  public static final String API = "/api";
  public static final String ESTUDIANTES = "/estudiantes";
  public static final String ESTUDIANTE = "/estudiante";
  public static final String ID_ID = "/{id}";
  private final PruebaEstudianteService pruebaEstudianteService;

  public PruebaEstudianteController(PruebaEstudianteService pruebaEstudianteService) {
    this.pruebaEstudianteService = pruebaEstudianteService;
  }

  @GetMapping(ESTUDIANTES)
  public ResponseEntity<?> findAllEstudiantes() {
    List<PruebaEstudianteAllDto> estudiantes = pruebaEstudianteService.findAllPruebaEstudiantes();
    return ResponseEntity.status(HttpStatus.OK).body(estudiantes);
  }

  @GetMapping(ESTUDIANTE + ID_ID)
  public ResponseEntity<?> getById(@PathVariable Long id) {
    Result<PruebaEstudianteDto> result = pruebaEstudianteService.getById(id);
    if (!result.isSuccess()) {
      Map<String, String> jsonResponse = new HashMap<>();
      jsonResponse.put("message", result.getError());
      return ResponseEntity.status(HttpStatus.valueOf(result.getCode())).body(jsonResponse);
    }
    return ResponseEntity.status(HttpStatus.OK).body(result.getValue());
  }

  @PostMapping(ESTUDIANTE)
  public ResponseEntity<?> crearEstudiante(@Valid @RequestBody PruebaEstudianteDto request, BindingResult bindingResult) {
    Map<String, String> jsonResponse = new HashMap<>();
    if (bindingResult.hasErrors()) {
      jsonResponse.put("message", "Nombre especialidad y grado con campos requeridos");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
    }
    PruebaEstudianteDto response = pruebaEstudianteService.crearEstudiante(request);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @DeleteMapping(ESTUDIANTE+ID_ID)
  public ResponseEntity<?> deleteEstudiante(@PathVariable Long id) {
    Map<String, String> jsonResponse = new HashMap<>();
    pruebaEstudianteService.deleteEstudiante(id);
    jsonResponse.put("message", "Estudiante eliminado");
    return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
  }

  @PutMapping(ESTUDIANTE+ID_ID)
  public ResponseEntity<?> updateEstudiante(@RequestBody PruebaEstudianteDto request, @PathVariable Long id) {
    Map<String, String> jsonResponse = new HashMap<>();
    Result<Void> result = pruebaEstudianteService.updateEstudiante(request, id);
    if (!result.isSuccess()) {
      jsonResponse.put("message", result.getError());
      return ResponseEntity.status(HttpStatus.valueOf(result.getCode())).body(jsonResponse);
    }
    jsonResponse.put("message", "Estudiante actualizado");
    return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
  }

}
