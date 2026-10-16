package com.salesianos.dam.primerjemplo.service;

import com.salesianos.dam.primerjemplo.dto.EditCategoryDto;
import com.salesianos.dam.primerjemplo.error.CategoryNotFoundException;
import com.salesianos.dam.primerjemplo.error.InvalidCategoryException;
import com.salesianos.dam.primerjemplo.model.Category;
import com.salesianos.dam.primerjemplo.repo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> result = categoryRepository.findAll();
        if (result.isEmpty()) {
            throw new CategoryNotFoundException("No categories found");
        }
        return result;
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("No category found with ID: " + id));    }

    private void validateCategory(EditCategoryDto editCategoryDto) {
        if (!StringUtils.hasText(editCategoryDto.name())) {
            throw new InvalidCategoryException("Category name is required");
        }
    }

    public Category addCategory(EditCategoryDto editCategoryDto) {
        validateCategory(editCategoryDto);
        return categoryRepository.save(editCategoryDto.to());
    }
}