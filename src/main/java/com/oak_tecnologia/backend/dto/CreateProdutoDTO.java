package com.oak_tecnologia.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class CreateProdutoDTO {

    @NotBlank(message = "Nome não pode estar vazio.")
    private String nome;

    @NotBlank(message = "Descrição não pode estar vazia.")
    private String descricao;

    @Positive(message = "Valor não pode ser negativo.")
    private Double valor;

    private String disponivel;

    public CreateProdutoDTO(String nome, String descricao, Double valor, String disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public @NotBlank(message = "Nome não pode estar vazio.") String getNome() {
        return nome;
    }

    public @NotBlank(message = "Descrição não pode estar vazia.") String getDescricao() {
        return descricao;
    }

    public @Positive(message = "Valor não pode ser negativo.") Double getValor() {
        return valor;
    }

    public String getDisponivel() {
        return disponivel;
    }
}
