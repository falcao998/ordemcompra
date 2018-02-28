package com.souzasystem.ordemcompra.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.souzasystem.ordemcompra.model.OrdemCompraProduto;
import com.souzasystem.ordemcompra.repository.OrdemCompraProdutoRepository;

@Controller
public class OrdemCompraProdutoController {

	@Autowired
	private OrdemCompraProdutoRepository repository;

	@RequestMapping(method=RequestMethod.POST, value="/ordercompraproduto")
	@ResponseBody
	public OrdemCompraProduto salvar(@Valid @RequestBody OrdemCompraProduto ordemCompraProduto) {
		return repository.save(ordemCompraProduto);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/ordemcompraproduto/deletar")
	@ResponseBody
	public void deletar(@RequestBody OrdemCompraProduto ordemCompraProduto) {
		repository.delete(ordemCompraProduto.getId());
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/ordemcompraproduto")
	@ResponseBody
	public List<OrdemCompraProduto> listar(){
		Iterator<OrdemCompraProduto> it = repository.findAll().iterator();
		List<OrdemCompraProduto> ordemCompraProduto = new ArrayList<OrdemCompraProduto>();
		while(it.hasNext()) {
			ordemCompraProduto.add(it.next());
		}
		return ordemCompraProduto;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/ordemcompraproduto/{id}")
	@ResponseBody
	public OrdemCompraProduto pegar(@PathVariable String id){
		return repository.findOne(Long.valueOf(id));
	}
}