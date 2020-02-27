package br.com.projeto.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.dto.SocioTorcedorDTO;
import br.com.projeto.ecommerce.model.SocioTorcedor;
import br.com.projeto.ecommerce.repository.SocioTorcedorRepository;
import br.com.projeto.ecommerce.service.mapper.SocioTorcedorMapper;
import br.com.projeto.ecommerce.util.ValidarEmail;

@Service
public class SocioTorcedorService {

	@Autowired
	private SocioTorcedorRepository repository;

	private SocioTorcedorMapper mapper = new SocioTorcedorMapper();

	/**
	 * Metodo utilizado pra incluir socio torcedor
	 *
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public SocioTorcedorDTO incluir(SocioTorcedorDTO dto) throws Exception {
		validarSocioTorcedor(dto);

		SocioTorcedor novoSocioTorcedor = repository.save(mapper.toEntity(dto));
		return mapper.toDto(novoSocioTorcedor);
	}

	/**
	 * Metodo utlizado para validar socio torcedor
	 *
	 * @param dto
	 * @throws Exception
	 */
	public void validarSocioTorcedor(SocioTorcedorDTO dto) throws Exception {

		if (dto == null) {
			error("Erro de Validacao, Socio torcedor incorreto!");
		} else {
			validarEmail(dto.getEmail());
		}
	}

	/**
	 * Metodo utilizado para validar email
	 *
	 * @param email
	 * @throws Exception
	 */
	private void validarEmail(String email) throws Exception {

		if (email == null || email.isEmpty()) {
			error("Erro de Validacao, email não informado.");
		} else if (!ValidarEmail.isEmailValido(email)) {
			error("Erro de Validacao, email incorreto.");
		} else if (!repository.findByEmail(email).isEmpty()) {
			error("Erro de Validacao, email já cadastrado");
		}
	}

	/**
	 * Metodo utilizado para gerar error na aplicação recebendo a msg esperada
	 *
	 * @param messagem
	 * @throws Exception
	 */
	private void error(String messagem) throws Exception {
		throw new Exception(messagem);
	}
}
