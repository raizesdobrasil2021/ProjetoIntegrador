package br.org.generation.projetointegrador.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Este atributo nome é obrigatorio!")
	@Size(max = 100)
	private String nome;
	
	@ApiModelProperty(example = "email@email.com.br")
	@NotNull(message = "Este atributo usuario é obrigatório!")
	@Email
	private String usuario;
	
	@NotNull(message = "Este atributo senha é obrigatório!")
	@Size(min = 8)
	private String senha;
	
	@NotNull(message = "Este atributo tipo é obrigatório!")
	private String tipo;
	
	@Column(name = "dt_nascimento")
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "usuario" , cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List <Produto> produto;
	
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setEmail(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

}