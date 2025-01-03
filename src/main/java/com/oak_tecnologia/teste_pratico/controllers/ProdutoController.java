package com.oak_tecnologia.teste_pratico.controllers;

import com.oak_tecnologia.teste_pratico.dto.CreateProdutoDTO;
import com.oak_tecnologia.teste_pratico.dto.ProdutoDTO;
import com.oak_tecnologia.teste_pratico.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos produtos.
 * Fornece endpoints para criação e listagem de produtos.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    /**
     * Endpoint para criar um novo produto.
     *
     * @param createProdutoDTO objeto contendo os dados necessários para criar um produto.
     * @return uma ResponseEntity contendo a lista de produtos atualizada e ordenada pelo valor.
     */
    @PostMapping
    public ResponseEntity<List<ProdutoDTO>> createProduto(@RequestBody CreateProdutoDTO createProdutoDTO){
        List<ProdutoDTO> produtos = produtoService.insert(createProdutoDTO);
        return ResponseEntity.ok(produtos);
    }

    /**
     * Endpoint para buscar todos os produtos.
     *
     * @return uma ResponseEntity contendo a lista de todos os produtos ordenados pelo valor.
     */
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAllProdutos(){
        List<ProdutoDTO> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

}