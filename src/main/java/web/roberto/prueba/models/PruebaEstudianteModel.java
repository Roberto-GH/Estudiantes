package web.roberto.prueba.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`PRUEBAESTUDIANTE`")
@Entity
public class PruebaEstudianteModel {

  @Id
  @Column(name = "`Eid`", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column(name = "`Nombre`")
  private String nombre;
  @Column(name = "`Especialidad`")
  private String especialidad;
  @Column(name = "`Grado`")
  private String grado;

}
