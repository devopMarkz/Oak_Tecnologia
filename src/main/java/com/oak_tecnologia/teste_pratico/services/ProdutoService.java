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

/**
 * Classe de serviço responsável pelas operações relacionadas aos produtos.
 */
@Service
public class ProdutoService {

    /**
     * Repositório de acesso aos dados de Produto.
     */
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Insere um novo produto no banco de dados e retorna a lista de produtos ordenada pelo valor.
     *
     * @param createProdutoDTO Objeto contendo os dados do produto a ser criado.
     * @return Lista de produtos ordenada pelo valor, encapsulados em DTOs.
     */
    @Transactional
    public List<ProdutoDTO> insert(CreateProdutoDTO createProdutoDTO) {
        Produto produto = convertDtoToProduto(createProdutoDTO);
        Produto novoProduto = produtoRepository.save(produto);
        return produtoRepository.findAll()
                .stream()
                .sorted((o1, o2) -> o1.getValor().compareTo(o2.getValor()))
                .map(prod -> new ProdutoDTO(prod.getNome(), prod.getValor()))
                .toList();
    }

    /**
     * Recupera todos os produtos do banco de dados e os retorna ordenados pelo valor.
     *
     * @return Lista de produtos ordenada pelo valor, encapsulados em DTOs.
     */
    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll()
                .stream()
                .sorted((o1, o2) -> o1.getValor().compareTo(o2.getValor()))
                .map(prod -> new ProdutoDTO(prod.getNome(), prod.getValor()))
                .toList();
    }

    /**
     * Converte um objeto CreateProdutoDTO em uma entidade Produto.
     *
     * @param createProdutoDTO Objeto DTO contendo os dados do produto a ser convertido.
     * @return Objeto Produto preenchido com os dados do DTO.
     * @throws OpcaoInvalidaException Caso o valor do campo "disponivel" seja inválido.
     */
    private Produto convertDtoToProduto(CreateProdutoDTO createProdutoDTO) {
        Produto produto = new Produto();
        produto.setNome(createProdutoDTO.getNome());
        produto.setDescricao(createProdutoDTO.getDescricao());
        produto.setValor(createProdutoDTO.getValor());
        String disponivel = null;
        switch (createProdutoDTO.getDisponivel().toLowerCase()) {
            case "sim": {
                produto.setDisponivel(true);
                break;
            }
            case "nao", "não": {
                produto.setDisponivel(false);
                break;
            }
            default: {
                throw new OpcaoInvalidaException("Valores aceitos: SIM / NÂO.");
            }
        }
        return produto;
    }

}