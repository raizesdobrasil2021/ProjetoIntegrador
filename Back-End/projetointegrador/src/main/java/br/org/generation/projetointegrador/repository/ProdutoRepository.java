package br.org.generation.projetointegrador.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.projetointegrador.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto>findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Produto>findByPrecoLessThanEqual(BigDecimal preco);
	
	public List<Produto>findByPrecoBetween(BigDecimal preco1, BigDecimal preco2);
	
	
}
