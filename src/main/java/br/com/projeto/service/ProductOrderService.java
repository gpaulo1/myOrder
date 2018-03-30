package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.model.ProductOrder;
import br.com.projeto.repository.ProductRepository;

@Service
public class ProductOrderService {

	@Autowired
	private ProductRepository _prodRepository;

	public ProductOrder saveProductOrder(ProductOrder product) {
		ProductOrder savedPrd = _prodRepository.save(product);
		return savedPrd;		
	}

}
