package web.roberto.prueba.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import web.roberto.prueba.dtos.PruebaEstudianteDto;
import web.roberto.prueba.models.PruebaEstudianteModel;

@Mapper
public interface PruebaEstudianteMapper {

  PruebaEstudianteMapper mapper = Mappers.getMapper(PruebaEstudianteMapper.class);

  PruebaEstudianteModel pruebaEstudianteDtoToModel(PruebaEstudianteDto pruebaEstudianteDto);

  PruebaEstudianteDto pruebaEstudianteModelTDto(PruebaEstudianteModel pruebaEstudianteModel);

}
