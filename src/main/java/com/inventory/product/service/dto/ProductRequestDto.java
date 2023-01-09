package com.inventory.product.service.dto;


import com.inventory.product.service.enums.Status;
import com.inventory.product.service.enums.Unit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequestDto {
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String description;
    @NotNull
    private Status status;
    @NotNull
    private Unit unit;
    @NotNull
    private String category;
    private List<String> suppliers;
}
