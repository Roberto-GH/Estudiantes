package web.roberto.prueba.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import web.roberto.prueba.dtos.PruebaEstudianteAllDto;
import web.roberto.prueba.dtos.PruebaEstudianteDto;
import web.roberto.prueba.mappers.PruebaEstudianteMapper;
import web.roberto.prueba.models.PruebaEstudianteModel;
import web.roberto.prueba.repositories.PruebaEstudianteRepository;
import web.roberto.prueba.services.PruebaEstudianteService;
import web.roberto.prueba.util.Result;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
  public List<PruebaEstudianteAllDto> findAllPruebaEstudiantes() {
    List<PruebaEstudianteModel> estudiantes = pruebaEstudianteRepository.findAll();
    return estudiantes.stream().map(PruebaEstudianteMapper.mapper::pruebaEstudianteModelToAllDto).collect(Collectors.toList());
  }

  @Override
  public Result<PruebaEstudianteDto> getById(Long id) {
    if (Objects.isNull(id))
      return Result.failure("Id null", HttpStatus.BAD_REQUEST.value());
    boolean exist = pruebaEstudianteRepository.existsById(id);
    if (!exist)
      return Result.failure("Estudiante no encontrado", HttpStatus.BAD_REQUEST.value());
    return Result.success(PruebaEstudianteMapper.mapper.pruebaEstudianteModelToDto(pruebaEstudianteRepository.getReferenceById(id)), HttpStatus.OK.value());
  }

  @Override
  public PruebaEstudianteDto crearEstudiante(PruebaEstudianteDto request) {
    PruebaEstudianteModel model = pruebaEstudianteRepository.save(PruebaEstudianteMapper.mapper.pruebaEstudianteDtoToModel(request));
    return PruebaEstudianteMapper.mapper.pruebaEstudianteModelToDto(model);
  }

  @Override
  public void deleteEstudiante(Long id) {
    pruebaEstudianteRepository.deleteById(id);
  }

  @Override
  public Result<Void> updateEstudiante(PruebaEstudianteDto request, Long id) {
    boolean exist = pruebaEstudianteRepository.existsById(id);
    if (!exist) {
      return Result.failure("El estudiante no existe", HttpStatus.BAD_REQUEST.value());
    }
    PruebaEstudianteModel model = pruebaEstudianteRepository.getReferenceById(id);
    model.setNombre(Optional.ofNullable(request.getNombre()).orElse(model.getNombre()));
    model.setEspecialidad(Optional.ofNullable(request.getEspecialidad()).orElse(model.getEspecialidad()));
    model.setGrado(Optional.ofNullable(request.getGrado()).orElse(model.getGrado()));
    pruebaEstudianteRepository.save(model);
    return Result.success(null, HttpStatus.OK.value());
  }

}
