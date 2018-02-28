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

import com.souzasystem.ordemcompra.model.Local;
import com.souzasystem.ordemcompra.repository.LocalRepository;

@Controller
public class LocalController {

	@Autowired
	private LocalRepository repository;

	@RequestMapping(method=RequestMethod.POST, value="/local")
	@ResponseBody
	public Local salvar(@Valid @RequestBody Local local) {
		return repository.save(local);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/local/deletar")
	@ResponseBody
	public void deletar(@RequestBody Local local) {
		repository.delete(local.getId());
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/local")
	@ResponseBody
	public List<Local> listar(){
		Iterator<Local> it = repository.findAll().iterator();
		List<Local> local = new ArrayList<Local>();
		while(it.hasNext()) {
			local.add(it.next());
		}
		return local;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/local/{id}")
	@ResponseBody
	public Local pegar(@PathVariable String id){
		return repository.findOne(Long.valueOf(id));
	}
}
