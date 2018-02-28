package com.souzasystem.ordemcompra.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class OrdemCompra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String codigo;
	
	@NotEmpty
	@OneToOne
	private Fornecedor fornecedor;
	
	@NotEmpty
	@OneToOne
	private Representante  representante;
	
	@NotNull
	private Date datacadastro;
	
	private Date dataaprovacao;

	@NotEmpty
	private String status;
	
	@NotNull
	private Double frete;
	
	@NotNull
	private Double valortotal;
	
	@NotNull
	private Double valorproduto;
	
	private Double desconto;
	
	private Double imposto;
	
	private Double outrosvalores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Date getDataaprovacao() {
		return dataaprovacao;
	}

	public void setDataaprovacao(Date dataaprovacao) {
		this.dataaprovacao = dataaprovacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}

	public Double getValortotal() {
		return valortotal;
	}

	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}

	public Double getValorproduto() {
		return valorproduto;
	}

	public void setValorproduto(Double valorproduto) {
		this.valorproduto = valorproduto;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}

	public Double getOutrosvalores() {
		return outrosvalores;
	}

	public void setOutrosvalores(Double outrosvalores) {
		this.outrosvalores = outrosvalores;
	}
	
}