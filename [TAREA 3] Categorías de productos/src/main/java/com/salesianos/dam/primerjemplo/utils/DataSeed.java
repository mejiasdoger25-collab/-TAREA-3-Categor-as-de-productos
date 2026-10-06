package com.salesianos.dam.primerjemplo.utils;

import com.salesianos.dam.primerjemplo.model.Category;
import com.salesianos.dam.primerjemplo.model.Product;
import com.salesianos.dam.primerjemplo.repo.CategoryRepository;
import com.salesianos.dam.primerjemplo.repo.ProductRepository;
import com.salesianos.dam.primerjemplo.service.CategoryService;
import com.salesianos.dam.primerjemplo.service.ProductService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @PostConstruct
    public void initData() {

        /*
            Invocar a los servicios para insertar
            datos de ejemplo
         */


        Category c = categoryRepository.getReferenceById(1L);
        //Category c = null;
        Optional<Category> optionalCategoria = categoryRepository.findById(1L);

        if (optionalCategoria.isPresent()) {
            c = optionalCategoria.get();
        }

        Product p = Product.builder()
                .name("Un producto")
                .details("U producto de nuestro catálogo")
                .price(123.45)
                .category(c)
                .build();

        //c.addCategory(p);
        categoryService.addCategory(p.getCategory());

        //productRepository.save(p);
        productRepository.save(p);

        System.out.println("Productos de la categoria C1");
        //System.out.println(c.getProductos());
        System.out.println(categoryService.getAll());

        Product p2 = Product.builder()
                .name("Otro producto")
                .details("Este debe tener ID 3")
                .price(234.56)
                .category(c)
                .build();

        productRepository.saveAll(List.of(p, p2));


        productRepository.findAll()
                .forEach(System.out::println);

    }

}
