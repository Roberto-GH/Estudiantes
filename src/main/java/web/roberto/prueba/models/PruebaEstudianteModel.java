package web.roberto.prueba.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "`PRUEBAESTUDIANTE`")
@Entity
public class PruebaEstudianteModel {

  @Id
  @Column(name = "`Eid`", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotNull(message = "Campo nombre requerido")
  @NotBlank(message = "Campo nombre no puede ser vacio")
  @Column(name = "`Nombre`")
  private String nombre;
  @NotNull(message = "Campo especialidad requerido")
  @NotBlank(message = "Campo especialidad no puede ser vacio")
  @Column(name = "`Especialidad`")
  private String especialidad;
  @NotNull(message = "Campo grado requerido")
  @NotBlank(message = "Campo grado no puede ser vacio")
  @Column(name = "`Grado`")
  private String grado;

}
