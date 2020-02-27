package br.com.projeto.ecommerce.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CAMPANHA")
public class Campanha {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOME_CAMPANHA")
	private String nomeCampanha;

	@Column(name = "ID_TIME_CORACAO")
	private Long idTimeCoracao;

	@Column(name = "DATA_VIGENCIA")
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

	public Instant getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Instant dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public Long getIdTimeCoracao() {
		return idTimeCoracao;
	}

	public void setIdTimeCoracao(Long idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}

}
