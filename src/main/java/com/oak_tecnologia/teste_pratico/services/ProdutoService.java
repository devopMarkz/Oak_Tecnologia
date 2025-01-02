package com.oak_tecnologia.teste_pratico.services;

import com.oak_tecnologia.teste_pratico.dto.CreateProdutoDTO;
import com.oak_tecnologia.teste_pratico.dto.ProdutoDTO;
import com.oak_tecnologia.teste_pratico.entities.Produto;
import com.oak_tecnologia.teste_pratico.repositories.ProdutoRepository;
import com.oak_tecnologia.teste_pratico.services.exceptions.OpcaoInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public List<ProdutoDTO> insert(CreateProdutoDTO createProdutoDTO){
        Produto produto = convertDtoToProduto(createProdutoDTO);
        Produto novoProduto = produtoRepository.save(produto);
        return produtoRepository.findAll()
                .stream()
                .sorted((o1, o2) -> o1.getValor().compareTo(o2.getValor()))
                .map(prod -> new ProdutoDTO(prod.getNome(), prod.getValor()))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAll(){
        return produtoRepository.findAll()
                .stream()
                .sorted((o1, o2) -> o1.getValor().compareTo(o2.getValor()))
                .map(prod -> new ProdutoDTO(prod.getNome(), prod.getValor()))
                .toList();
    }

    private Produto convertDtoToProduto(CreateProdutoDTO createProdutoDTO){
        Produto produto = new Produto();
        produto.setNome(createProdutoDTO.getNome());
        produto.setDescricao(createProdutoDTO.getDescricao());
        produto.setValor(createProdutoDTO.getValor());
        String disponivel = null;
        switch (createProdutoDTO.getDisponivel().toLowerCase()){
            case "sim": {
                produto.setDisponivel(true);
                break;
            }
            case "nao", "não": {
                produto.setDisponivel(false);
                break;
            }
            default:{
                throw new OpcaoInvalidaException("Valores aceitos: SIM / NÂO.");
            }
        }
        return produto;
    }

}
