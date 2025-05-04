//package com.ecommerce.productservices.Controller;
//
//import com.ecommerce.productservices.Service.GenericProductService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@SpringBootTest
//class ProductControllerTest {
//
//    @Autowired
//    private ProductController productController;
//
//    @MockBean
//    private GenericProductService productService;
//
//    @Test
//    void testAbsShouldReturnCorrectValue() {
//        int i = Math.abs(-2);
//        assertEquals(2, i);
//    }
//
//    @Test
//    public void testArrayIsSortedCorrectly() {
//        int[] l = {1, 2, 3, 6, 5};
//
//        Arrays.sort(l);
//        assertArrayEquals(new int[]{1, 2, 3, 5, 6}, l);
//    }
//}