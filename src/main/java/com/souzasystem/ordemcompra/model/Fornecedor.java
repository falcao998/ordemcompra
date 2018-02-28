package com.souzasystem.ordemcompra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(max=15, min=15)
	private String codigo;
	
	@NotEmpty
//	@Size(max=150, min=4)
	private String nome;
	
	@NotEmpty
//	@Size(max=20, min=14)
	private String telefonefinanceiro;
	
	@NotEmpty
//	@Size(max=20, min=14)
	private String telefone;
	
	@NotEmpty
//	@Size(max=150, min=11)
	private String email;
	
	private String email2;
	
	private String email3;
	
	@NotNull
	@OneToOne
	private Local local;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefonefinanceiro() {
		return telefonefinanceiro;
	}

	public void setTelefonefinanceiro(String telefonefinanceiro) {
		this.telefonefinanceiro = telefonefinanceiro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
}