package com.souzasystem.ordemcompra.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.souzasystem.ordemcompra.model.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {
	
	@Query("select p from #{#entityName} p where UPPER(codigo) like %:busca% or UPPER(nome) like %:busca% or UPPER(descricao) like %:busca% ")
	List<Produto> findBusca(@Param("busca") String busca, Sort sort);
}
