package br.com.projeto.ecommerce.dto;

import java.io.Serializable;
import java.time.Instant;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class SocioTorcedorDTO implements Serializable {

	private static final long serialVersionUID = 2571886442743346019L;

	private Long id;

	private String nome;

	private String email;

	private Instant dataNascimento;

	private String timeFavorito;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTimeFavorito() {
		return timeFavorito;
	}

	public void setTimeFavorito(String timeFavorito) {
		this.timeFavorito = timeFavorito;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
