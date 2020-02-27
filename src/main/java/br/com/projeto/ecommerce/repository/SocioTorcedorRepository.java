package br.com.projeto.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.ecommerce.model.SocioTorcedor;

public interface SocioTorcedorRepository extends JpaRepository<SocioTorcedor, Long> {

	List<SocioTorcedor> findByEmail(String email);

}
