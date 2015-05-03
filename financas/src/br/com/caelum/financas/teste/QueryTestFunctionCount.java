package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class QueryTestFunctionCount {

	public static void main(String[] args) {
		EntityManager manager  = new JPAUtil().getEntityManager();
		
		Conta account = manager.find(Conta.class,3);
		
		TypedQuery<Long> typedQuery = manager.createQuery("select count(m.valor) from Movimentacao m where m.conta = :pAccount",Long.class);
		typedQuery.setParameter("pAccount", account);
		
		Long value = typedQuery.getSingleResult();
		System.out.println("All Result of trasactions: " +  value);
	}
}
