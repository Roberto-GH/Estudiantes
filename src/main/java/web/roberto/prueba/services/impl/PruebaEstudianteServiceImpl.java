package web.roberto.prueba.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import web.roberto.prueba.dtos.PruebaEstudianteDto;
import web.roberto.prueba.mappers.PruebaEstudianteMapper;
import web.roberto.prueba.models.PruebaEstudianteModel;
import web.roberto.prueba.repositories.PruebaEstudianteRepository;
import web.roberto.prueba.services.PruebaEstudianteService;
import web.roberto.prueba.util.Result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@Validated
public class PruebaEstudianteServiceImpl implements PruebaEstudianteService {

  private final PruebaEstudianteRepository pruebaEstudianteRepository;

  public PruebaEstudianteServiceImpl(PruebaEstudianteRepository pruebaEstudianteRepository) {
    this.pruebaEstudianteRepository = pruebaEstudianteRepository;
  }

  @Override
  public List<PruebaEstudianteDto> findAllPruebaEstudiantes() {
    List<PruebaEstudianteModel> estudiantes = pruebaEstudianteRepository.findAll();
    return estudiantes
      .stream()
      .map(PruebaEstudianteMapper.mapper::pruebaEstudianteModelTDto)
      .collect(Collectors.toList());
  }

  @Override
  public Result<PruebaEstudianteDto> getById(Long id) {
    if (Objects.isNull(id))
      return Result.failure("Id null", 400);
    boolean exist = pruebaEstudianteRepository.existsById(id);
    if(!exist) {
      return Result.failure("Estudiante no encotrado", 400);
    }
    return Result.success(PruebaEstudianteMapper.mapper.pruebaEstudianteModelTDto(pruebaEstudianteRepository.getReferenceById(id)), 200) ;
  }

}
