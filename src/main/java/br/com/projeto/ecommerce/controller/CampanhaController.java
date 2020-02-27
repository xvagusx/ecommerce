package br.com.projeto.ecommerce.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.dto.CampanhaDTO;
import br.com.projeto.ecommerce.service.CampanhaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ecommerce/campanha")
@Api(value = "/api/ecommerce/campanha")
public class CampanhaController {

	private static final Logger LOG = LoggerFactory.getLogger(CampanhaController.class);

	@Autowired
	private CampanhaService service;

	@ApiOperation(value = "Incluir nova campanha", notes = "Incluir nova campanha", response = CampanhaDTO.class)
	@PostMapping(value = "/incluir")
	public ResponseEntity<CampanhaDTO> incluir(@RequestBody CampanhaDTO campanhaDTO) throws URISyntaxException {
		LOG.debug("Salvando");
		LOG.debug(campanhaDTO.toString());
		return ResponseEntity.created(new URI("/api/ecommerce/campanha/incluir")).body(service.incluir(campanhaDTO));
	}

	@ApiOperation(value = "Consultar campanhas cadastradas vigentes", notes = "Consulta as campanhas cadastradas vigentes", response = CampanhaDTO.class)
	@GetMapping(value = "/consultar")
	public ResponseEntity<List<CampanhaDTO>> consultar() {
		LOG.debug("Buscando campanha vigentes");
		return ResponseEntity.ok().body(service.consultar());
	}

	@ApiOperation(value = "Atualizar uma campanha", notes = "Atualiza uma campanha", response = CampanhaDTO.class)
	@PutMapping(value = "/atualizar")
	public ResponseEntity<CampanhaDTO> salvar(@RequestBody CampanhaDTO campanhaDTO) {
		LOG.debug("Atualizando campanha");
		LOG.debug(campanhaDTO.toString());
		return ResponseEntity.ok().body(service.atualizar(campanhaDTO));
	}

	@ApiOperation(value = "Deletar uma campanha", notes = "Deleta uma campanha utilizando o id")
	@DeleteMapping(value = "/deletar/{idCampanha}")
	public ResponseEntity<Void> deletar(@PathVariable Long idCampanha) {
		LOG.debug("Deletando campanha pelo id " + idCampanha);
		service.deletar(idCampanha);
		return ResponseEntity.noContent().build();
	}

}
