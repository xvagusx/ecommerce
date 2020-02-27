package br.com.projeto.ecommerce.mocks;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import br.com.projeto.ecommerce.dto.CampanhaDTO;
import br.com.projeto.ecommerce.model.Campanha;

public class CampanhaMock implements Mock<CampanhaDTO, Campanha> {

	@Override
	public CampanhaDTO getDTO() {
		CampanhaDTO dto = new CampanhaDTO();
		dto.setId(787L);
		dto.setDataVigencia(Instant.now());
		dto.setIdTimeCoracao(14L);
		dto.setNomeCampanha("Umbro, VAMOS JUNTOS");
		dto.setTime(new TimeMock().getDTO());

		return dto;
	}

	@Override
	public Campanha getEntity() {
		Campanha entity = new Campanha();
		entity.setId(14L);
		entity.setDataVigencia(Instant.now());
		entity.setIdTimeCoracao(17L);
		entity.setNomeCampanha("Nike Joga 10");

		return entity;
	}

	@Override
	public List<CampanhaDTO> getListDTO() {
		return Arrays.asList(getDTO());
	}

	@Override
	public List<Campanha> getListEntity() {
		return Arrays.asList(getEntity());
	}

}
