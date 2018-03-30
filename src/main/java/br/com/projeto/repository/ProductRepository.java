package br.com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.ProductOrder;

public interface ProductRepository extends JpaRepository<ProductOrder, Integer>{

}
