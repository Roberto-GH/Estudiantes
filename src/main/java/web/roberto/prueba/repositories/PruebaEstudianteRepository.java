package web.roberto.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.roberto.prueba.models.PruebaEstudianteModel;

@Repository
public interface PruebaEstudianteRepository extends JpaRepository<PruebaEstudianteModel, Long> {



}

