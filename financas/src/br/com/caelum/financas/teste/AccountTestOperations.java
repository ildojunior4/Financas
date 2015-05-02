package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class AccountTestOperations {
	public static void main(String Args[]) {
		EntityManager manager = new JPAUtil().getEntityManager();
	/*	
		Movimentacao movimentacao = manager
				.find(Movimentacao.class, 2); //Id 2 have record in database
		System.out.println(movimentacao.getConta().getTitular());
*/
			Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = :pId");
			query.setParameter("pId", 2);
	        Conta account = (Conta) query.getSingleResult();
			manager.close(); 
	        System.out.println(account.getTitular()+"realizou "+account.getMovimentacoes().size()+" trasações");

	}
}
