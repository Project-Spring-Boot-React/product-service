package com.inventory.product.service.dto;


import com.inventory.product.service.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SupplierRequestDto {
    @NotNull
    @NotBlank
    private String name;
    private String raison;
    @NotNull
    private Status status;
}
