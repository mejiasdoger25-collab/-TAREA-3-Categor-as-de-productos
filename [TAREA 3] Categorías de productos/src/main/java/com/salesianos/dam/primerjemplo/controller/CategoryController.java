package com.salesianos.dam.primerjemplo.controller;

import com.salesianos.dam.primerjemplo.model.Category;
import com.salesianos.dam.primerjemplo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAll());
    }


    @GetMapping("/{id}")
    public Category getCategoryById (@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Category> create (@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
    }

    @PutMapping("/{id}")
    public Category edit(@RequestBody Category category, @PathVariable Long id){
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
