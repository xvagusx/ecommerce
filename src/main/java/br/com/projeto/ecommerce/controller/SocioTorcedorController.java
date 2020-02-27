package br.com.projeto.ecommerce.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.dto.SocioTorcedorDTO;
import br.com.projeto.ecommerce.service.SocioTorcedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ecommerce/sociotorcedor")
@Api(value = "/api/ecommerce/sociotorcedor")
public class SocioTorcedorController {

	private static final Logger LOG = LoggerFactory.getLogger(SocioTorcedorController.class);

	@Autowired
	private SocioTorcedorService service;

	@ApiOperation(value = "Incluir um novo Socio Torcedor", notes = "Incluir um novo Socio Torcedor", response = SocioTorcedorDTO.class)
	@PostMapping(value = "/incluir")
	public ResponseEntity<SocioTorcedorDTO> incluir(@RequestBody SocioTorcedorDTO dto) throws Exception {
		LOG.debug("Salvando");
		LOG.debug(dto.toString());
		return ResponseEntity.created(new URI("/api/ecommerce/sociotorcedor/incluir")).body(service.incluir(dto));
	}

}
