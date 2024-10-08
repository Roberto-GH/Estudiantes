package web.roberto.prueba.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import web.roberto.prueba.dtos.PruebaEstudianteAllDto;
import web.roberto.prueba.dtos.PruebaEstudianteDto;
import web.roberto.prueba.models.PruebaEstudianteModel;

@Mapper
public interface PruebaEstudianteMapper {

  PruebaEstudianteMapper mapper = Mappers.getMapper(PruebaEstudianteMapper.class);

  @Mapping(target = "id", ignore = true)
  PruebaEstudianteModel pruebaEstudianteDtoToModel(PruebaEstudianteDto pruebaEstudianteDto);

  PruebaEstudianteDto pruebaEstudianteModelToDto(PruebaEstudianteModel pruebaEstudianteModel);

  PruebaEstudianteAllDto pruebaEstudianteModelToAllDto(PruebaEstudianteModel pruebaEstudianteModel);

}
