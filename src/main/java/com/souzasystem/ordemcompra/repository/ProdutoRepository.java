package com.souzasystem.ordemcompra.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.souzasystem.ordemcompra.model.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

}
