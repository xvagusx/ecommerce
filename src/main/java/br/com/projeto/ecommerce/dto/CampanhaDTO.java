package br.com.projeto.ecommerce.dto;

import java.io.Serializable;
import java.time.Instant;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CampanhaDTO implements Serializable {

	private static final long serialVersionUID = 8586576286470736191L;

	private Long id;

	private String nomeCampanha;

	private Long idTimeCoracao;

	private TimeDTO time;

	private Instant dataVigencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCampanha() {
		return nomeCampanha;
	}

	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	public Long getIdTimeCoracao() {
		return idTimeCoracao;
	}

	public void setIdTimeCoracao(Long idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}

	public Instant getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Instant dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public TimeDTO getTime() {
		return time;
	}

	public void setTime(TimeDTO time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
