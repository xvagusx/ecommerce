package br.com.projeto.ecommerce.mocks;

import java.util.Arrays;
import java.util.List;

import br.com.projeto.ecommerce.dto.TimeDTO;
import br.com.projeto.ecommerce.model.Time;

public class TimeMock implements Mock<TimeDTO, Time> {

	@Override
	public TimeDTO getDTO() {
		TimeDTO dto = new TimeDTO();
		dto.setId(16L);
		dto.setNome("Palmeiras");
		dto.setEstado("SP");

		return dto;
	}

	@Override
	public Time getEntity() {
		Time entity = new Time();
		entity.setId(20L);
		entity.setNome("Vasco");
		entity.setEstado("RJ");

		return entity;
	}

	@Override
	public List<TimeDTO> getListDTO() {
		return Arrays.asList(getDTO());
	}

	@Override
	public List<Time> getListEntity() {
		return Arrays.asList(getEntity());
	}

}
