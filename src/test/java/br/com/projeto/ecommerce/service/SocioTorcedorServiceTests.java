package br.com.projeto.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.projeto.ecommerce.dto.SocioTorcedorDTO;
import br.com.projeto.ecommerce.mocks.SocioTorcedorMock;
import br.com.projeto.ecommerce.model.SocioTorcedor;
import br.com.projeto.ecommerce.repository.SocioTorcedorRepository;

@ExtendWith(MockitoExtension.class)
public class SocioTorcedorServiceTests {

	@InjectMocks
	private SocioTorcedorService service;

	@Mock
	private SocioTorcedorRepository repository;

	private SocioTorcedorMock mock = new SocioTorcedorMock();

	private SocioTorcedorDTO dto;
	private SocioTorcedor entity;
	private List<SocioTorcedor> listEntity;

	@BeforeEach
	void beforeEach() {
		dto = mock.getDTO();
		entity = mock.getEntity();
		listEntity = mock.getListEntity();
	}

	@Test
	public void incluirComSucesso() throws Exception {
		when(repository.findByEmail(anyString())).thenReturn(new ArrayList<SocioTorcedor>());
		when(repository.save(any(SocioTorcedor.class))).thenReturn(entity);

		service.incluir(dto);

		assertTrue(true);
	}

	@Test
	public void incluirSocioTorcedorIncorreto() {
		assertThrows(Exception.class, () -> {
			service.incluir(null);
		});

		assertTrue(true);
	}

	@Test
	public void incluirEmailNaoInformadoNull() {
		assertThrows(Exception.class, () -> {
			dto.setEmail(null);
			service.incluir(dto);
		});

		assertTrue(true);
	}

	@Test
	public void incluirEmailNaoInformadoVazio() {
		assertThrows(Exception.class, () -> {
			dto.setEmail("");
			service.incluir(dto);
		});

		assertTrue(true);
	}

	@Test
	public void incluirEmailIncorreto() {
		assertThrows(Exception.class, () -> {
			dto.setEmail("xpto.com.br");
			service.incluir(dto);
		});

		assertTrue(true);
	}

	@Test
	public void incluirEmailJaCadastrado() {
		assertThrows(Exception.class, () -> {
			when(repository.findByEmail(anyString())).thenReturn(listEntity);
			service.incluir(dto);
		});

		assertTrue(true);
	}

}
