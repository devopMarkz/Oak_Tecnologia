package com.oak_tecnologia.teste_pratico.services;

import com.oak_tecnologia.teste_pratico.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;



}
