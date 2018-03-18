package com.souzasystem.ordemcompra.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.souzasystem.ordemcompra.model.Produto;
import com.souzasystem.ordemcompra.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	private String urlListIndex = "produto/index";
	private String urlProduto = "produto/produto";
	
//	Metodo pegar tem que ser refatorado para exibir a tela de EDIÇÃO
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ModelAndView pegar(@PathVariable String id){
		
		ModelAndView model = new ModelAndView(urlListIndex);
		
		model.addObject("produtos", repository.findOne(Long.valueOf(id)));
		
		return model;
	}
//-----------------------------------------------------------------------------------------
	
	@RequestMapping(method=RequestMethod.POST)
	public RedirectView salvar(@Valid Produto produto) {
		
		repository.save(produto);
		
		return new RedirectView("/produto");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="form")
	public ModelAndView form(@RequestParam("idProduto") String idProduto) {
		
		ModelAndView model = new ModelAndView(urlProduto);
		
		if (idProduto.isEmpty()) {
			model.addObject("produto", new Produto());
		} else {
			model.addObject("produto", repository.findOne(Long.valueOf(idProduto)));
		}
		
		return model;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/deletar")
	public String deletar(@RequestParam("idProduto") String idProduto) {
		
		repository.delete(Long.parseLong(idProduto));
		
		return urlListIndex;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		
		ModelAndView model = new ModelAndView(urlListIndex);
		
		Sort ordem = new Sort(Sort.Direction.ASC,"codigo");
		Iterator<Produto> it = repository.findAll(ordem).iterator();
		List<Produto> produtos = new ArrayList<>();
		while(it.hasNext()) {
			produtos.add(it.next());
		}
		model.addObject("produtos", produtos);
		
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/busca")
	public ModelAndView buscar(@RequestParam("busca") String busca){
		
		ModelAndView model = new ModelAndView(urlListIndex);
		
		Sort ordem = new Sort(Sort.Direction.ASC,"codigo");
		Iterator<Produto> it = repository.findBusca(busca.toUpperCase(), ordem).iterator();
		List<Produto> produtos = new ArrayList<>();
		while(it.hasNext()) {
			produtos.add(it.next());
		}
		model.addObject("produtos", produtos);
		
		return model;
	}
	
}