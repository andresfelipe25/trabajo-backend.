package api.rest.festivos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.rest.festivos.model.Festivo;

@Repository
public interface FestivoRepository extends JpaRepository<Festivo, Long> {
    boolean existsByDiaAndMes(int dia, int mes); // Define este método
}

