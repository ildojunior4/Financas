package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class QueryTestWithNamedQuery {
	public static void main(String Args[]){
		EntityManager manager = new JPAUtil().getEntityManager();

		Conta account = new Conta();
		account.setId(3);

		MovimentacaoDao dao = new MovimentacaoDao(manager);
		Long result = dao.getResultOperationsAll(account);

		System.out.println(result);
	}
}
