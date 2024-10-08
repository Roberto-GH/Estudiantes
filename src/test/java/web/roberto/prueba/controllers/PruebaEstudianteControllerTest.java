package web.roberto.prueba.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import web.roberto.prueba.dtos.PruebaEstudianteAllDto;
import web.roberto.prueba.services.PruebaEstudianteService;

import java.util.Collections;
import java.util.List;

@WebMvcTest(controllers = {PruebaEstudianteController.class})
class PruebaEstudianteControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PruebaEstudianteService service;

  private final PruebaEstudianteAllDto dto = PruebaEstudianteAllDto
    .builder()
    .id(50L)
    .nombre("TEST")
    .especialidad("ESPECIALIDAD")
    .grado("GRADO")
    .build();
  private final List<PruebaEstudianteAllDto> baseAssets = Collections.singletonList(this.dto);

  @Test
  void findAllEstudiantes() throws Exception {
    Mockito.when(service.findAllPruebaEstudiantes()).thenReturn(baseAssets);
    mockMvc
      .perform(MockMvcRequestBuilders.get("/api/estudiantes"))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
      .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
      .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").value(dto.getNombre()))
      .andExpect(MockMvcResultMatchers.jsonPath("$[0].grado").value(dto.getGrado()));
    Mockito.verify(service, Mockito.times(1)).findAllPruebaEstudiantes();
  }

}
