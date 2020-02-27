package br.com.projeto.ecommerce.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "SOCIOTORCEDOR")
public class SocioTorcedor {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DATA_NASCIMENTO")
	private Instant dataNascimento;

	@Column(name = "TIME_FAVORITO")
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

}
