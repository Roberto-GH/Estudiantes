package web.roberto.prueba.services;

import web.roberto.prueba.dtos.PruebaEstudianteDto;

import java.util.List;

public interface PruebaEstudianteService {

  List<PruebaEstudianteDto> findAllPruebaEstudiantes();
  PruebaEstudianteDto getById();

}
