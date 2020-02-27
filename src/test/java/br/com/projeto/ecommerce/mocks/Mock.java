package br.com.projeto.ecommerce.mocks;

import java.util.List;

public interface Mock<D, E> {

	D getDTO();

	E getEntity();

	List<D> getListDTO();

	List<E> getListEntity();

}
