package com.ecommerce.productservices.Controller;

import com.ecommerce.productservices.Model_Entity.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    //FOR GET REQUEST USE BELOW IN POSTMAN
/*
http://localhost:8080/products/5/macbookair?category=laptops
 */
    @RequestMapping("/{id}/{name}")
    //@PathVariable extracts the required variable provided in the URI. We can use multiple Path Variables
    //@RequestParam - Similar to path variables, user input can be provided using @RequestParam annotation.
    public String getProductById(@PathVariable("id") Long id,
                                 @PathVariable("name") String name,
                                 @RequestParam("category") String category) {
        return "Here's your product " + id + " " + name + " " + category;
    }

//FOR POST REQUEST USE BELOW IN POSTMAN
/*

URL - http://localhost:8080/products/postproduct

REQUEST BODY BELOW - should contain a JSON representation of the product
{
        "id": 5,
        "name": "macbook",
        "description": "helps in coding smoothly",
        "price": 86000,
        "imageUrl": "https://www.mobigyaan.com/wp-content/uploads/2020/03/Apple-Macbook-Air-2020-1.jpg",
        "category": "laptop"
}
 */

    @PostMapping("/postproduct")
    // @RequestBody is used to deserialize the incoming payload/JSON to a Product Java object
    // @ResponseBody is used to serialize the returned Product Java object into JSON
    public @ResponseBody Product createProduct(@RequestBody Product product) {
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
        System.out.println(product.getImageUrl());
        System.out.println(product.getCategory());
        //return "Product created.";
        // Returning the created product
        return product;
    }
}


