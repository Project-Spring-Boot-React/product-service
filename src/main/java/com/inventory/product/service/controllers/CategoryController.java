package com.inventory.product.service.controllers;


import com.inventory.product.service.dto.CategoryRequestDto;
import com.inventory.product.service.dto.CategoryResponseDTO;
import com.inventory.product.service.services.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@Slf4j
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    public ResponseEntity<CategoryResponseDTO> save(@Valid @RequestBody CategoryRequestDto requestDTO){
        log.info("controller category : start");
        return new ResponseEntity<>(categoryService.addCategory(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> edit(@Valid @RequestBody CategoryRequestDto requestDTO, @PathVariable UUID id){
        CategoryResponseDTO categoryResponseDTO = categoryService.editCategory(id, requestDTO);

        if (categoryResponseDTO != null) {
            return new ResponseEntity<>(categoryResponseDTO, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        boolean check =  categoryService.deleteCategory(id);
        if(check){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> get(@PathVariable UUID id){
        CategoryResponseDTO categoryResponseDTO = categoryService.getCategory(id);

        if (categoryResponseDTO == null) {
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
    }

    @GetMapping()
    public List<CategoryResponseDTO> all () {
        return categoryService.getCategories();
    }
}
