package br.com.projeto.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projeto.Application;
import br.com.projeto.model.ProductOrder;
import br.com.projeto.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductOrderServiceTest {

	private final String DESCRIPTION_1 = "gohan super sayajin 1";
	private final Double VALUE_1 = 50.0;
	private final Integer QUANTITY_1 = 3;
	private final Double SHIPPING_VALUE_1 = 10.0;
	
	private final String DESCRIPTION_2 = "gohan super sayajin 2";
	private final Double VALUE_2 = 150.0;
	private final Integer QUANTITY_2 = 4;
	private final Double SHIPPING_VALUE_2 = 20.0;
	
	private final String DESCRIPTION_3 = "gohan super sayajin 3";
	private final Double VALUE_3 = 250.0;
	private final Integer QUANTITY_3 = 5;
	private final Double SHIPPING_VALUE_3 = 30.0;

	private ProductOrder _productOrder_1 = new ProductOrder(DESCRIPTION_1, VALUE_1, QUANTITY_1, SHIPPING_VALUE_1);
	private ProductOrder _productOrder_2 = new ProductOrder(DESCRIPTION_2, VALUE_2, QUANTITY_2, SHIPPING_VALUE_2);
	private ProductOrder _productOrder_3 = new ProductOrder(DESCRIPTION_3, VALUE_3, QUANTITY_3, SHIPPING_VALUE_3);

	@Autowired
	private ProductRepository prdRepository;

	// @Before
	// public void setup() {
	// _productOrder_1 = new ProductOrder(DESCRIPTION_1, VALUE_1, QUANTITY_1,
	// SHIPPING_VALUE_1);
	// _productOrder_2 = new ProductOrder(DESCRIPTION_2, VALUE_2, QUANTITY_2,
	// SHIPPING_VALUE_2);
	// _productOrder_3 = new ProductOrder(DESCRIPTION_3, VALUE_3, QUANTITY_3,
	// SHIPPING_VALUE_3);
	// }

	@Test
	public void testSaveProduct() {
		ProductOrder prd = prdRepository.save(_productOrder_1);
		
		assertEquals(prd.getDescription(),DESCRIPTION_1);
		assertEquals(prd.getValueOrder(), VALUE_1);
		assertEquals(prd.getQuantity(), QUANTITY_1);
		assertEquals(prd.getShippingCost(), SHIPPING_VALUE_1);
		
		assertNotNull(prd.getCreatedAt());
		assertNotNull(prd.getUpdatedAt());
	}
	
	@Test
	public void testFindAllProduct() {
		
		prdRepository.save(_productOrder_1);
		prdRepository.save(_productOrder_2);
		prdRepository.save(_productOrder_3);
		
		List<ProductOrder> products = new ArrayList<>();
		products.add(_productOrder_1);
		products.add(_productOrder_2);
		products.add(_productOrder_3);
		
		List<ProductOrder> returnedProducts = prdRepository.findAll();
		
		assertEquals(returnedProducts.size(), 3);
	}

}
