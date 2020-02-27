package br.com.projeto.ecommerce.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.projeto.ecommerce.dto.CampanhaDTO;
import br.com.projeto.ecommerce.model.Campanha;

public class CampanhaMapper implements EntityMapper<CampanhaDTO, Campanha> {

	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public Campanha toEntity(CampanhaDTO dto) {
		return modelMapper.map(dto, Campanha.class);
	}

	@Override
	public CampanhaDTO toDto(Campanha entity) {
		return modelMapper.map(entity, CampanhaDTO.class);
	}

	@Override
	public List<Campanha> toEntity(List<CampanhaDTO> dtoList) {
		List<Campanha> listEntity = new ArrayList<Campanha>();
		for (CampanhaDTO dto : dtoList) {
			listEntity.add(toEntity(dto));
		}
		return listEntity;
	}

	@Override
	public List<CampanhaDTO> toDto(List<Campanha> entityList) {
		List<CampanhaDTO> listDto = new ArrayList<CampanhaDTO>();
		for (Campanha entity : entityList) {
			listDto.add(toDto(entity));
		}
		return listDto;
	}

}
