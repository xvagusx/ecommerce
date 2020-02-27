package br.com.projeto.ecommerce.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.projeto.ecommerce.dto.CampanhaDTO;
import br.com.projeto.ecommerce.mocks.CampanhaMock;
import br.com.projeto.ecommerce.service.CampanhaService;
import io.restassured.http.ContentType;

@ExtendWith(MockitoExtension.class)
public class CampanhaControllerTests {

	@Mock
	private CampanhaService service;

	@InjectMocks
	private CampanhaController controller;

	private final String URL = "/api/ecommerce/campanha";

	private List<CampanhaDTO> dtoList;
	private CampanhaDTO dto;

	private CampanhaMock mock = new CampanhaMock();

	@BeforeEach
	void beforeEach() {
		dto = mock.getDTO();
		dtoList = mock.getListDTO();
	}

	@Test
	void deveIncluirComSucesso() {
		dto.setId(0L);
		when(service.incluir(any(CampanhaDTO.class))).thenReturn(dto);
		given().standaloneSetup(controller).contentType(ContentType.JSON).body(dto).post(URL + "/incluir").then()
				.statusCode(201);
		assertTrue(true);
	}

	@Test
	void deveAtualizarComSucesso() {
		when(service.atualizar(any(CampanhaDTO.class))).thenReturn(dto);
		given().standaloneSetup(controller).contentType(ContentType.JSON).body(dto).put(URL + "/atualizar", dto).then()
				.statusCode(200);
		assertTrue(true);
	}

	@Test
	void deveListar() {
		doReturn(dtoList).when(service).consultar();
		given().standaloneSetup(controller).contentType(ContentType.JSON).body(dtoList).get(URL + "/consultar").then()
				.statusCode(200);
		assertTrue(true);
	}

	@Test
	void deveDeletarComSucesso() {
		doNothing().when(service).deletar(anyLong());
		given().standaloneSetup(controller).delete(URL + "/deletar/21").then().statusCode(204);
		assertTrue(true);
	}
}
