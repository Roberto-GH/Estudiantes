package web.roberto.prueba.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PruebaEstudianteDto {

  private Long id;
  private String nombre;
  private String especialidad;
  private String grado;

}
