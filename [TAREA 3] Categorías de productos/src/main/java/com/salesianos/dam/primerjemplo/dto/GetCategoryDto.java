package com.salesianos.dam.primerjemplo.dto;

import com.salesianos.dam.primerjemplo.model.Category;

public record GetCategoryDto(
        Long id,
        String nombre
) {
    public static GetCategoryDto of (Category category){
        return new GetCategoryDto(category.getId(), category.getName());
    }
}
