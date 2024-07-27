package com.ecommerce.productservices.Controller;

import com.ecommerce.productservices.DTO_s.GetProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TypeErasureExample {
    public static void main(String[] args) {
        // Create generic and non-generic List instances
        List<Integer> integerList = new ArrayList<>();
        List<GetProductDto> productList = new ArrayList<>();
        int[] primitiveArray = new int[]{1, 2, 3};
        

        // Print class names to demonstrate type erasure
        System.out.println("Integer List class: " + integerList.getClass().getName());  // Output: java.util.ArrayList
        System.out.println("GetProductDto List class: " + productList.getClass().getName());  // Output: java.util.ArrayList
        System.out.println("Primitive int array class: " + primitiveArray.getClass().getName());  // Output: [I (int[])

        // Explanation of type erasure
        // Generics in Java provide compile-time type safety while maintaining runtime efficiency.
        // The compiler performs type erasure during compilation, which removes the generic type information
        // from the bytecode. This means that at runtime, both `integerList` and `productList` are treated as
        // instances of the same class, `java.util.ArrayList`.

        // However, the type information is still used by the compiler to enforce type safety during
        // compilation. For example, you can only add elements of type `Integer` to `integerList` and elements
        // of type `GetProductDto` to `productList`. The compiler will prevent attempts to add incompatible types.

        // Primitive arrays like `primitiveArray` are not erased, and their type information is maintained
        // at runtime. This allows for more efficient operations on primitive data types.
        Optional<String> e = Optional.empty();
        System.out.println(e);
    }
}
