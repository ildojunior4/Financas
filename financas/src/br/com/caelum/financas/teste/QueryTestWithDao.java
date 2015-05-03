package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class QueryTestWithDao {
	public static void main(String[] args){
		EntityManager manager = new JPAUtil().getEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);
	    Conta account = manager.find(Conta.class, 2);
	    
		System.out.println(dao.averageOfAccount(account,TipoMovimentacao.SAIDA));
	}
	  
}
