package br.com.projeto.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.projeto.ecommerce.dto.CampanhaDTO;
import br.com.projeto.ecommerce.mocks.CampanhaMock;
import br.com.projeto.ecommerce.model.Campanha;
import br.com.projeto.ecommerce.repository.CampanhaRepository;

@ExtendWith(MockitoExtension.class)
public class CampanhaServiceTests {

	@InjectMocks
	private CampanhaService service;

	@Mock
	private CampanhaRepository repository;

	private CampanhaMock mock = new CampanhaMock();

	private CampanhaDTO dto;
	private Campanha entity;
	private List<Campanha> listEntity;

	@BeforeEach
	void beforeEach() {
		dto = mock.getDTO();
		entity = mock.getEntity();
		listEntity = mock.getListEntity();
	}

	@Test
	public void incluirComSucesso() {

		when(repository.findByDataVigenciaGreaterThanEqual(any(Instant.class))).thenReturn(new ArrayList<Campanha>());
		when(repository.save(any(Campanha.class))).thenReturn(entity);

		service.incluir(dto);

		assertTrue(true);
	}

	@Test
	public void incluirComSucessoAddDiasCampanha() {

		when(repository.findByDataVigenciaGreaterThanEqual(any(Instant.class))).thenReturn(listEntity);
		when(repository.saveAll(any())).thenReturn(listEntity);
		when(repository.save(any(Campanha.class))).thenReturn(entity);

		service.incluir(dto);
		assertTrue(true);

	}

	@Test
	public void consultarComSucesso() {
		when(repository.findByDataVigenciaGreaterThanEqual(any(Instant.class))).thenReturn(listEntity);

		service.consultar();
		assertTrue(true);

	}

	@Test
	public void atualizarComSucesso() {
		when(repository.save(any(Campanha.class))).thenReturn(entity);

		service.atualizar(dto);
		assertTrue(true);
	}

	@Test
	public void deletarComSucesso() {
		doNothing().when(repository).deleteById(anyLong());

		service.deletar(dto.getId());
		assertTrue(true);
	}
}
