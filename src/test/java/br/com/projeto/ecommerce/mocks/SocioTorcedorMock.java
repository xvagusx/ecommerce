package br.com.projeto.ecommerce.mocks;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import br.com.projeto.ecommerce.dto.SocioTorcedorDTO;
import br.com.projeto.ecommerce.model.SocioTorcedor;

public class SocioTorcedorMock implements Mock<SocioTorcedorDTO, SocioTorcedor> {

	@Override
	public SocioTorcedorDTO getDTO() {
		SocioTorcedorDTO dto = new SocioTorcedorDTO();
		dto.setId(20L);
		dto.setDataNascimento(Instant.now());
		dto.setEmail("test@resourceit.com");
		dto.setNome("Gabriel Silva Madeira");
		dto.setTimeFavorito("Fluminense");

		return dto;
	}

	@Override
	public SocioTorcedor getEntity() {
		SocioTorcedor entity = new SocioTorcedor();
		entity.setId(15L);
		entity.setDataNascimento(Instant.now());
		entity.setEmail("redbull@bv.com");
		entity.setNome("Neymar Santos");
		entity.setTimeFavorito("Santos");
		return entity;
	}

	@Override
	public List<SocioTorcedorDTO> getListDTO() {
		return Arrays.asList(getDTO());
	}

	@Override
	public List<SocioTorcedor> getListEntity() {
		return Arrays.asList(getEntity());
	}
}
