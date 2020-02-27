package br.com.projeto.ecommerce.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class TimeDTO implements Serializable {

	private static final long serialVersionUID = 1309737101605351009L;

	private Long id;

	private String nome;

	private String estado;

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
