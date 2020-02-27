package br.com.projeto.ecommerce.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.ecommerce.model.Campanha;

public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

	public List<Campanha> findByDataVigenciaGreaterThanEqual(Instant dataVigencia);
}
