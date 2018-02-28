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

import com.souzasystem.ordemcompra.model.Fornecedor;
import com.souzasystem.ordemcompra.repository.FornecedorRepository;

@Controller
public class FornecedorController {

	@Autowired
	private FornecedorRepository repository;

	@RequestMapping(method=RequestMethod.POST, value="/fornecedor")
	@ResponseBody
	public Fornecedor salvar(@Valid @RequestBody Fornecedor fornecedor) {
		return repository.save(fornecedor);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/fornecedor/deletar")
	@ResponseBody
	public void deletar(@RequestBody Fornecedor fornecedor) {
		repository.delete(fornecedor.getId());
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/fornecedor")
	@ResponseBody
	public List<Fornecedor> listar(){
		Iterator<Fornecedor> it = repository.findAll().iterator();
		List<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
		while(it.hasNext()) {
			fornecedor.add(it.next());
		}
		return fornecedor;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/fornecedor/{id}")
	@ResponseBody
	public Fornecedor pegar(@PathVariable String id){
		return repository.findOne(Long.valueOf(id));
	}
}
