package com.souzasystem.ordemcompra.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.souzasystem.ordemcompra.model.OrdemCompraProduto;

public interface OrdemCompraProdutoRepository extends PagingAndSortingRepository<OrdemCompraProduto, Long> {
	
	List<OrdemCompraProduto> findIdByOrdemCompra(Long id);
}
