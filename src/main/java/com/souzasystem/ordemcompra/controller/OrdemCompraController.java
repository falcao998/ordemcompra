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

import com.souzasystem.ordemcompra.model.OrdemCompra;
import com.souzasystem.ordemcompra.repository.OrdemCompraRepository;

@Controller
public class OrdemCompraController {

	@Autowired
	private OrdemCompraRepository repository;

	@RequestMapping(method=RequestMethod.POST, value="/ordercompra")
	@ResponseBody
	public OrdemCompra salvar(@Valid @RequestBody OrdemCompra ordemCompra) {
		return repository.save(ordemCompra);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/ordemcompra/deletar")
	@ResponseBody
	public void deletar(@RequestBody OrdemCompra ordemCompra) {
		repository.delete(ordemCompra.getId());
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/ordemcompra")
	@ResponseBody
	public List<OrdemCompra> listar(){
		Iterator<OrdemCompra> it = repository.findAll().iterator();
		List<OrdemCompra> ordemCompra = new ArrayList<OrdemCompra>();
		while(it.hasNext()) {
			ordemCompra.add(it.next());
		}
		return ordemCompra;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/ordemcompra/{id}")
	@ResponseBody
	public OrdemCompra pegar(@PathVariable String id){
		return repository.findOne(Long.valueOf(id));
	}
}
