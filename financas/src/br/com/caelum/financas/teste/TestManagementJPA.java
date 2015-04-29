package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestManagementJPA {

	public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

     // ID existing the account on database, this case ID: 1
        Conta conta = manager.find(Conta.class, 1);

        // commit before update
        manager.getTransaction().commit();
        
        // Change account holder
        conta.setTitular("Caelum Inovation && Education"); //caelum.com.br

        manager.getTransaction().begin();
        manager.merge(conta); //merge() sync an object detached to Persistence Context
        manager.getTransaction().commit();

        manager.close();
    }

}
