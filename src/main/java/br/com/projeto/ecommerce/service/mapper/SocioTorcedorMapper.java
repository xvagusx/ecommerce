package br.com.projeto.ecommerce.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.projeto.ecommerce.dto.SocioTorcedorDTO;
import br.com.projeto.ecommerce.model.SocioTorcedor;

public class SocioTorcedorMapper implements EntityMapper<SocioTorcedorDTO, SocioTorcedor> {

	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public SocioTorcedor toEntity(SocioTorcedorDTO dto) {
		return modelMapper.map(dto, SocioTorcedor.class);
	}

	@Override
	public SocioTorcedorDTO toDto(SocioTorcedor entity) {
		return modelMapper.map(entity, SocioTorcedorDTO.class);
	}

	@Override
	public List<SocioTorcedor> toEntity(List<SocioTorcedorDTO> dtoList) {
		List<SocioTorcedor> listEntity = new ArrayList<SocioTorcedor>();
		for (SocioTorcedorDTO dto : dtoList) {
			listEntity.add(toEntity(dto));
		}
		return listEntity;
	}

	@Override
	public List<SocioTorcedorDTO> toDto(List<SocioTorcedor> entityList) {
		List<SocioTorcedorDTO> listDto = new ArrayList<SocioTorcedorDTO>();
		for (SocioTorcedor entity : entityList) {
			listDto.add(toDto(entity));
		}
		return listDto;
	}

}
