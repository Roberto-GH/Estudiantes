package web.roberto.prueba.services;

import web.roberto.prueba.dtos.PruebaEstudianteAllDto;
import web.roberto.prueba.dtos.PruebaEstudianteDto;
import web.roberto.prueba.util.Result;

import java.util.List;

public interface PruebaEstudianteService {

  List<PruebaEstudianteAllDto> findAllPruebaEstudiantes();

  Result<PruebaEstudianteDto> getById(Long id);

  PruebaEstudianteDto crearEstudiante(PruebaEstudianteDto request);

  void deleteEstudiante(Long id);

  Result<Void> updateEstudiante(PruebaEstudianteDto request, Long id);

}
