package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class QueryTestFunctionMax {
	public static void main(final String Args[]) {
//Using TypedQuery		
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta account = manager.find(Conta.class,4);
		TypedQuery<BigDecimal> query = manager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pAccount",BigDecimal.class);
		query.setParameter("pAccount", account);
		
		BigDecimal value = query.getSingleResult();
		System.out.println("Max Value is "+value);
		manager.close();
	}
}
