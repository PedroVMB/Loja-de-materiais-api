package com.api.lojamaterial.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDto {
    @NotBlank(message = "O nome do material é necessário")
    public String nome;
    @NotBlank(message = "O valor do material é necessário")
    public String valor;

    public String foto;
}
