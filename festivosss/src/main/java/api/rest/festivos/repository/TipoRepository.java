package api.rest.festivos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.rest.festivos.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {}

