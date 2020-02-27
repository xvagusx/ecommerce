package br.com.projeto.ecommerce.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.dto.CampanhaDTO;
import br.com.projeto.ecommerce.model.Campanha;
import br.com.projeto.ecommerce.repository.CampanhaRepository;
import br.com.projeto.ecommerce.service.mapper.CampanhaMapper;

@Service
public class CampanhaService {

	private static final int DIAS_ADICIONADOS = 1;

	@Autowired
	private CampanhaRepository repository;

	private CampanhaMapper mapper = new CampanhaMapper();

	/**
	 * Metodo utilizado para incluir campanha
	 *
	 * @param campanhaDTO
	 * @return
	 */
	public CampanhaDTO incluir(CampanhaDTO campanhaDTO) {
		adicionaDiaCampanha(consultar());

		Campanha novaCampanha = repository.save(mapper.toEntity(campanhaDTO));
		return mapper.toDto(novaCampanha);
	}

	/**
	 * Metodo utilizado para consultar campanhas vigentes
	 *
	 * @return
	 */
	public List<CampanhaDTO> consultar() {
		Instant dataAtual = Instant.now().truncatedTo(ChronoUnit.DAYS);
		return repository.findByDataVigenciaGreaterThanEqual(dataAtual).stream().map(mapper::toDto)
				.collect(Collectors.toList());
	}

	/**
	 * Metodo utilizado para atualizar campanha
	 *
	 * @param campanhaDTO
	 * @return
	 */
	public CampanhaDTO atualizar(CampanhaDTO campanhaDTO) {
		Campanha campanha = repository.save(mapper.toEntity(campanhaDTO));
		return mapper.toDto(campanha);
	}

	/**
	 * Metodo utilizado para deleta camapanha
	 *
	 * @param idCampanha
	 */
	public void deletar(Long idCampanha) {
		repository.deleteById(idCampanha);
	}

	/**
	 * Metodo utilizado para adiciona dia a campanha vigente
	 *
	 * @param listaCampanha
	 * @return listaCampanhaAtualizada
	 */
	private List<CampanhaDTO> adicionaDiaCampanha(List<CampanhaDTO> listaCampanha) {
		List<CampanhaDTO> listaCampanhaAtualizada = new ArrayList<CampanhaDTO>();
		if (!listaCampanha.isEmpty()) {

			for (CampanhaDTO dto : listaCampanha) {
				dto.setDataVigencia(dto.getDataVigencia().plus(DIAS_ADICIONADOS, ChronoUnit.DAYS));
			}

			listaCampanhaAtualizada = repository.saveAll(mapper.toEntity(listaCampanha)).stream().map(mapper::toDto)
					.collect(Collectors.toList());
		}
		return listaCampanhaAtualizada;
	}

}
