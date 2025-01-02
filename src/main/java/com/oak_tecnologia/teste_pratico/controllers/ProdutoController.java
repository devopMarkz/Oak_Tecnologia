package com.oak_tecnologia.teste_pratico.controllers;

import com.oak_tecnologia.teste_pratico.dto.CreateProdutoDTO;
import com.oak_tecnologia.teste_pratico.dto.ProdutoDTO;
import com.oak_tecnologia.teste_pratico.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<List<ProdutoDTO>> createProduto(@RequestBody CreateProdutoDTO createProdutoDTO){
        List<ProdutoDTO> produtos = produtoService.insert(createProdutoDTO);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAllProdutos(){
        List<ProdutoDTO> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

}
