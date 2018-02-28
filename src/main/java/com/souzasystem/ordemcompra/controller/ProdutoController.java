package com.souzasystem.ordemcompra.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.souzasystem.ordemcompra.model.Produto;
import com.souzasystem.ordemcompra.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;

	@RequestMapping(method=RequestMethod.POST, value="/produto")
	@ResponseBody
	public Produto salvar(@Valid @RequestBody Produto produto) {
		return repository.save(produto);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/produto/deletar")
	@ResponseBody
	public void deletar(@RequestBody Produto produto) {
		repository.delete(produto.getId());
	}
	
	@RequestMapping(method=RequestMethod.GET, value="produto")
	public ModelAndView listar(){
		ModelAndView model = new ModelAndView("produto/produto");
		
		Sort ordem = new Sort(Sort.Direction.ASC,"codigo");
		Iterator<Produto> it = repository.findAll(ordem).iterator();
		List<Produto> produtos = new ArrayList<Produto>();
		while(it.hasNext()) {
			produtos.add(it.next());
		}
		model.addObject("produtos", produtos);
		
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/produto/{id}")
	@ResponseBody
	public Produto pegar(@PathVariable String id){
		return repository.findOne(Long.valueOf(id));
	}
	
}