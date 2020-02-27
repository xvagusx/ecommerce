package br.com.projeto.ecommerce.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.projeto.ecommerce.dto.SocioTorcedorDTO;
import br.com.projeto.ecommerce.mocks.SocioTorcedorMock;
import br.com.projeto.ecommerce.service.SocioTorcedorService;
import io.restassured.http.ContentType;

@ExtendWith(MockitoExtension.class)
public class SocioTorcedorControllerTests {

	@Mock
	private SocioTorcedorService service;

	@InjectMocks
	private SocioTorcedorController controller;

	private final String URL = "/api/ecommerce/sociotorcedor";

	private SocioTorcedorDTO dto;

	private SocioTorcedorMock mock = new SocioTorcedorMock();

	@BeforeEach
	void beforeEach() {
		dto = mock.getDTO();
	}

	@Test
	void deveIncluirComSucesso() throws Exception {
		dto.setId(0L);
		when(service.incluir(any(SocioTorcedorDTO.class))).thenReturn(dto);
		given().standaloneSetup(controller).contentType(ContentType.JSON).body(dto).post(URL + "/incluir").then()
				.statusCode(201);
	}
}
