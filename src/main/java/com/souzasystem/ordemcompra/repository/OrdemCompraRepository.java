package com.souzasystem.ordemcompra.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.souzasystem.ordemcompra.model.OrdemCompra;

public interface OrdemCompraRepository extends PagingAndSortingRepository<OrdemCompra, Long> {

}
