package com.oak_tecnologia.backend.repositories;

import com.oak_tecnologia.backend.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
