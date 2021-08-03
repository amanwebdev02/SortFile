package com.example.testing;

import com.example.testing.entities.response.*;
import com.example.testing.service.CartService;
import com.example.testing.service.CommisionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TestApplicationTests {
    @Autowired
    CartService cartService;
    @Autowired
    CommisionService commisionService;
	/*@Autowired
	FileSort fileSort;

	@Test
	void contextLoads() {
	}

	@Test()
	public void testForEmptyFile() {
		assertThrows(IllegalArgumentException.class, () -> fileSort.sort(AppConstant.TEST_INPUT_FILE_EMPTY));
	}

	@Test
	public void testForFileDoesNotExists() {
		assertThrows(FileNotFoundException.class, () -> fileSort.sort(AppConstant.TEST_INPUT_FILE_DOES_NOT_EXISTS));
	}

	@Test
    public void testForInvalidJsonData() {
        assertThrows(JsonParseException.class, () -> fileSort.sort(AppConstant.TEST_INPUT_FILE_INVALID));
    }*/

	@Test
    public void testCase1(){
	    Customer customer = new Customer("John", "h@makil.com");
        Cart cart = new Cart("cart1", customer);
        Seller seller =  new Seller("Amazon", "id1");
        Seller seller2 =  new Seller("Uber", "id2");

        Product product = new Product(seller, ProductType.GIFTCARD, 100);
        cartService.addProductToCart(cart, product, 5);

         Commision commision = new Commision(seller,UNITS.PERCENTAGE, 10);
        commisionService.addCommision(commision,seller);
        /*Commision commision2 = new Commision(seller2,UNITS.PERCENTAGE, 10);
          commisionService.addCommision(commision2,seller2);*/
	    cartService.calculateCartVal(cart);
    }

}
