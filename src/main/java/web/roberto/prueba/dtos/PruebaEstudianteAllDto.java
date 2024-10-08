package web.roberto.prueba.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PruebaEstudianteAllDto {

  private Long id;
  @NotNull(message = "Campo especialidad requerido")
  @NotBlank(message = "Campo especialidad no puede ser vacio")
  private String nombre;
  @NotNull(message = "Campo especialidad requerido")
  @NotBlank(message = "Campo especialidad no puede ser vacio")
  private String especialidad;
  @NotNull(message = "Campo especialidad requerido")
  @NotBlank(message = "Campo especialidad no puede ser vacio")
  private String grado;

}
