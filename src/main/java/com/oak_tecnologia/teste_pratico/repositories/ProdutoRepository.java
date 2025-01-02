package com.oak_tecnologia.teste_pratico.repositories;

import com.oak_tecnologia.teste_pratico.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
