package br.com.projeto.ecommerce.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidarEmailTests {

	@BeforeEach
	void beforeEach() {
		ValidarEmail validar = new ValidarEmail();
		validar.toString();
	}

	@Test
	void emailValido() {
		assertTrue(ValidarEmail.isEmailValido("bancobv@bv.com.br"));
	}

	@Test
	void emailInvalido() {
		assertFalse(ValidarEmail.isEmailValido("bancobv.com.br"));
	}

	@Test
	void emailInvalidoNull() {
		assertFalse(ValidarEmail.isEmailValido(null));
	}

	@Test
	void emailInvalidoVazio() {
		assertFalse(ValidarEmail.isEmailValido(""));
	}

}
