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

import com.souzasystem.ordemcompra.model.Representante;
import com.souzasystem.ordemcompra.repository.RepresentanteRepository;

@Controller
public class RepresentanteController {

	@Autowired
	private RepresentanteRepository repository;

	@RequestMapping(method=RequestMethod.POST, value="/representante")
	@ResponseBody
	public Representante salvar(@Valid @RequestBody Representante representante) {
		return repository.save(representante);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/representante/deletar")
	@ResponseBody
	public void deletar(@RequestBody Representante representante) {
		repository.delete(representante.getId());
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/representante")
	@ResponseBody
	public List<Representante> listar(){
		Iterator<Representante> it = repository.findAll().iterator();
		List<Representante> representante = new ArrayList<Representante>();
		while(it.hasNext()) {
			representante.add(it.next());
		}
		return representante;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/representante/{id}")
	@ResponseBody
	public Representante pegar(@PathVariable String id){
		return repository.findOne(Long.valueOf(id));
	}
}
