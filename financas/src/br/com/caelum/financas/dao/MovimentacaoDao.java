package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.TipoMovimentacao;

public class MovimentacaoDao {
	private EntityManager manager;

	  public MovimentacaoDao(EntityManager manager) {
	    this.manager = manager;
	  }
	  
	  public Double averageOfAccount(Conta account, TipoMovimentacao typeOperation){
		  TypedQuery<Double> query =manager 
				  .createQuery("select avg(m.valor) from Movimentacao m where m.conta =:pAccount "
						  + " and m.tipoMovimentacao = :pType",Double.class);
		  query.setParameter("pAccount", account).setParameter("pType", typeOperation);
		  return query.getSingleResult();  
	  }
	  public Long getResultOperationsAll(Conta account) {
		    TypedQuery<Long> query = manager.createNamedQuery("totalDeMovimentacoes", Long.class);
		    query.setParameter("pConta", account);
		    return query.getSingleResult();
	  }
}
